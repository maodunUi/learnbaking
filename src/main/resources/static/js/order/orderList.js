layui.use('table', function () {
    var table = layui.table,
        form = layui.form;
    /* 表格渲染 */
    table.render({
        elem: '#test',
        id: 'idTest',
        // url: '/user/get',
        url:'/OrderAction/list',
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
                {field: 'number',title: '订单号',width: 180,},
                {field: 'name',title: '订单名',width: 180,},
                {field: 'price',title: '价格',width: 150,templet: '<div><img src="{{d.imgUrl}}"/></div>'},
                {field: 'subject',title: '描述',width: 280,sort: true,templet: '#mysex'},
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
                url: '/OrderAction/list'
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