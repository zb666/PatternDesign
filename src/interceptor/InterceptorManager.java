package interceptor;

import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.List;

public class InterceptorManager implements Interceptor {

    private List<Interceptor> mInterceptorList = new ArrayList<>(5);

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
        index++;
        //取出当前的chain
        currentChain.processChain(targetStr, interceptor);
    }

}
