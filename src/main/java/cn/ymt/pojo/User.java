package cn.ymt.pojo;
public class User extends BasicModel {
protected String name;//
protected String password;//
protected String imgUrl;//
protected String nickName;//
protected Byte sex;//0代表男 1代表女
protected String email;//
protected String address;//
protected Integer age;//
protected Byte state;//0不正常 1正常
protected String memo;//
protected Byte orderIndex;//
protected String telphone;//
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
public String getImgUrl() {
return imgUrl;
}

public void setImgUrl(String imgUrl) {
this.imgUrl = imgUrl == null ? null : imgUrl.trim();
}
public String getNickName() {
return nickName;
}

public void setNickName(String nickName) {
this.nickName = nickName == null ? null : nickName.trim();
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
public Byte getOrderIndex() {
return orderIndex;
}

public void setOrderIndex(Byte orderIndex) {
this.orderIndex = orderIndex;
}
public String getTelphone() {
return telphone;
}

public void setTelphone(String telphone) {
this.telphone = telphone == null ? null : telphone.trim();
}

}