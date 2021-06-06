package www.hbnu.com.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * @Description:
 * @Author: yanzhao
 * @Date: 2021/5/20 9:38
 * @Version: 1.0
 * @Company: 版权所有
 * @Modified:
 */
public class Role implements Serializable {
    private static final long serialVersionUID = 9126097506273603323L;
    private Integer id;
    private String rolename;
    private String describes;

    public Role() {
    }

    public Role(Integer id, String rolename, String describes) {
        this.id = id;
        this.rolename = rolename;
        this.describes = describes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", rolename='" + rolename + '\'' +
                ", describes='" + describes + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(id, role.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
