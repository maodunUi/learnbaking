package cn.ymt.dao;
import cn.ymt.pojo.User;
import cn.ymt.view.UserView;
import cn.ymt.query.UserQueryParams;

import java.util.List;

public interface UserDao extends DaoTemplate<UserView,UserQueryParams>{

    List<UserView> findUserByTelphone(String telphone) throws Exception;
}