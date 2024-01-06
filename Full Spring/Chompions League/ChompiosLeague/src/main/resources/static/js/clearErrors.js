$(document).ready(function() {
    $("#userName, #email, #password, #confirm, #teamName, #playerName,#skill").on("input", function() {
        var errorsId = $(this).attr("id") + "Errors";
        $("#" + errorsId).html(""); // Clear the error messages
    });
});