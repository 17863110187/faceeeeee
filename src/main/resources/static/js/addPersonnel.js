$("#submit").click(function () {
    $.ajax({
        type: "POST",
        dataType:"json",
        url:"/userinfo/addUser",
        data: {
            id: $("#Username").val(),
            phone: $("#Phone").val(),
            password: $("#password").val(),
            department: $("#department").val()
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