package cn.ymt.view.simple;
import cn.ymt.pojo.BasicModel;
public class CategorySimpleView extends BasicModel {
protected String title;//
protected Byte order_index;//
protected String memo;//
public String getTitle() {
return title;
}

public void setTitle(String title) {
this.title = title == null ? null : title.trim();
}
public Byte getOrder_index() {
return order_index;
}

public void setOrder_index(Byte order_index) {
this.order_index = order_index;
}
public String getMemo() {
return memo;
}

public void setMemo(String memo) {
this.memo = memo == null ? null : memo.trim();
}

}