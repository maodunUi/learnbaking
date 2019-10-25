package cn.ymt.view;
import cn.ymt.pojo.Course;
import cn.ymt.pojo.Shopcart;
public class ShopcartView extends Shopcart {
    private Course course ;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}