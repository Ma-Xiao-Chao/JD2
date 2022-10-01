import com.qf.dao.impl.UserDaoImpl;
import com.qf.pojo.User;
import org.junit.Test;

import java.util.List;

public class UserTest {
    @Test
    public void tets() throws IllegalAccessException, InstantiationException {
        UserDaoImpl userDao = new UserDaoImpl();
        Object o = userDao.selectOne();
        System.out.println(o);
    }
    @Test
    public void test(){
        List<User> users = new UserDaoImpl().allUser(1, 2);
        System.out.println(users);
    }
    @Test
    public void test1(){
        List<User> users = new UserDaoImpl().allUser();
        System.out.println(users);
    }
}
