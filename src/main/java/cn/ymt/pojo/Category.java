package cn.ymt.pojo;
public class Category extends BasicModel {
protected String title;//
protected Byte orderIndex;//
protected String memo;//
public String getTitle() {
return title;
}

public void setTitle(String title) {
this.title = title == null ? null : title.trim();
}
public Byte getOrderIndex() {
return orderIndex;
}

public void setOrderIndex(Byte orderIndex) {
this.orderIndex = orderIndex;
}
public String getMemo() {
return memo;
}

public void setMemo(String memo) {
this.memo = memo == null ? null : memo.trim();
}

}