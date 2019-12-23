package cn.ymt.query;
import cn.ymt.view.VideoView;
public class VideoQueryParams extends QueryParams<VideoView> {
    private Integer courseId ;

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }
}