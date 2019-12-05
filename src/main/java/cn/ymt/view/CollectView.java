package cn.ymt.view;
import cn.ymt.pojo.Collect;
import cn.ymt.pojo.Course;
import cn.ymt.pojo.Detail;

public class CollectView extends Collect {
    private Detail detail ;
    private Course course ;

    public Detail getDetail() {
        return detail;
    }

    public void setDetail(Detail detail) {
        this.detail = detail;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}