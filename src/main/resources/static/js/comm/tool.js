var toolUtil = {
    //传入元素对象 -- 回到顶部
    toTop:function(event){
        event.addEventListener('click', function () {
            timer = setInterval(function () {
                var osTop = document.documentElement.scrollTop || document.body.scrollTop;
                var speed = Math.floor(-osTop / 5);
                var isTop = true;
                document.documentElement.scrollTop = document.body.scrollTop = osTop + speed;
                if (osTop < 120) {
                    clearInterval(timer);
                }
    }, 50)
})
}}

 //<summary>创建cookies</summary>
 function setCookie(name,value){
    var Days = 30;
    var exp = new Date(); 
    exp.setTime(exp.getTime() + Days*24*60*60*1000);
    document.cookie = name + "="+ escape(value) + ";expires=" + exp.toGMTString();
  }

  /* 得到cookie */
  function getCookie(name) {
    var arr, reg = new RegExp("(^| )" + name + "=([^;]*)(;|$)");
    if (arr = document.cookie.match(reg)) {
      return unescape(arr[2]);
    } else {
      return null;
    }
  }
/* 表单提交改为ajax提交 序列化json */
  $("#submit").on('click', function () {
    var d = {};
    var t = $('form').serializeArray();
    $.each(t, function () {
      d[this.name] = this.value;
    });
    $.ajax({
      url: "userdiary/insert",
      data: d,
      success: function (data) {
        /* layer.msg('提交成功!!!')
        $('form').reset(); */
      }
    });
  });

  /*ajax 提交json数据到后台*/
/* $.ajax({
    url: "house/insert",
    method:"POST",
    contentType:"application/json;charset=utf-8",
    success: function (data) {
        

    }
}); */

//key(需要检错的键） url（传入的需要分割的url地址）
function getSearchString(key,Url) {
    // 获取URL中?之后的字符
    var str = Url;
    str = str.substring(1,str.length);
    // 以&分隔字符串，获得类似name=xiaoli这样的元素数组
    var arr = str.split("&");
    var obj = new Object();

    // 将每一个数组元素以=分隔并赋给obj对象
    for(var i = 0; i < arr.length; i++) {
        var tmp_arr = arr[i].split("=");
        obj[decodeURIComponent(tmp_arr[0])] = decodeURIComponent(tmp_arr[1]);
    }
    return obj[key];
}

/* 2019-9-9 变成 2019-09-09 */
function getFirstZeroDate(str){
  var month = str.split("-")[1]
  var day = str.split("-")[2]
  if(month < 10){
    month = "0" + month ;
  }
  if(day<10){
    day = "0" + day ;
  }
  return str.split("-")[0] + "-" + month + "-" + day ;
} 
/* 判断是否是数字 */
function isNumber(val) {
  var regPos = /^\d+(\.\d+)?$/; //非负浮点数
  var regNeg = /^(-(([0-9]+\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\.[0-9]+)|([0-9]*[1-9][0-9]*)))$/; //负浮点数
  if(regPos.test(val) || regNeg.test(val)) {
      return true;
  } else {
      return false;
  }
}

/*
*  $("body").delegate(".toggle","click", function(){
          $(this).parents('.pro-details').slideUp();
          $(this).parents('tr').hide();
      });
* */
//jb51.net/article/134312.htm JS删除数组里的某个元素方法 var emp = ['abs','dsf','sdf','fd'] emp.remove('fd');
Array.prototype.indexOf = function(val) {
    for (var i = 0; i < this.length; i++) {
        if (this[i] == val) return i;
    }
    return -1;
};

Array.prototype.remove = function(val) {
    var index = this.indexOf(val);
    if (index > -1) {
        this.splice(index, 1);
    }
};

