package cn.ymt.view.simple;
import cn.ymt.pojo.BasicModel;
public class ShopcartSimpleView extends BasicModel {
protected Integer courseId;//
protected Integer userId;//
protected Byte orderIndex;//
protected String memo;//
protected Byte state;//
public Integer getCourseId() {
return courseId;
}

public void setCourseId(Integer courseId) {
this.courseId = courseId;
}
public Integer getUserId() {
return userId;
}

public void setUserId(Integer userId) {
this.userId = userId;
}
public Byte getOrderIndex() {
return orderIndex;
}

public void setOrderIndex(Byte orderIndex) {
this.orderIndex = orderIndex;
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

}