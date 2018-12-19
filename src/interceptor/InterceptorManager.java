package interceptor;

import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.List;

public class InterceptorManager implements Interceptor {

    private List<Interceptor> mInterceptorList = new ArrayList<>();

    private int index = 0;

    public InterceptorManager addInterceptor(@NotNull Interceptor interceptor) {
        mInterceptorList.add(interceptor);
        return this;
    }

    @Override
    public void processChain(String targetStr, Interceptor interceptor) {
        if (index == mInterceptorList.size()) return;
        //获取链条
        Interceptor currentChain = mInterceptorList.get(index);
        //这里的++是为了取得下一个链条并且要在下一条拦截之前执行
        index++;
        //this是为了让每一个链条执行完之后
        //若不方便处理，用于上抛
        currentChain.processChain(targetStr, this);
    }

}
