$(document).ready(function () {

    $("#registform").submit(function (event) {

        //stop submit the form, we will post it manually.
        event.preventDefault();

        fire_ajax_submit();

    });

});

function fire_ajax_submit() {

    var userdata = {}
    userdata["phonenumber"] = $("#phonenumber").val();
    userdata["gender"] = $("#gender").val();
    userdata["email"] = $("#email").val();
    userdata["firstName"] = $("#firstName").val();
    userdata["lastName"] = $("#lastName").val();
    var day = $("#day").val();
    var month = $("#month").val();
    var year = $("#year").val();
    var dob = new Date(year,month,day);
    userdata["dob"] = dob;
    //userdata["email"] = $("#email").val();

    $("#submit").prop("disabled", true);

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/saveuser2",
        data: JSON.stringify(userdata),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {

            console.log("SUCCESS : ", data);
            $("#registform :input").prop("disabled", true);
            $("#box").prop("hidden", true);
            $("#boxlogin").prop("hidden", false);
            
        },
        error: function (e) {

            console.log("ERROR : ", e);
            $("#registform :input").prop("disabled", false);

        }
    });

}