package interceptor;

public class ChainB implements Interceptor {

    //这里的interceptor指的是InterceptorManager
    @Override
    public void processChain(String targetStr, Interceptor interceptor) {
        if ("b".equals(targetStr)) {
            System.out.print("bbb");
            return;
        }
        //调用的是下一个链条的处理器
        interceptor.processChain(targetStr, interceptor);
    }
}
