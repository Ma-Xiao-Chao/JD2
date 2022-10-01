
import com.alibaba.fastjson.JSON;
import com.qf.dao.impl.CatalogDaoImpl;
import com.qf.dao.impl.UserDaoImpl;
import com.qf.pojo.Catalog;
import com.qf.service.impl.CatalogServiceImpl;
import org.junit.Test;

import java.util.*;

public class CatalogTest {
    @Test
    public void test() {
        CatalogDaoImpl catalogDao = new CatalogDaoImpl();
        List<Catalog> catalogDaos = catalogDao.selectAll(null,2);
        for (Catalog dao : catalogDaos) {
            System.out.println(dao);
        }
    }

    @Test
    public void testidu() {
        CatalogDaoImpl catalogDao = new CatalogDaoImpl();
//        int res = catalogDao.insert();
//        int res = catalogDao.delete();
//        int res = catalogDao.update();
//        System.out.println(res);
    }

    @Test
    public void test2() {
        UserDaoImpl userDao = new UserDaoImpl();
        Object o = userDao.selectOne();
        System.out.println(o.toString());

    }
    @Test
    public void test3(){
        Object o = new CatalogDaoImpl().selectOne(1);
        System.out.println(o);
    }
    @Test
    public void testClis(){
        ArrayList<Object> finallist = new ArrayList<>();

        CatalogServiceImpl catalogService = new CatalogServiceImpl();
        List<Catalog> clist = catalogService.selectAll(null, 1);
//        System.out.println("二级菜单="+clist);
        //三级菜单
        for (Catalog catalog : clist) {
            List<Catalog> sanjigeti = catalogService.selectAll(catalog.getCid(), null);
            finallist.add(catalog);
            finallist.add(sanjigeti);
        }
        for (Object o : finallist) {
            System.out.println(o);
        }
    }
}
