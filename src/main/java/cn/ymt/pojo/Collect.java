package cn.ymt.pojo;
import java.util.Date;
public class Collect extends BasicModel {
protected Integer user_id;//
protected Byte type;//
protected Integer course_id;//
protected Integer detail_id;//
protected java.util.Date collect_time=new Date();//
public Integer getUser_id() {
return user_id;
}

public void setUser_id(Integer user_id) {
this.user_id = user_id;
}
public Byte getType() {
return type;
}

public void setType(Byte type) {
this.type = type;
}
public Integer getCourse_id() {
return course_id;
}

public void setCourse_id(Integer course_id) {
this.course_id = course_id;
}
public Integer getDetail_id() {
return detail_id;
}

public void setDetail_id(Integer detail_id) {
this.detail_id = detail_id;
}
public java.util.Date getCollect_time() {
return collect_time;
}

public void setCollect_time(java.util.Date collect_time) {
this.collect_time = collect_time;
}

}