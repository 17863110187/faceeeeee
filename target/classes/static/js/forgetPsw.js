$("#submit").click(function () {
    $.ajax({
        type: "POST",
        dataType:"json",
        url:"/user/resetPsw",
        data: {
            id: $("#inputUsername").val(),
            phone: $("#inputPhone").val(),
            password: $("#inputPassword").val(),
            confirm: $("#inputPasswordAgain").val()
        },
        async: false,                 //异步请求？
        success: function (data) {
            if(data.success){
                alert(data.message);
            }else {
                alert(data.message);
            }
        }
    });
});