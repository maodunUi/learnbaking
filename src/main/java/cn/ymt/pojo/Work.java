package cn.ymt.pojo;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
public class Work extends BasicModel {
protected Integer userId;//
protected String title;//
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
protected Date addTime=new Date();//
protected Byte state;//0不正常 1正常
protected Integer count;//点赞数
protected Integer categoryId;//
protected Integer commentCount;//评论数
public Integer getUserId() {
return userId;
}

public void setUserId(Integer userId) {
this.userId = userId;
}
public String getTitle() {
return title;
}

public void setTitle(String title) {
this.title = title == null ? null : title.trim();
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
public Integer getCount() {
return count;
}

public void setCount(Integer count) {
this.count = count;
}
public Integer getCategoryId() {
return categoryId;
}

public void setCategoryId(Integer categoryId) {
this.categoryId = categoryId;
}
public Integer getCommentCount() {
return commentCount;
}

public void setCommentCount(Integer commentCount) {
this.commentCount = commentCount;
}

}