import com.qf.dao.impl.GoodsDaoImpl;
import com.qf.dao.impl.GoodsxDaoImpl;
import com.qf.pojo.Goods;
import com.qf.vo.PageBean;
import lombok.Data;
import org.junit.Test;

import java.util.List;

public class GoodsTest {
    @Test
    public void test(){
        PageBean pageBean = new PageBean();
        pageBean.setPage(2);
        pageBean.setRowNum(1);
        List<Goods> goods = new GoodsDaoImpl().selectAllByCid(2, null,2);
        System.out.println(goods);
//        List<Goods> goods1 = new GoodsDaoImpl().selectAllByCid(1, pageBean,2);
//        System.out.println(goods1);
    }
    @Test
    public void test2(){
        List<Goods> list = new GoodsxDaoImpl().selectByCondi("电");
        System.out.println(list);
    }
    @Test
    public void test3(){
        List<Goods> list = new GoodsDaoImpl().selectAllByPage(5, 5);
        System.out.println(list);
    }
}
