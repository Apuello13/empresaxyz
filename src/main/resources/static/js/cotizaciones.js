var Json = [
    {id: 'title', required: true},
    {id: 'cliente', required: true},
    {id: 'producto', required: true},
];

$('.btn-add').on('click', function () {
    ResetForm('#modalCotiz');
    $('#modalCotiz').modal('show');
});

function LoadSelect() {
    GetService("clients/get?nombre=", res => {
        res.map(client =>
            $('#cliente')
                    .append(`<option value="${client.id}">${client.nombre}</option>`));
    });
    GetService("/produc/get?nombre=", res => {
        res.map(product =>
            $('#producto')
                    .append(`<option value="${product.id}">${product.nombre}</option>`));
    });
}

function LoadCotizacion() {
    $('.cotizacion-list').find('li').remove();
    GetService("cotizacion/get?titulo=", res => {
        res.map(cotizacion => {
            $('.cotizacion-list').append(`<li class="item">
                <div>
                    <span data-id="${cotizacion.id}" id="fecha">${cotizacion.created}</span>
                    <span class="bx bx-dots-horizontal-rounded" style="float: right;"></span>
                </div>
                <div>
                      <span><strong>${cotizacion.titulo}</strong></span><br>
                      <span>${cotizacion.description}</span>
                </div>
	</li>`);
        });
        $('.item').on('click', function () {
            id = $(this).find('div span').attr('data-id');
            GetService(`cotizacion/getById/${id}`, res => {
                $('.container-details').fadeIn("fast");
                $('#ntitle').text(res.titulo);
                $('#id-cotizacion').val(id);
                $('.list-detalle').find('li').remove();
                res.detalle.map(detalle => $('.list-detalle')
                        .append(`<li><strong>${detalle.fecha}</strong> ${detalle.observacion}</li>`))
                console.log(res);
            });
        });
    });
}

$('#btnSave').on('click', function () {
    if (isJsonValidate(Json)) {
        JsonData = {
            id: !$(this).attr('data-id') ? 0 : $(this).attr('data-id'),
            titulo: $('#title').val(),
            vendedor: {id: JSON.parse(localStorage.getItem('session')).id},
            cliente: {id: $('#cliente').val()},
            producto: {id: $('#producto').val()},
            description: $('#descrip').val(),
            estado: "COTIZADO"
        };
        PostService(JSON.stringify(JsonData), "cotizacion/save", res => {
            if (res) {
                $('#modalCotiz').modal('hide');
                toastr.success("Cotizacion registrado con exito", "EmpresaXYZ");
                LoadCotizacion();
            } else {
                toastr.error("No se pudo guardar la cotizacion", "EmpresaXYZ");
            }
        });
    }
});

$('#btnObservacion').on('click', function () {
    JsonData = {id: 0, observacion: $('#observacion').val(), cotizacion: {id: $('#id-cotizacion').val()}};
    PostService(JSON.stringify(JsonData), "detail/save", res => {
        $('.list-detalle').append(`<li><strong>${res.fecha.toLocaleString()}</strong> ${res.observacion}</li>`);
        $('#observacion').val('');
    });
});

$(document).ready(function () {
    LoadSelect();
    LoadCotizacion();
});