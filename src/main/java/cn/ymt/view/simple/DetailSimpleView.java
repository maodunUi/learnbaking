package cn.ymt.view.simple;
import cn.ymt.pojo.BasicModel;
import java.util.Date;
public class DetailSimpleView extends BasicModel {
protected String img_url;//
protected String title;//
protected String memo;//
protected String tips;//
protected java.util.Date add_time=new Date();//
protected Byte state;//0不正常 1正常
protected Byte order_index;//
protected Integer userid;//
protected String introduce;//介绍
protected String materials;//用料 用-分隔
protected String step;//步骤
public String getImg_url() {
return img_url;
}

public void setImg_url(String img_url) {
this.img_url = img_url == null ? null : img_url.trim();
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
public Byte getOrder_index() {
return order_index;
}

public void setOrder_index(Byte order_index) {
this.order_index = order_index;
}
public Integer getUserid() {
return userid;
}

public void setUserid(Integer userid) {
this.userid = userid;
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