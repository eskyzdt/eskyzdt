package cn.eskyzdt.modules.thread;

public class FunctionImpl  {

    public static void main(String[] args) {
        /**
         * 使用Lambda表达式来表示该接口的一个实现(注：JAVA 8 之前一般是用匿名类实现的)：
         */
        FunctionLam functionLam = (message)-> {
            System.out.println(message);
        };
        functionLam.meOne("dsfsdfsdf");
    }



}
