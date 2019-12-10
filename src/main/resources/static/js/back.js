$(document).ready(function(){
    $.ajax({
        url: "/UserAction/get",
        success: function (data) {
            if (data.success==false){
                alert(data.msg)
            } else if(data.success == true){
                if( data.rows[0] !=null){
                    $("#userMsg").empty() ;
                    var user = data.rows[0] ;
                    var str2 = '<a href="javascript:;"><img src='+user.imgUrl+' class="layui-nav-img">'+user.nickName+'</a>'
                    str2 = str2 + '<dl class="layui-nav-child"><dd><a href="javascript:void(0);" onclick="toUser()">基本资料</a></dd><dd><a href="">安全设置</a></dd></dl>'
                    $("#userMsg").html(str2) ;
                }
            }

        }
    });
});
/*

function showData(data){
    var dataArr = data.rows[0] ;
    $("#module_nav").empty() ;
    var str = '' ;
    for(var i = 0 ; i < dataArr.length; i++){
        str = str + '<li class="layui-nav-item"><a href="javascript:void(0);" id='+dataArr[i].url+'>'+dataArr[i].name+'</a></li>'
    }
    $("#module_nav").html(str)
    if( data.rows[1] !=null){
        $("#userMsg").empty() ;
        var user = data.rows[1] ;
        var str2 = '<a href="javascript:;"><img src='+user.headImg+' class="layui-nav-img">'+user.userName+'</a>'
        str2 = str2 + '<dl class="layui-nav-child"><dd><a href="javascript:void(0);" onclick="toUser()">基本资料</a></dd><dd><a href="">安全设置</a></dd></dl>'
        $("#userMsg").html(str2) ;
    }
}
*/

function toUser(){
//  $("#divCenter").load('userMsg.html')
    $("#divCenter>iframe").attr("src","/user/userMsg.html");
    // $("#divCenter").load('上传房源.html')
}
/* 点击左侧a链接，找到id名称的html页面替代主体内容区域 */
$("body").delegate("#module_nav a","click", function(e){
    var urlVal = $(e.currentTarget).attr("id")
    if(urlVal == undefined){
        $("#divCenter>iframe").load("home.html");
    }else if(urlVal == ''){

    }else{
        $("#divCenter").load(urlVal + ".html");
        /* form.render(); */
        //  layui.element.init();
    }
});