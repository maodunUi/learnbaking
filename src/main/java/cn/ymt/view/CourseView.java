package cn.ymt.view;
import cn.ymt.pojo.Course;
import cn.ymt.pojo.Video;

import java.util.List;

public class CourseView extends Course {
    private List<VideoView> videos ;

    public List<VideoView> getVideos() {
        return videos;
    }

    public void setVideos(List<VideoView> videos) {
        this.videos = videos;
    }
}