package cn.ymt.pojo;
import java.util.Date;
public class Detail extends BasicModel {
protected String imgUrl;//
protected String title;//
protected String memo;//
protected String tips;//
protected Date addTime=new Date();//
protected Byte state;//0不正常 1正常
protected Byte orderIndex;//
protected Integer userId;//
protected String introduce;//介绍
protected String materials;//用料 用-分隔
protected String step;//步骤
public String getImgUrl() {
return imgUrl;
}

public void setImgUrl(String imgUrl) {
this.imgUrl = imgUrl == null ? null : imgUrl.trim();
}
public String getTitle() {
return title;
}

public void setTitle(String title) {
this.title = title == null ? null : title.trim();
}
public String getMemo() {
return memo;
}

public void setMemo(String memo) {
this.memo = memo == null ? null : memo.trim();
}
public String getTips() {
return tips;
}

public void setTips(String tips) {
this.tips = tips == null ? null : tips.trim();
}
public Date getAddTime() {
return addTime;
}

public void setAddTime(Date addTime) {
this.addTime = addTime;
}
public Byte getState() {
return state;
}

public void setState(Byte state) {
this.state = state;
}
public Byte getOrderIndex() {
return orderIndex;
}

public void setOrderIndex(Byte orderIndex) {
this.orderIndex = orderIndex;
}
public Integer getUserId() {
return userId;
}

public void setUserId(Integer userId) {
this.userId = userId;
}
public String getIntroduce() {
return introduce;
}

public void setIntroduce(String introduce) {
this.introduce = introduce == null ? null : introduce.trim();
}
public String getMaterials() {
return materials;
}

public void setMaterials(String materials) {
this.materials = materials == null ? null : materials.trim();
}
public String getStep() {
return step;
}

public void setStep(String step) {
this.step = step == null ? null : step.trim();
}

}