var item;

$.ajax({
    type: "POST",
    dataType:"json",
    url:"/department/getDepartment",
    async: false,                 //异步请求？
    success: function (data) {
        if(data.success){
            var items;
            for(var i=0;i<data.data.counts;i++){
                items=items+"<option value=\""+data.data.departs[i].department+"\">"+data.data.departs[i].deptName+"</option>";
            }
            $("#department").html(items);
        }else {
            alert(data.message);
        }
    }
});

$.ajax({
    type: "POST",
    dataType:"json",
    url:"/attence/getAttenceSummary",
    success: function (data) {
        if(data.success){
            for(var i=0;i<data.data.counts;i++){
                item=item+" <tr>\n" +
                    "        <th scope=\"row\">"+i+"</th>\n" +
                    "        <td>"+data.data.summary[i].id+"</td>\n" +
                    "        <td>"+data.data.summary[i].name+"</td>\n" +
                    "        <td>"+data.data.summary[i].time+"</td>\n" +
                    "    </tr>";
            }
            $("#summary").html(item);
        }else {
            alert(data.message)
        }
    }
});

$("#submit").click(
    function () {
        loadAttenceSummary();
    }
);

function loadAttenceSummary() {
    var item;
    $.ajax({
        type: "POST",
        dataType:"json",
        url:"/attence/getAttenceSummary",
        data:{
            name:$("#name").val(),
            department: $("#department").val(),
            year: $("#year").val(),
            month: $("#month").val()
        },
        success: function (data) {
            if(data.success){
                for(var i=0;i<data.data.counts;i++){
                    item=item+" <tr>\n" +
                        "        <th scope=\"row\">"+i+"</th>\n" +
                        "        <td>"+data.data.summary[i].id+"</td>\n" +
                        "        <td>"+data.data.summary[i].name+"</td>\n" +
                        "        <td>"+data.data.summary[i].time+"</td>\n" +
                        "    </tr>";
                }
                $("#summary").html(item);
            }else {
                alert(data.message)
            }
        }
    });
}