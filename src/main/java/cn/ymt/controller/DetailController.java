package cn.ymt.controller;
import cn.ymt.pojo.Detail;
import cn.ymt.query.DetailQueryParams;
import cn.ymt.serviceDao.DetailServiceDao;
import cn.ymt.util.jsonResult;
import cn.ymt.view.DetailView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/DetailAction")
public class DetailController {
    @Autowired
    private DetailServiceDao detailServiceDao ;

    @RequestMapping("/getBasic")
    public jsonResult getBasic(DetailQueryParams queryParam) {
        try {
            List<DetailView> datas = detailServiceDao.getBasic(queryParam);
            jsonResult json = new jsonResult("查询成功");
            if (datas != null && datas.size() > 0)
                json.add(datas);
            if (queryParam.getRecordIndex() != null) {
                json.setTotal(detailServiceDao.count(queryParam));
            }
            return json;
        } catch (Exception e) {
            e.printStackTrace();
            return new jsonResult(false, "异常：" + e.getMessage());
        }
    }

    @RequestMapping("getById")
    public jsonResult getById(Integer id)throws Exception{
        DetailView detailView = detailServiceDao.getBasicById(id);
        jsonResult jsonResult = new jsonResult(true,"查询成功") ;
        jsonResult.add(detailView);
        return jsonResult ;
    }
}