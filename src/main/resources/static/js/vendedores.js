var Json = [
    {id: 'nombre', required: true},
    {id: 'apellido', required: true},
    {id: 'iden', required: true},
    {id: 'fecha_naci', required: true},
    {id: 'direc', required: true},
    {id: 'telefono', required: true}
];

$('.btn-add').on('click', function () {
    ResetForm('#modalVende');
    $('#modalVende').modal('show');
});

$('#btnSave').on('click', function () {
    if (isJsonValidate(Json)) {
        JsonData = {
            id: !$(this).attr('data-id') ? 0 : $(this).attr('data-id'),
            username : $('#username').val(),
            password : $('#password').val(),
            nombre: $('#nombre').val(),
            apellido: $('#apellido').val(),
            identificacion: $('#iden').val(),
            fecha_naci: $('#fecha_naci').val(),
            dirreccion: $('#direc').val(),
            telefono: $('#telefono').val()
        };
        PostService(JSON.stringify(JsonData), "vendors/save", (res) => {
            $('#modalVende').modal('hide');
            LoadTable();
        });
    }
});

function LoadTable() {
    $('#grid-vendedores tbody tr').remove();
    GetService("/vendors/get", (res) => {
        $.each(res, (i, e) => {
            $('#grid-vendedores tbody').append(`<tr>
                <td>${e.nombre}</td>
                <td>${e.apellido}</td>
                <td>${e.identificacion}</td>
                <td>${e.telefono}</td>
                <td><span class="bx bxs-pencil" data-id="${e.id}"></span></td>
                <td><span class="bx bxs-trash-alt" data-id="${e.id}"></span></td>
            </tr>`);
        });
        $('#grid-vendedores tbody tr td').find('.bxs-pencil').on('click', function () {
            id = $(this).attr('data-id');
            GetService(`vendors/getById/${id}`, (res) => {
                ResetForm('#modalVende');
                $('#btnSave').attr('data-id', res.id);
                $('#username').val(res.username);
                $('#password').val(res.password);
                $('#nombre').val(res.nombre);
                $('#apellido').val(res.apellido);
                $('#iden').val(res.identificacion);
                $('#fecha_naci').text(new Date(res.fecha_naci).toLocaleDateString());
                $('#direc').val(res.dirreccion);
                $('#telefono').val(res.telefono);
                $('#modalVende').modal('show');
            });
        });

        $('#grid-vendedores tbody tr td').find('.bxs-trash-alt').on('click', function () {
            id = $(this).attr('data-id');
            if (confirm('¿Quiere eliminar este vendedor?')) {
                GetService(`vendors/deleteById/${id}`,() => LoadTable());
            }
        });
    });
}

$(document).ready(function () {
    LoadTable();
});