$("#submit").click(function () {
    $.ajax({
        type: "POST",
        dataType:"json",
        url:"/user/modifyifo",
        data: {
            name: $("#inputname").val(),
            phone: $("#inputphone").val(),
            email: $("#inputemail").val(),
            address: $("#inputaddress").val()
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