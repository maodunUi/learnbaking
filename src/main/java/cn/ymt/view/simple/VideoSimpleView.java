package cn.ymt.view.simple;
import cn.ymt.pojo.BasicModel;
import java.util.Date;
public class VideoSimpleView extends BasicModel {
protected String video_url;//
protected String memo;//
protected Byte state;//
protected Integer user_id;//
protected java.util.Date create_time=new Date();//
protected Integer order_index;//
protected Integer course_id;//
public String getVideo_url() {
return video_url;
}

public void setVideo_url(String video_url) {
this.video_url = video_url == null ? null : video_url.trim();
}
public String getMemo() {
return memo;
}

public void setMemo(String memo) {
this.memo = memo == null ? null : memo.trim();
}
public Byte getState() {
return state;
}

public void setState(Byte state) {
this.state = state;
}
public Integer getUser_id() {
return user_id;
}

public void setUser_id(Integer user_id) {
this.user_id = user_id;
}
public java.util.Date getCreate_time() {
return create_time;
}

public void setCreate_time(java.util.Date create_time) {
this.create_time = create_time;
}
public Integer getOrder_index() {
return order_index;
}

public void setOrder_index(Integer order_index) {
this.order_index = order_index;
}
public Integer getCourse_id() {
return course_id;
}

public void setCourse_id(Integer course_id) {
this.course_id = course_id;
}

}