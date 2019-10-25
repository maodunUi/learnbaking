package cn.ymt.view.simple;
import cn.ymt.pojo.BasicModel;
public class ImgSimpleView extends BasicModel {
protected String imgUrl;//
protected String memo;//
protected Byte type;//
protected Integer workId;//
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
public Byte getType() {
return type;
}

public void setType(Byte type) {
this.type = type;
}
public Integer getWorkId() {
return workId;
}

public void setWorkId(Integer workId) {
this.workId = workId;
}

}