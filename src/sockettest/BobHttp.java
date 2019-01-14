package sockettest;

import sun.rmi.runtime.Log;

import javax.net.SocketFactory;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class BobHttp {

    public static final int STATUS_DEL_FIXED_PSW = 1 << 3; // 1000
    
    public static void main(String[] args){
        int status = 2;
        //添加状态
        int decode = status | STATUS_DEL_FIXED_PSW;
        //取出状态
        int encode = status & ~STATUS_DEL_FIXED_PSW;


        System.out.print(" "+decode+" "+encode+" ");
    }
}
