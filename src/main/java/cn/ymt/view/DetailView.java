package cn.ymt.view;
import cn.ymt.pojo.Detail;

import java.util.List;

public class DetailView extends Detail {
    private List<DetailimgView> detailimgViews ;

    public List<DetailimgView> getDetailimgViews() {
        return detailimgViews;
    }

    public void setDetailimgViews(List<DetailimgView> detailimgViews) {
        this.detailimgViews = detailimgViews;
    }
}