package cn.ymt.view.simple;
import cn.ymt.pojo.BasicModel;
import java.util.Date;
public class CommentSimpleView extends BasicModel {
protected Integer user_id;//
protected String message;//
protected java.util.Date comment_time=new Date();//
protected Integer parent_id;//
public Integer getUser_id() {
return user_id;
}

public void setUser_id(Integer user_id) {
this.user_id = user_id;
}
public String getMessage() {
return message;
}

public void setMessage(String message) {
this.message = message == null ? null : message.trim();
}
public java.util.Date getComment_time() {
return comment_time;
}

public void setComment_time(java.util.Date comment_time) {
this.comment_time = comment_time;
}
public Integer getParent_id() {
return parent_id;
}

public void setParent_id(Integer parent_id) {
this.parent_id = parent_id;
}

}