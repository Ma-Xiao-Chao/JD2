package com.qf.service.impl; 

import com.qf.pojo.Catalog;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.util.List;

/** 
* CatalogServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>10�� 1, 2022</pre> 
* @version 1.0 
*/ 
public class CatalogServiceImplTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: selectAll(Integer parent, Integer line) 
* 
*/ 
@Test
public void testSelectAllForParentLine() throws Exception { 
//TODO: Test goes here...
    List<Catalog> catalogs = new CatalogServiceImpl().selectAll();
    System.out.println(catalogs+"\n");
} 

/** 
* 
* Method: selectAllByPage(int page, int limit) 
* 
*/ 
@Test
public void testSelectAllByPage() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: selectOne(Integer id) 
* 
*/ 
@Test
public void testSelectOne() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: update(String cname, String url, int level, Object parent, int line, int id) 
* 
*/ 
@Test
public void testUpdate() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: delete(int id) 
* 
*/ 
@Test
public void testDelete() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: insert(String cname, String url, int level, Object parent, int line) 
* 
*/ 
@Test
public void testInsert() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: selectAll() 
* 
*/ 
@Test
public void testSelectAll() throws Exception { 
//TODO: Test goes here... 
} 


} 
