var Json = [{id: 'nombre', required: true}];

$('.btn-add').on('click', function () {
    ResetForm('#modalClient');
    $('#modalClient').modal('show');
});

$('#btnSave').on('click', function () {
    if(isJsonValidate(Json)){
        JsonData = {
          id : !$(this).attr('data-id') ? 0 : $(this).attr('data-id'),
          nombre : $('#nombre').val(),
          tipo_persona : $('#tipo').val(),
          identificacion : $('#iden').val(),
          telefono : $('#phone').val(),
          direccion : $('#direc').val(),
          empresa : $('#empresa').val(),
          correo : $('#email').val()
        };
        PostService(JSON.stringify(JsonData), 'clients/save', () => {
            $('#modalClient').modal('hide');
            LoadTable();
        });
    }
});

function LoadTable(){
    $('#grid-clientes tbody tr').remove();
    GetService('clients/get', res => {
       $.each(res, (i, e) => {
            $('#grid-clientes tbody').append(`<tr>
                <td>${e.nombre}</td>
                <td>${e.tipo_persona}</td>
                <td>${e.correo}</td>
                <td><span class="bx bxs-pencil" data-id="${e.id}"></span></td>
                <td><span class="bx bxs-trash-alt" data-id="${e.id}"></span></td>
            </tr>`);
        });
        $('#grid-clientes tbody tr').find('.bxs-pencil').on('click', function () {
            id = $(this).attr('data-id');
            GetService(`clients/getById/${id}`, res => {
                ResetForm('#modalClient');
                $('#nombre').val(res.nombre);
                $('#iden').val(res.identificacion);
                $('#tipo').val(res.tipo_persona);
                $('#direc').val(res.direccion);
                $('#phone').val(res.telefono);
                $('#empresa').val(res.empresa);
                $('#email').val(res.correo);
                $('#modalClient').modal('show');
            });
        });
        
        $('#grid-clientes tbody tr').find('.bxs-trash-alt').on('click', function (){
            id = $(this).attr('data-id');
            if(confirm('¿Deseas eliminar este cliente?')){
             GetService(`clients/deleteById/${id}`, () => LoadTable());   
            }
        });
    });
}

$(document).ready(function () {
    LoadTable();
});