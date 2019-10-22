package cn.ymt.view.simple;
import cn.ymt.pojo.BasicModel;
public class UserSimpleView extends BasicModel {
protected String name;//
protected String password;//
protected String img_url;//
protected String nick_name;//
protected Byte sex;//0代表男 1代表女
protected String email;//
protected String address;//
protected Integer age;//
protected Byte state;//0不正常 1正常
protected String memo;//
protected Byte order_index;//
public String getName() {
return name;
}

public void setName(String name) {
this.name = name == null ? null : name.trim();
}
public String getPassword() {
return password;
}

public void setPassword(String password) {
this.password = password == null ? null : password.trim();
}
public String getImg_url() {
return img_url;
}

public void setImg_url(String img_url) {
this.img_url = img_url == null ? null : img_url.trim();
}
public String getNick_name() {
return nick_name;
}

public void setNick_name(String nick_name) {
this.nick_name = nick_name == null ? null : nick_name.trim();
}
public Byte getSex() {
return sex;
}

public void setSex(Byte sex) {
this.sex = sex;
}
public String getEmail() {
return email;
}

public void setEmail(String email) {
this.email = email == null ? null : email.trim();
}
public String getAddress() {
return address;
}

public void setAddress(String address) {
this.address = address == null ? null : address.trim();
}
public Integer getAge() {
return age;
}

public void setAge(Integer age) {
this.age = age;
}
public Byte getState() {
return state;
}

public void setState(Byte state) {
this.state = state;
}
public String getMemo() {
return memo;
}

public void setMemo(String memo) {
this.memo = memo == null ? null : memo.trim();
}
public Byte getOrder_index() {
return order_index;
}

public void setOrder_index(Byte order_index) {
this.order_index = order_index;
}

}