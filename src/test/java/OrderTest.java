import com.qf.dao.impl.OrderDaoImpl;
import com.qf.dao.impl.OrderInfoDaoImpl;
import org.junit.Test;

public class OrderTest {
    @Test
    public void test(){
        OrderInfoDaoImpl orderInfoDao = new OrderInfoDaoImpl();

        System.out.println(orderInfoDao.orderDetialByOid(36));

    }
    @Test
    public void test1(){
        OrderInfoDaoImpl orderInfoDao = new OrderInfoDaoImpl();

        System.out.println(orderInfoDao.orderAll());

    }
}
