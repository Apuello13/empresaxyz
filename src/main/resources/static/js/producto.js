var Jsonp = [
    {id: 'nombre', required: true},
    {id: 'valor', required: true},
    {id: 'cantidad', required: true},
    {id: 'categoria', required: true},
    {id: 'promocion', required: true}

];

$('.btn-add').on('click', function () {
    ResetForm('#modalPro');
    $('#modalPro').modal('show');
});

$('#btnSavePro').on('click', function () {
    if (isJsonValidate(Jsonp)) {
        JsonDatapro = {
            id: !$(this).attr('data-id') ? 0 : $(this).attr('data-id'),
            nombre: $('#nombre').val(),
            codigo: $('#cod').val(),
            valor: $('#valor').val(),
            cantidad: $('#cantidad').val(),
            categoria: $('#categoria').val(),
            promocion: $('#promocion').val()
        };
        PostService(JSON.stringify(JsonDatapro), "/produc/saveP", (res) => {
            if (res.id) {
                $('#modalPro').modal('hide');
                toastr.success("Se ha registrado el producto en el sistema", "EmpresaXYZ");
                LoadTable();
            }else{
                toastr.error("Verifique el código del producto, ya existe", "EmpresaXYZ");
            }
        });
    }
});
function LoadTable() {
    $('#grid-producto tbody tr').remove();
    nombre = $('#search').val();
    GetService(`/produc/get?nombre=${nombre}`, (res) => {
        $.each(res, (i, x) => {
            $('#grid-producto tbody').append(`<tr>
                <td>${x.nombre}</td>
                <td>${x.valor}</td>
                <td>${x.cantidad}</td>
                <td>${x.categoria}</td>
                <td><span class="bx bxs-pencil" data-id="${x.id}"></span></td>
                <td><span class="bx bxs-trash-alt" data-id="${x.id}"></span></td>
            </tr>`);
        });
        $('#grid-producto tbody tr td').find('.bxs-pencil').on('click', function () {
            id = $(this).attr('data-id');
            GetService(`produc/getById/${id}`, (res) => {
                ResetForm('#modalPro');
                $('#btnSavePro').attr('data-id', res.id);
                $('#nombre').val(res.nombre);
                $('#cod').val(res.codigo);
                $('#valor').val(res.valor);
                $('#cantidad').val(res.cantidad);
                $('#categoria').val(res.categoria);
                $('#promocion').val(res.promocion);
                $('#modalPro').modal('show');
            });
        });

        $('#grid-producto tbody tr td').find('.bxs-trash-alt').on('click', function () {
            id = $(this).attr('data-id');
            if (confirm('¿Quiere eliminar este ptoducto?')) {
                GetService(`produc/eliminarBy/${id}`, () => LoadTable());
            }
        });
    });
}

$('#search').on('change', function () {
    LoadTable();
});

$(document).ready(function () {
    LoadTable();
});