package cn.ymt.pojo;
public class Img extends BasicModel {
protected String img_url;//
protected String memo;//
protected Byte type;//
protected Integer work_id;//
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
public Byte getType() {
return type;
}

public void setType(Byte type) {
this.type = type;
}
public Integer getWork_id() {
return work_id;
}

public void setWork_id(Integer work_id) {
this.work_id = work_id;
}

}