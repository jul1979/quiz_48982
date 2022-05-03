$(document).ready(function () {
    $("#locales").change(function () {
        var selectedOption = $("#locales").val();
        if (selectedOption != "") {
            let url = window.location.pathname;
            window.location.replace(url + "?lang=" + selectedOption);
        }
    });
});
