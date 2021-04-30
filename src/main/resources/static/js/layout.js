$('.my-container').css('height', $(window).height())

function PostService(JsonData, url, callback) {
    $.ajax(`${url}`, {
        type: "POST",
        data: JsonData,
        contentType: "application/json",
        success: function (response) {
            callback(response);
        },
        error: function (error) {
            callback(error);
        }
    });
}

function GetService(url, callback){
    $.ajax(`${url}`, {
        type: "GET",
        contentType: "application/json",
        success: function (response) {
            callback(response);
        },
        error: function (error) {
            callback(error);
        }
    });
}

$('.bx-log-out').on('click', function () {
    localStorage.setItem('session', '');
});

function ResetForm(modal) {
    $('#btnSave').attr('data-id', 0);
    $(modal).find('.form-control').val('').removeClass('error');
}

function isJsonValidate(Json) {
    bool = true;
    $.each(Json, (i, e) => {
        if (e.required & $(`#${e.id}`).val() === '') {
            $(`#${e.id}`).addClass('error');
            bool = false;
        }
    });
    return bool;
}

$(document).ready(function () {
    /*if (!localStorage.getItem('session')) {
     alert('Inicie sesión para continuar');
     window.location = '/';
     } else {
     }*/
    $('.welcome').text(`Bienvenido ${JSON.parse(localStorage.getItem('session')).nombre}`);
    path = window.location.pathname;
    $.each($('.list-items'), function (i, e) {
        if ($(this).find('a').attr('href') === path) {
            $(this).addClass('active');
        }
    });
});