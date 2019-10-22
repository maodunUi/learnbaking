package cn.ymt.pojo;
import java.util.Date;
public class Course extends BasicModel {
protected String video_url;//介绍视频
protected String title;//
protected String img_url;//
protected String memo;//
protected String memo_two;//
protected String how_learn;//
protected String baker_name;//
protected String backer_img_url;//
protected String bakers_introduce;//
protected Double price;//
protected Integer people_count;//
protected Date add_time=new Date();//
protected Byte order_index;//
protected Byte state;//
protected Integer category_id;//分类id对应的category表
protected Byte isindex;//是否首页展示
public String getVideo_url() {
return video_url;
}

public void setVideo_url(String video_url) {
this.video_url = video_url == null ? null : video_url.trim();
}
public String getTitle() {
return title;
}

public void setTitle(String title) {
this.title = title == null ? null : title.trim();
}
public String getImg_url() {
return img_url;
}

public void setImg_url(String img_url) {
this.img_url = img_url == null ? null : img_url.trim();
}
public String getMemo() {
return memo;
}

public void setMemo(String memo) {
this.memo = memo == null ? null : memo.trim();
}
public String getMemo_two() {
return memo_two;
}

public void setMemo_two(String memo_two) {
this.memo_two = memo_two == null ? null : memo_two.trim();
}
public String getHow_learn() {
return how_learn;
}

public void setHow_learn(String how_learn) {
this.how_learn = how_learn == null ? null : how_learn.trim();
}
public String getBaker_name() {
return baker_name;
}

public void setBaker_name(String baker_name) {
this.baker_name = baker_name == null ? null : baker_name.trim();
}
public String getBacker_img_url() {
return backer_img_url;
}

public void setBacker_img_url(String backer_img_url) {
this.backer_img_url = backer_img_url == null ? null : backer_img_url.trim();
}
public String getBakers_introduce() {
return bakers_introduce;
}

public void setBakers_introduce(String bakers_introduce) {
this.bakers_introduce = bakers_introduce == null ? null : bakers_introduce.trim();
}
public Double getPrice() {
return price;
}

public void setPrice(Double price) {
this.price = price;
}
public Integer getPeople_count() {
return people_count;
}

public void setPeople_count(Integer people_count) {
this.people_count = people_count;
}
public Date getAdd_time() {
return add_time;
}

public void setAdd_time(Date add_time) {
this.add_time = add_time;
}
public Byte getOrder_index() {
return order_index;
}

public void setOrder_index(Byte order_index) {
this.order_index = order_index;
}
public Byte getState() {
return state;
}

public void setState(Byte state) {
this.state = state;
}
public Integer getCategory_id() {
return category_id;
}

public void setCategory_id(Integer category_id) {
this.category_id = category_id;
}
public Byte getIsindex() {
return isindex;
}

public void setIsindex(Byte isindex) {
this.isindex = isindex;
}

}