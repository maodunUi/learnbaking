package cn.ymt.serviceDao;
import cn.ymt.pojo.User;
import cn.ymt.view.UserView;
import cn.ymt.dao.UserDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceDao extends serviceDaoTemplate<UserView,UserDao> {
    public  List<User> findUserByTelphone(String telphone) throws Exception{
       return dao.findUserByTelphone(telphone) ;
    };
}