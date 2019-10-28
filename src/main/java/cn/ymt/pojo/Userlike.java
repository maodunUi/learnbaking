package cn.ymt.pojo;
public class Userlike extends BasicModel {
protected Integer userId;//
protected Byte type;//
protected Integer workId;//
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
public Integer getWorkId() {
return workId;
}

public void setWorkId(Integer workId) {
this.workId = workId;
}

}