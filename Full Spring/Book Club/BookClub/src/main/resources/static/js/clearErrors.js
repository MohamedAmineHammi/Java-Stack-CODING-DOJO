$(document).ready(function() {
    $("#userName, #email, #password, #confirm, #bookTitle,bookAuthor,bookThought,").on("input", function() {
        var errorsId = $(this).attr("id") + "Errors";
        $("#" + errorsId).html(""); // Clear the error messages
    });
});