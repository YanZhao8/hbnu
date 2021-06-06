package www.hbnu.com.domain;

import java.io.Serializable;
import java.util.List;
/**
 * @Description:
 * @Author: yanzhao
 * @Date: 2021/5/18 9:53
 * @Version: 1.0
 * @Company: 版权所有
 * @Modified:
 */
public class User implements Serializable {
    private static final long serialVersionUID = 4385464896499272113L;
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String phone;
    private List<Role> roleList;



    public User() {
    }

    public User(Integer id, String username, String password, String email, String phone, List<Role> roleList) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.roleList = roleList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", roleList=" + roleList +
                '}';
    }
}
