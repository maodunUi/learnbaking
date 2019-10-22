package cn.ymt.pojo;
public class Shopcart extends BasicModel {
protected Integer course_id;//
protected Integer user_id;//
protected Byte order_index;//
protected String memo;//
protected Byte state;//
public Integer getCourse_id() {
return course_id;
}

public void setCourse_id(Integer course_id) {
this.course_id = course_id;
}
public Integer getUser_id() {
return user_id;
}

public void setUser_id(Integer user_id) {
this.user_id = user_id;
}
public Byte getOrder_index() {
return order_index;
}

public void setOrder_index(Byte order_index) {
this.order_index = order_index;
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