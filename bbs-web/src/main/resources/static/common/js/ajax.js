function fileUpload(url, formData) {
    return $.ajax({
        type : 'POST',
        url: url,
        data : formData,
        dataType: 'json',
        processData: false,
        accept: "application/json",
        contentType: false,
    });
}

function postCall(url, body) {
    console.log("asdasda")
    return $.ajax({
        type : 'POST',
        url: url,
        data : JSON.stringify(body),
        accept: "application/json",
        contentType: "application/json; charset=utf-8",
    });
}

function getCall(url) {
    return $.ajax({
        type : 'GET',
        url: url
    });
}

function getCall(url, elementId) {
    return $.ajax({
        type : 'GET',
        url: url,
        beforeSend: loadingStart(elementId)
    });
}

function putCall(url, body) {
    return $.ajax({
        type : 'PUT',
        url: url,
        data : JSON.stringify(body),
        accept: "application/json",
        contentType: "application/json; charset=utf-8"
    });
}

function deleteCall(url) {
    return $.ajax({
        type : 'DELETE',
        url: url,
        accept: "application/json",
        contentType: "application/json; charset=utf-8",
    });
}

function loadingStart(elementId) {
    var id = '#'+ elementId;
    $(id).css('display', '');
}

// ajax complete 이벤트가 바로 발동되서 각 html내에서 사용해야함.
function loadingEnd(elementId) {
    var id = '#'+ elementId;
    $(id).css('display', 'none');
}

//ajax통신 시, JSON 직렬화 Function
$.fn.converToJson = function () {
    'use strict';
    var result = {};
    var extend = function (i, element) {
        console.log(element.name)
        var node = result[element.name];
        if ('undefined' !== typeof node && node !== null) {
            if ($.isArray(node)) {
                node.push(element.value);
            } else {
                result[element.name] = [node, element.value];
            }
        } else {
            result[element.name] = element.value;
        }
    };

    $.each(this.serializeArray(), extend);
    return JSON.stringify(result);
};