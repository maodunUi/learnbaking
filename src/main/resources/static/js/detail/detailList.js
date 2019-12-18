layui.use('table', function () {
    var table = layui.table,
        form = layui.form;
    /* 表格渲染 */
    table.render({
        elem: '#test',
        id: 'idTest',
        // url: '/user/get',
        url:'/DetailAction/getBasic',
        title: '食谱数据表',
        toolbar: '#toolbarDemo',
        totalRow: true
        ,response: {
            countName: 'total' //规定数据总数的字段名称，默认：count
            ,dataName: 'rows' //规定数据列表的字段名称，默认：data
        },
        cols: [
            [{type: 'radio',fixed: 'left'},
                {field: 'id',title: 'ID',width: 60,fixed: 'left',unresize: true,sort: true,fixed: true,totalRowText: '合计'},
                {field: 'title',title: '食谱标题',width: 80,},
                {field: 'imgUrl',title: '展示图片',width: 150,templet: '<div><img src="{{d.imgUrl}}"/></div>'},
                {field: 'memo',title: '描述',width: 180,sort: true,templet: '#mysex'},
                {field: 'tips',title: '小贴士',width: 280,sort: true},
                {field: 'introduce',title: '介绍',width: 280,sort: true},
                {field: 'materials',title: '用料',width: 280},
                {field: 'step',title: '步骤',width: 120,sort: true},
                {fixed: 'right',title: '操作',toolbar: '#barDemo',width: 100}]
        ],
        page: true,
    });
    /*搜索*/
    var $ = layui.$, active = {
        reload: function(){
            alert(1)
            //执行重载UserAction/get
            table.reload('idTest', {
                url: '/DetailAction/getBasic'
                ,where:{
                    name : $("input[name='realName']").val(),
                    telphone : $("input[name='telphone']").val(),
                }
            },'data');
        }
    };

    //监听用户是否正常
    form.on('switch(stateDemo)', function(obj){
        //layer.tips(this.value + ' ' + this.name + '：'+ obj.elem.checked, obj.othis);
        console.log(obj)
        var state = null ;
        if (obj.elem.checked == true){
            state = 1 ;
        } else {
            state = 0 ;
        }
        layer.confirm('改变用户状态吗?', function (index) {
            table.reload('idTest', {
                url: '/user/status?id=' + obj.value //obj.value是id
                ,where: {
                    state:state
                } //设定异步数据接口的额外参数
                //,height: 300
            });
            layer.close(index);
        });
    });

    $('.demoTable .layui-btn').on('click', function () {
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });


});