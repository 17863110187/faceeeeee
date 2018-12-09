$.ajax({
    type: "POST",
    dataType:"json",
    url:"/permission/getPermission",
    success: function (data) {
        for(var i=0;i<data.data.counts;i++){
            $('li[value="' + data.data.permission[i].permission + '"]').removeClass(
                "superunplay"
            );
        }
    }
});

function toIndex(toIndex) {
    document.getElementById("iframepage").src = String(toIndex);
    $("#iframepage")
        .parent()
        .removeClass("unplay");
    $("#iframepage").bind("load", function() {
        $(this).height(
            $(this)
                .contents()
                .find("body")
                .height()
        );
    });
}
