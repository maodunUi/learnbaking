package cn.ymt.view;
import cn.ymt.pojo.Detail;

import java.util.List;

public class DetailView extends Detail {
    private List<DetailimgView> detailimgViews ;

    private String[] imgUrlTwo ;
    private String[] msgTwo ;

    public String[] getImgUrlTwo() {
        return imgUrlTwo;
    }

    public void setImgUrlTwo(String[] imgUrlTwo) {
        this.imgUrlTwo = imgUrlTwo;
    }

    public String[] getMsgTwo() {
        return msgTwo;
    }

    public void setMsgTwo(String[] msgTwo) {
        this.msgTwo = msgTwo;
    }

    public List<DetailimgView> getDetailimgViews() {
        return detailimgViews;
    }

    public void setDetailimgViews(List<DetailimgView> detailimgViews) {
        this.detailimgViews = detailimgViews;
    }
}