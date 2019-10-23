package cn.ymt.query;
import cn.ymt.view.CourseView;
public class CourseQueryParams extends QueryParams<CourseView> {
    private String str ;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}