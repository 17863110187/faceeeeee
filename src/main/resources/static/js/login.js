$("#submit").click(function () {
    $.ajax({
        type: "POST",
        dataType:"json",
        url:"/user/login",
        data: {
            id: $("#inputUsername").val(),
            psw: $("#inputPassword").val()
        },
        async: false,                 //异步请求？
        success: function (data) {
            if(data.success){
                alert(data.message);
                window.location.href="index.html";
            }else {
                alert(data.message);
            }
        }
    });
});