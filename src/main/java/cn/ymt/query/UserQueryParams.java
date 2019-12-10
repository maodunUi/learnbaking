package cn.ymt.query;
import cn.ymt.view.UserView;
public class UserQueryParams extends QueryParams<UserView> {
    private String name ;
    private String telphone ;

    public String getName() {
        return this.name = name == "" ? null : name.trim();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelphone() {
        return this.telphone = telphone == "" ? null : telphone.trim();
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }
}