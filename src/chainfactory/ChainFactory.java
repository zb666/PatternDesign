package chainfactory;

import interceptor.ChainA;
import interceptor.Interceptor;

public class ChainFactory {

    private static Class<? extends Interceptor> sInterceptor;

    /**
     * 设置ChainManager
     * @param interceptor
     */
    public static void setChainManager(Class<? extends Interceptor> interceptor) {
        sInterceptor = interceptor;
    }

    //返回ChainManager
    public static Interceptor getInterceptor() {
        if (sInterceptor == null) {
            sInterceptor = ChainA.class;
        }
        //或者Class.forName()根据路径获取字节码文件，然后通过newInstance进行获取
        //弱类型，效率低，只能用于无参构造的方法,并且该类已经被加载过的 情况之下
        //Class<? extends Interceptor> sInterceptor = PatternDesign.sInterceptor;
        try {
            return sInterceptor.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

}
