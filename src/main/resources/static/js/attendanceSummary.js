$.ajax({
    type: "POST",
    dataType:"json",
    url:"/department/getDepartment",
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