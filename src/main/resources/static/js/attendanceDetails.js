$.ajax({
    type: "POST",
    dataType:"json",
    url:"/attendance/getAllAttendance",
    data: {
        year: $("#year").val(),
        month: $("#month").val()
    },
    async: false,                 //异步请求？
    success: function (data) {
        length = data.length;
        var tableString = "";
        for(var i=0;i<length;i++){
            tableString+="<tr>";
            tableString+="<td>"+data[i].inTime.substring(0,10)+"到"+data[i].outTime.substring(0,10)+"</td>>";
            tableString+="<td>"+data[i].inTime.substring(11,16)+"</td>>";
            tableString+="<td>"+data[i].outTime.substring(11,16)+"</td>>";
            tableString+="</tr>";
        }
        console.log(data);
        $("#attendanceDetail").html(tableString);
    }
});
function getAttendance() {

        $.ajax({
            type: "POST",
            dataType:"json",
            url:"/attendance/getAttendance",
            data: {
                year: $("#year").val(),
                month: $("#month").val()
            },
            async: false,                 //异步请求？
            success: function (data) {
                length = data.length;
                var tableString = "";
                for(var i=0;i<length;i++){
                    tableString+="<tr>";
                    tableString+="<td>"+data[i].inTime.substring(0,10)+"到"+data[i].outTime.substring(0,10)+"</td>>";
                    tableString+="<td>"+data[i].inTime.substring(11,16)+"</td>>";
                    tableString+="<td>"+data[i].outTime.substring(11,16)+"</td>>";
                    tableString+="</tr>";
                }
                console.log(data);
                $("#attendanceDetail").html(tableString);
            }
        });

}