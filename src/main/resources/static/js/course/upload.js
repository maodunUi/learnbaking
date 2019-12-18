//Demo
layui.use('form', function(){
    var form = layui.form;
    form.render() ;
    //监听提交
    form.on('submit(formDemo)', function(data){
        layer.msg(JSON.stringify(data.field));
        console.log(data.field)
      /*  var d = {};
        var t = $('form').serializeArray();
        $.each(t, function () {
            d[this.name] = this.value;
        });*/
      var videos = [] ;
      var VideoView = {} ;
        VideoView.videoUrl = "aaa.com" ;
        videos.push(VideoView) ;
      data.field.videos = videos ;
        console.log(data.field)
        $.ajax({
            url: "/CourseAction/insert",
            type : 'post',
            data: JSON.stringify(data.field),
            contentType:"application/json;charset=utf-8",
            success: function (data) {
                /* layer.msg('提交成功!!!')
                $('form').reset(); */
                alert(data.msg)
                if (data.success == true){
                    $('form').reset();
                }

            }
        });
        return false;
    });
});