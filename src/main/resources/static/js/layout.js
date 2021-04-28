$('.my-container').css('height', $(window).height())

function Service(JsonData, url, method, callback) {
    $.ajax(`${url}`, {
        type: `${method}`,
        data: JsonData,
        contentType: "application/json",
        success: function (response) {
            callback(response);
        },
        error: function (error) {
            callback(error);
        }
    })
}

function ResetForm(modal) {
    $(modal).find('.form-control').val('').removeClass('error');
}

function isJsonValidate(Json) {
    bool = true;
    $.each(Json, (i, e) => {
        if (e.required & $(`#${e.id}`).val() === ''){
            $(`#${e.id}`).addClass('error');
            bool = false;
        }   
    });
    return bool;
}


$(document).ready(function () {
    path = window.location.pathname;
    $.each($('.list-items'), function (i, e) {
        if ($(this).find('a').attr('href') === path) {
            $(this).addClass('active');
        }
    });
});