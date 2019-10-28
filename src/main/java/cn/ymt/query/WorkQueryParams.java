package cn.ymt.query;
import cn.ymt.view.WorkView;
public class WorkQueryParams extends QueryParams<WorkView> {
    private Integer id ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}