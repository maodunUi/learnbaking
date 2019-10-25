package cn.ymt.pojo;
import java.util.Date;
public class Comment extends BasicModel {
protected Integer userId;//
protected String message;//
protected Date commentTime=new Date();//
protected Integer parentId;//
public Integer getUserId() {
return userId;
}

public void setUserId(Integer userId) {
this.userId = userId;
}
public String getMessage() {
return message;
}

public void setMessage(String message) {
this.message = message == null ? null : message.trim();
}
public Date getCommentTime() {
return commentTime;
}

public void setCommentTime(Date commentTime) {
this.commentTime = commentTime;
}
public Integer getParentId() {
return parentId;
}

public void setParentId(Integer parentId) {
this.parentId = parentId;
}

}