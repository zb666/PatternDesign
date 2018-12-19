package interceptor;

public interface Interceptor {
    void processChain(String targetStr, Interceptor interceptor);
}
