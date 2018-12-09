$("#submit").click(function () {
    $.ajax({
        type: "POST",
        dataType:"json",
        url:"/changepwd/changePsw",
        data: {
            oldPasswords: $("#inputOldpsd").val(),
            password: $("#inputPassword").val(),
            confirm: $("#inputPassword2").val()
        },
        async: false,                 //异步请求？
        success: function (data) {
            if(data.success){
                alert(data.message);
            }else {
                alert(data.message);
            }
        }
    })
});