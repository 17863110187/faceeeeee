var canvas = document.getElementById("canvas"),
    context = canvas.getContext("2d"),
    video = document.getElementById("video"),
    videoObj = { "video": true },
    workState,newPic;

getWorkState();

window.addEventListener("DOMContentLoaded", function() {
    // Grab elements, create settings, etc.
    errBack = function(error) {
        console.log("Video capture error: ", error.code);
    };
    // Put video listeners into place
    if(navigator.getUserMedia) { // Standard
        // 想要获取一个最接近 1280x720 的相机分辨率
        var constraints = { audio: false, video: { width: 1280, height: 720 } };
        navigator.mediaDevices.getUserMedia(constraints)
            .then(function(mediaStream) {
                video.srcObject = mediaStream;
                video.onloadedmetadata = function(e) {
                    video.play();
                };
            })
            .catch(function(err) { console.log(err.name + ": " + err.message); }); // 总是在最后检查错误
        // alert("支持navigator.getUserMedia");
    } else if(navigator.webkitGetUserMedia) { // WebKit-prefixed
        // alert("支持navigator.webkitGetUserMedia");
        navigator.webkitGetUserMedia(videoObj, function(stream){
            video.src = window.webkitURL.createObjectURL(stream);
            video.play();
        }, errBack);
    }
    else if(navigator.mozGetUserMedia) { // Firefox-prefixed
        // alert("支持navigator.mozGetUserMedia");
        navigator.mozGetUserMedia(videoObj, function(stream){
            video.src = window.URL.createObjectURL(stream);
            video.play();
        }, errBack);
    }
}, false);

function getWorkState() {
    $.ajax({
        type: "POST",
        dataType:"json",
        url:"/user/getWorkState",
        success: function (data) {
            if(data.success){
                workState = data.data;
                if(workState){
                    $("#snap").html("打卡下班");
                }else {
                    $("#snap").html("打卡上班");
                }
            }else {
                alert(data.message);
            }
        }
    });
}

$("#snap").click(function () {
    context.drawImage(video, 0, 0, 640, 480);
    newPic = canvas.toDataURL('image/jpg').split(",")[1];  //returns
    baiduFaceCheck();
});

function baiduFaceCheck() {
    $.ajax({
        type: "POST",
        dataType:"json",
        url:"/attence/faceCheck",
        data: {
            picture: newPic
        },
        async: false,                 //异步请求？
        success: function (data) {
            if(data.success){
                var result=JSON.parse(data.message);
                console.log(result);
                if(result.error_code==0){
                    if(result.result.score>86){
                        insertAttence();
                    }else {
                        alert("打卡失败");
                    }
                }else {
                    alert("打卡失败");
                    return 0;
                }
            }else {
                alert(data.message);
                return 0;
            }
        }
    });
}


function insertAttence() {
    $.ajax({
        type: "POST",
        dataType:"json",
        url:"/attence/insertAttence",
        data: {
            workState:workState
        },
        async: false,                 //异步请求？
        success: function (data) {
            if(data.success){
                alert(data.message);
                location.reload(true);
            }else {
                alert(data.message);
            }
        }
    });
}