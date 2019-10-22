package cn.ymt.view.simple;
import cn.ymt.pojo.BasicModel;
import java.util.Date;
public class WorkSimpleView extends BasicModel {
protected Integer user_id;//
protected String title;//
protected java.util.Date add_time=new Date();//
protected Byte state;//
protected Integer count;//点赞数
protected Integer comment_id;//
protected Integer category_id;//
public Integer getUser_id() {
return user_id;
}

public void setUser_id(Integer user_id) {
this.user_id = user_id;
}
public String getTitle() {
return title;
}

public void setTitle(String title) {
this.title = title == null ? null : title.trim();
}
public java.util.Date getAdd_time() {
return add_time;
}

public void setAdd_time(java.util.Date add_time) {
this.add_time = add_time;
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
public Integer getComment_id() {
return comment_id;
}

public void setComment_id(Integer comment_id) {
this.comment_id = comment_id;
}
public Integer getCategory_id() {
return category_id;
}

public void setCategory_id(Integer category_id) {
this.category_id = category_id;
}

}