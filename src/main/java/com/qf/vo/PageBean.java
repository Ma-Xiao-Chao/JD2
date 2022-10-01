package com.qf.vo;//package com.qf.vo;
//
//import lombok.Data;
//import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data//
@NoArgsConstructor//无参构造
@RequiredArgsConstructor//有参构造 参数看下面nonnull
public class PageBean {
    @NonNull//有参构造参数
    private int page;//当前页
    @NonNull
    private int maxPage;//最大页码
    @NonNull
    private int rowsPrePage;//每页行数
    @NonNull
    private int rowNum;//总行数
    @NonNull
    private boolean prePage;//是否有上一页
    @NonNull
    private boolean nextPage;//是否有下一页
    @NonNull
    private boolean lastPage;//是否是最后一页
    @NonNull
    private boolean firstPage;//是否是第一页

    public void setPage(int page) {
        this.page = page;
    }

    public void setMaxPage(int maxPage) {
        this.maxPage = rowNum / rowsPrePage == 0 ? rowNum / rowsPrePage : rowNum / rowsPrePage + 1;
    }

    public void setPrePage(boolean prePage) {
        this.prePage = page<1?false:true;
    }

    public void setNextPage(boolean nextPage) {
        this.nextPage = page>maxPage?false:true;
    }

    public void setFirstPage(boolean firstPage) {
        this.firstPage = page==1?true:false;
    }

    public void setLastPage(boolean lastPage) {
        this.lastPage = page==maxPage?true:false;
    }
}
