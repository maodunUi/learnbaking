package cn.ymt.view;
import cn.ymt.pojo.Img;
import cn.ymt.pojo.User;
import cn.ymt.pojo.Work;

import java.util.List;

public class WorkView extends Work {
    private List<ImgView> imgs ;
    private User user ;
    private Integer mylike ;
    public List<ImgView> getImgs() {
        return imgs;
    }

    public void setImgs(List<ImgView> imgs) {
        this.imgs = imgs;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getMylike() {
        return mylike;
    }

    public void setMylike(Integer mylike) {
        this.mylike = mylike;
    }
}