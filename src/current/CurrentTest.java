package current;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CurrentTest {

    @SuppressWarnings("unused")
    public static void main(String args[]) {
        Runnable r1 = new MyThread();
        new Thread(r1, "t1").start();
        new Thread(r1, "t2").start();
    }


    static class MyThread implements Runnable {

        //等待可以中断，持有的线程长期的不释放，正在等待的线程可以选择放弃等待。
        // 公平锁，按照申请锁的时间获取锁，Synchroinzed->非公平锁 ReentrantLock(默认非公平锁)，
        // 但是可以设置成公平,公平锁的性能不是很好
        // 锁绑定多个条件，ReentrantLock可以同时绑定多个对象
        // 编译之后，代码块前后产生monitorenter& monitorexit指令，操作对象均为锁的计数器
        // 可重入，如果当前线程已经持有了对象锁，把锁的计数器+1，在执行monitorexit的时候，计算器-1.当计算器
        // 为0的时候，锁才能被完全释放了。 如果获取对象锁失败，就阻塞当前线程，知道对象锁被另外一个线程释放.
        private Lock lock = new ReentrantLock(true);

        @Override
        public void run() {
//            synchronized (this){
//                for (int i=0;i<50;i++){
//                    System.out.print(Thread.currentThread().getName()+" ==   "+" \n "+i);
//                }
//            }
            lock.lock();
            try {
                for (int i = 0; i < 50; i++) {
                    System.out.print(Thread.currentThread().getName() + " ==   " + " \n " + i);
                }
            } finally {
                lock.unlock();
            }
        }
    }


}
