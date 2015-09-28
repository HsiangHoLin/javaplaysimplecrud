$(document).ready(function () {
    var query = '';
    $.get('persons', query, process);
});

function process(data) {

    for (var i in data) {
        $('ul').append(
            '<li>'+
            data[i].name+
            "<form action=\"/delperson/" + data[i].id + "\" method=\"post\"><button>Del</button></form>"+
            '</li>');
    }
}