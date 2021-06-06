package www.hbnu.com.service;

import www.hbnu.com.domain.User;
import java.util.List;

/**
 * @Description:
 * @Author: yanzhao
 * @Date: 2021/5/18 14:20
 * @Version: 1.0
 * @Company: 版权所有
 * @Modified:
 */
public interface UserService {
    //查询
    List<User> getAllUsers(int page, int size);
    //添加
    void save(User user, long[] roleIds);
    //删除
    void delete(Integer u_id);


    //修改
    User findUserById(Integer uid);
    void update(User user, long[] roleIds);

    User login(User user);

    //查找ByName
    List<User> selectByName(int page, int size);
}
