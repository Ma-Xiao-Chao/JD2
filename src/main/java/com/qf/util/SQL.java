package com.qf.util;

public interface SQL {
    String CATALOG="select c_id cid,c_name cname,c_url url,c_level level,c_parent parent,c_line line from catalog ";
    String GOODS="select g_id gid,c_id cid1,cat_c_id cid2,cat_c_id2 cid3,g_name gname,g_store store,g_pubdate pubdate,g_price price,pic1,pic2,pic3,pic4,info from goods ";
}
