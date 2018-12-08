

var length;
var dataAjax={
    "user": $("#name").val(),
    "inTime": $("#inTime").val(),
    "outTime": $("#outTime").val()
};

$.ajax({
    type: "POST",
    url:"/attence/selectAttence",
    contentType: "application/json",
    data: JSON.stringify(dataAjax),
    datatype: "json",
    success: function (data) {
        length = data.length;
        var tableString = "";
        for(var i=0;i<length;i++){
            tableString+="<tr>";
            tableString+="<td>"+data[i].id+"</td>>";
            tableString+="<td>"+data[i].name+"</td>>";
            tableString+="<td>"+data[i].inTime.replace("T", " ").replace(".000+0000","")+"</td>>";
            tableString+="<td>"+data[i].outTime.replace("T", " ").replace(".000+0000","")+"</td>>";
            tableString+="</tr>";
        }

        $("#informationTable").html(tableString);
    }
});


function find() {
    var dataAjax2={
        "user": $("#name").val(),
        "inTime": $("#inTime").val(),
        "outTime": $("#outTime").val()
    };
    // var dateArr = $("#inTime")[0].value.split("-");
    // console.log(dateArr)
    // console.log(new Date(dateArr[0],dateArr[1] -1,dateArr[2]))
    $.ajax({
        type: "POST",
        url:"/attence/selectAttence",
        contentType: "application/json",
        data: JSON.stringify(dataAjax2),
        datatype: "json",
        success: function (data) {
            length = data.length;
            var tableString = "";
            for(var i=0;i<length;i++){
                tableString+="<tr>";
                tableString+="<td>"+data[i].id+"</td>>";
                tableString+="<td>"+data[i].name+"</td>>";
                tableString+="<td>"+data[i].inTime.replace("T", " ").replace(".000+0000","")+"</td>>";
                tableString+="<td>"+data[i].outTime.replace("T", " ").replace(".000+0000","")+"</td>>";
                tableString+="</tr>";
            }

            $("#informationTable").html(tableString);
        }
    });
}
