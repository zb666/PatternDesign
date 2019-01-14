import chainfactory.ChainFactory;
import factory.CaseA;
import factory.CaseB;
import factory.CaseC;
import factory.IFactoryDesign;
import interceptor.ChainA;
import interceptor.ChainB;
import interceptor.Interceptor;
import interceptor.InterceptorManager;

public class PatternDesign {


    public static void main(String args[]) {
        String start = "a";
        System.out.print("运行");

        //okhttp的添加时倒序的 我们这里没什么特别的要求正序即可
        //这样每次有新的情况到来的时候 只需要对齐进行添加实例的操作即可
        Interceptor chainManager = new InterceptorManager()
                .addInterceptor(new ChainB());
//                .addInterceptor(new ChainA());
        //当前的链条管理器
        chainManager.processChain(start, chainManager);

        ChainFactory chainFactory = new ChainFactory();

        ChainFactory.setChainManager(ChainA.class);

    }

    public static void matchStr(String str) {

    }






}
