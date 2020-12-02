package cn.eskyzdt.english;

public enum HighMath {

    /**
     *
     */
    BAOHAOXING("如果f(x)在x=n处的极限大于0或小于0,那么在x=n的附近,f(x)的值也是大于0或小于0的"),
    WUQIONGDA("无穷大或无穷小必须是有一个渐近范围的")
    ,ZERO("0是既是一个常数又是无穷小的数"),
    // 这里|f(x) - A|用了绝对值,对于f（x），向上M为界无法超过，向下是-M为界无法超过
    JUBUyoujie("一个函数有极限,那么这个函数是局部有界的,注意局部,当f(x)趋向于A时(即x趋于x0),存在一个数E>0,M>0, 使得 0<|x-x0| < e时, |f(x) - A| < M"),
    bi("闭区间上函数连续(因为连续所以会产生)的性质  1.有界原理 (f(x) < M) 2.最大最小值原理(存在最大值,存在最小值) " +
            "3.介值定理 (端点处是f(a) 和 f(b) 那么在f(a) f(b)上一定存在 4.零点定理 若f(a)<0 f(b) > 0则存在一个f(x0) = 0")
    ,ss("两个重要极限 x->0 lim x/sinx = 1   x->无穷 lim (1 + 1/x)^x = e")
    ;

    private String key;

    private HighMath(String key) {
        this.key = key;
    }
}
