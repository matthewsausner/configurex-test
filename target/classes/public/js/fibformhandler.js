$(document).ready(function() {
    $('#calculateButton').click(function() {
        $('#calculateButton').prop('disabled', true).html('Calculating...');
        $('#fibResult').empty();
        $.post('/nextfib?userInput=' + $('#fibInput').val()).done(function(res) {
            if (res === "You must enter a number.") {
                $('<div class="alert alert-danger" role="alert">' + res + '</div>').appendTo('#fibResult');
                
            } else {
                $('<div class="alert alert-success" role="alert">' + res + '</div>').appendTo('#fibResult');
            }
            $('#calculateButton').prop('disabled', false).html('Calculate');
        });
    });
});