package cn.ymt.pojo;
import java.util.Date;
public class Work extends BasicModel {
protected Integer userId;//
protected String title;//
protected Date addTime=new Date();//
protected Byte state;//
protected Integer count;//点赞数
protected Integer commentId;//
protected Integer categoryId;//
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
public Integer getCommentId() {
return commentId;
}

public void setCommentId(Integer commentId) {
this.commentId = commentId;
}
public Integer getCategoryId() {
return categoryId;
}

public void setCategoryId(Integer categoryId) {
this.categoryId = categoryId;
}

}