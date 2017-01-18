/**
 * Created by burakdagli on 16.01.2017.
 */
$(document).ready(function() {
    $('#submitButton').click(function(){
        var integerInput = $('#intInputID').val();
        $.post("/api/convert", { // Data Sending With Request To Server
            integerInput: integerInput
            },function(response, status){
            console.log(response);
            if(response['result']){
                $("#labelID").html(response['result'] );
                $("#errorText").html("");
            } else if (response['errorMessage']){
                $("#errorText").html(response['errorMessage'] );
                $("#labelID").html("");
            }
        }, "json");
    });
});