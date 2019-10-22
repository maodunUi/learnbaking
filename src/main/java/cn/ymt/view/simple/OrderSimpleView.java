package cn.ymt.view.simple;
import cn.ymt.pojo.BasicModel;
import java.util.Date;
public class OrderSimpleView extends BasicModel {
protected Integer course_id;//
protected java.util.Date order_time=new Date();//
protected Byte pay_type;//
protected Integer user_id;//
protected Integer publisher_id;//对应用户表user的id(发布者)
protected Byte order_index;//
protected Byte state;//
protected Double price;//
protected String number;//订单号
protected String subject;//订单详情
protected String name;//订单名称
public Integer getCourse_id() {
return course_id;
}

public void setCourse_id(Integer course_id) {
this.course_id = course_id;
}
public java.util.Date getOrder_time() {
return order_time;
}

public void setOrder_time(java.util.Date order_time) {
this.order_time = order_time;
}
public Byte getPay_type() {
return pay_type;
}

public void setPay_type(Byte pay_type) {
this.pay_type = pay_type;
}
public Integer getUser_id() {
return user_id;
}

public void setUser_id(Integer user_id) {
this.user_id = user_id;
}
public Integer getPublisher_id() {
return publisher_id;
}

public void setPublisher_id(Integer publisher_id) {
this.publisher_id = publisher_id;
}
public Byte getOrder_index() {
return order_index;
}

public void setOrder_index(Byte order_index) {
this.order_index = order_index;
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