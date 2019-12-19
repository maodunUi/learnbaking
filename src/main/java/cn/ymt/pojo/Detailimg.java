package cn.ymt.pojo;
public class Detailimg extends BasicModel {
protected Integer detailId;//
protected String imgUrl;//
protected String msg;//
public Integer getDetailId() {
return detailId;
}

public void setDetailId(Integer detailId) {
this.detailId = detailId;
}
public String getImgUrl() {
return imgUrl;
}

public void setImgUrl(String imgUrl) {
this.imgUrl = imgUrl == null ? null : imgUrl.trim();
}
public String getMsg() {
return msg;
}

public void setMsg(String msg) {
this.msg = msg == null ? null : msg.trim();
}

}