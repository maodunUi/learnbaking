package cn.ymt.pojo;
import java.util.Date;
public class Video extends BasicModel {
protected String videoUrl;//
protected String memo;//
protected Byte state;//
protected Integer userId;//
protected Date createTime=new Date();//
protected Integer orderIndex;//
protected Integer courseId;//
public String getVideoUrl() {
return videoUrl;
}

public void setVideoUrl(String videoUrl) {
this.videoUrl = videoUrl == null ? null : videoUrl.trim();
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
public Integer getUserId() {
return userId;
}

public void setUserId(Integer userId) {
this.userId = userId;
}
public Date getCreateTime() {
return createTime;
}

public void setCreateTime(Date createTime) {
this.createTime = createTime;
}
public Integer getOrderIndex() {
return orderIndex;
}

public void setOrderIndex(Integer orderIndex) {
this.orderIndex = orderIndex;
}
public Integer getCourseId() {
return courseId;
}

public void setCourseId(Integer courseId) {
this.courseId = courseId;
}

}