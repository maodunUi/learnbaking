package cn.ymt.view.simple;
import cn.ymt.pojo.BasicModel;
import java.util.Date;
public class OrderSimpleView extends BasicModel {
protected Integer courseId;//
protected Date orderTime=new Date();//
protected Byte payType;//
protected Integer userId;//
protected Integer publisherId;//对应用户表user的id(发布者)
protected Byte orderIndex;//
protected Byte state;//
protected Double price;//
protected String number;//订单号
protected String subject;//订单详情
protected String name;//订单名称
public Integer getCourseId() {
return courseId;
}

public void setCourseId(Integer courseId) {
this.courseId = courseId;
}
public Date getOrderTime() {
return orderTime;
}

public void setOrderTime(Date orderTime) {
this.orderTime = orderTime;
}
public Byte getPayType() {
return payType;
}

public void setPayType(Byte payType) {
this.payType = payType;
}
public Integer getUserId() {
return userId;
}

public void setUserId(Integer userId) {
this.userId = userId;
}
public Integer getPublisherId() {
return publisherId;
}

public void setPublisherId(Integer publisherId) {
this.publisherId = publisherId;
}
public Byte getOrderIndex() {
return orderIndex;
}

public void setOrderIndex(Byte orderIndex) {
this.orderIndex = orderIndex;
}
public Byte getState() {
return state;
}

public void setState(Byte state) {
this.state = state;
}
public Double getPrice() {
return price;
}

public void setPrice(Double price) {
this.price = price;
}
public String getNumber() {
return number;
}

public void setNumber(String number) {
this.number = number == null ? null : number.trim();
}
public String getSubject() {
return subject;
}

public void setSubject(String subject) {
this.subject = subject == null ? null : subject.trim();
}
public String getName() {
return name;
}

public void setName(String name) {
this.name = name == null ? null : name.trim();
}

}