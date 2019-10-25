package cn.ymt.view.simple;
import cn.ymt.pojo.BasicModel;
import java.util.Date;
public class CollectSimpleView extends BasicModel {
protected Integer userId;//
protected Byte type;//
protected Integer courseId;//
protected Integer detailId;//
protected Date collectTime=new Date();//
public Integer getUserId() {
return userId;
}

public void setUserId(Integer userId) {
this.userId = userId;
}
public Byte getType() {
return type;
}

public void setType(Byte type) {
this.type = type;
}
public Integer getCourseId() {
return courseId;
}

public void setCourseId(Integer courseId) {
this.courseId = courseId;
}
public Integer getDetailId() {
return detailId;
}

public void setDetailId(Integer detailId) {
this.detailId = detailId;
}
public Date getCollectTime() {
return collectTime;
}

public void setCollectTime(Date collectTime) {
this.collectTime = collectTime;
}

}