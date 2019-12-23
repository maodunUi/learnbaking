package cn.ymt.query;
import java.util.List;
public abstract class QueryParams<T extends cn.ymt.pojo.BasicModel>{

protected Integer pageSize;
protected Integer recordIndex;
protected String orderBy;
protected List<Integer> ids;
protected List<T> pojos;
protected String condition;

    //layui
    protected Integer page ;
    protected  Integer limit ; //页码

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return limit; //这里返回limit
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getRecordIndex() {
        if(page != null && limit != null){
            recordIndex = (page - 1) * limit ;
        }
        return recordIndex;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public void setRecordIndex(Integer recordIndex) {
        this.recordIndex = recordIndex;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public List<T> getPojos() {
        return pojos;
    }

    public void setPojos(List<T> pojos) {
        this.pojos = pojos;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}