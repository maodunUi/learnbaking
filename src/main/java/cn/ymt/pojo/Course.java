package cn.ymt.pojo;
import java.util.Date;
public class Course extends BasicModel {
protected String videoUrl;//介绍视频
protected String title;//
protected String imgUrl;//
protected String memo;//
protected String memoTwo;//
protected String howLearn;//
protected String bakerName;//
protected String backerImgUrl;//
protected String bakerIntroduce;//
protected Double price;//
protected Integer peopleCount;//
protected Date addTime=new Date();//
protected Byte orderIndex;//
protected Byte state;//
protected Integer categoryId;//分类id对应的category表
protected Byte isindex;//是否首页展示 0 否 1是
public String getVideoUrl() {
return videoUrl;
}

public void setVideoUrl(String videoUrl) {
this.videoUrl = videoUrl == null ? null : videoUrl.trim();
}
public String getTitle() {
return title;
}

public void setTitle(String title) {
this.title = title == null ? null : title.trim();
}
public String getImgUrl() {
return imgUrl;
}

public void setImgUrl(String imgUrl) {
this.imgUrl = imgUrl == null ? null : imgUrl.trim();
}
public String getMemo() {
return memo;
}

public void setMemo(String memo) {
this.memo = memo == null ? null : memo.trim();
}
public String getMemoTwo() {
return memoTwo;
}

public void setMemoTwo(String memoTwo) {
this.memoTwo = memoTwo == null ? null : memoTwo.trim();
}
public String getHowLearn() {
return howLearn;
}

public void setHowLearn(String howLearn) {
this.howLearn = howLearn == null ? null : howLearn.trim();
}
public String getBakerName() {
return bakerName;
}

public void setBakerName(String bakerName) {
this.bakerName = bakerName == null ? null : bakerName.trim();
}
public String getBackerImgUrl() {
return backerImgUrl;
}

public void setBackerImgUrl(String backerImgUrl) {
this.backerImgUrl = backerImgUrl == null ? null : backerImgUrl.trim();
}
public String getBakerIntroduce() {
return bakerIntroduce;
}

public void setBakerIntroduce(String bakerIntroduce) {
this.bakerIntroduce = bakerIntroduce == null ? null : bakerIntroduce.trim();
}
public Double getPrice() {
return price;
}

public void setPrice(Double price) {
this.price = price;
}
public Integer getPeopleCount() {
return peopleCount;
}

public void setPeopleCount(Integer peopleCount) {
this.peopleCount = peopleCount;
}
public Date getAddTime() {
return addTime;
}

public void setAddTime(Date addTime) {
this.addTime = addTime;
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
public Integer getCategoryId() {
return categoryId;
}

public void setCategoryId(Integer categoryId) {
this.categoryId = categoryId;
}
public Byte getIsindex() {
return isindex;
}

public void setIsindex(Byte isindex) {
this.isindex = isindex;
}

}