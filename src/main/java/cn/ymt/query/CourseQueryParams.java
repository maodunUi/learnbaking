package cn.ymt.query;
import cn.ymt.view.CourseView;
public class CourseQueryParams extends QueryParams<CourseView> {
    private String str ;
    private Integer categoryId ;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}