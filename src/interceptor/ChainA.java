package interceptor;

public class ChainA implements Interceptor {
    @Override
    public void processChain(String targetStr, Interceptor interceptorManager) {
        if ("a".equals(targetStr)) {
            System.out.print("aaa");
            return;
        }
        //上抛管理器 这里的管理器会伴随整个调用链
        interceptorManager.processChain(targetStr, interceptorManager);
    }
}
