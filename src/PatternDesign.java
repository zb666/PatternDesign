import chainfactory.ChainFactory;
import interceptor.ChainA;
import interceptor.ChainB;
import interceptor.Interceptor;
import interceptor.InterceptorManager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class PatternDesign {


    @SuppressWarnings("unused")
    public static void main(String args[]) {
        String start = "a";
        System.out.print("运行");


        int nums[] = {4, 5, 2, 10, 7, 1, 8, 3, 6, 9};
        int[] bubbleArray = bubbleSort(nums);
        quickSort(nums);
        int[] bubbleSort = bubbleArray;
        for (int i : bubbleSort) {
            System.out.print(i);
        }

        //okhttp的添加时倒序的 我们这里没什么特别的要求正序即可
        //这样每次有新的情况到来的时候 只需要对齐进行添加实例的操作即可
        Interceptor chainManager = new InterceptorManager()
                .addInterceptor(new ChainB());
//                .addInterceptor(new ChainA());
        //当前的链条管理器
        chainManager.processChain(start, chainManager);

        ChainFactory chainFactory = new ChainFactory();

        ChainFactory.setChainManager(ChainA.class);

        ArrayList<String> list = new ArrayList<String>();
        list.add("Java");
        list.add("Hello");
        list.add("World");

        Stack<String> mStack = new Stack<>();
        mStack.add("JavaC");
        mStack.add("Hello");
        mStack.add("Android");

        mStack.pop();

        //增强For不能直接删除当前的元素
        for (String s : list) {
            if ("Java".equals(s)) {
//                list.remove(s);
            }
        }

        list.add("Java");
        //迭代器的方式也能够进行删除
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String currentNext = iterator.next();
            if ("Java".equals(currentNext)) {
                iterator.remove();
            }
        }
        System.out.print(list);

        list.add("Java");
        //普通for是可以的
        for (int i = 0; i < list.size(); i++) {
            if ("Java".equals(list.get(i))) {
                list.remove(list.get(i));
            }
        }
        System.out.print(list);
    }

    private static int quickSort(int[] nums) {

    }

    private static int[] bubbleSort(int[] nums) {
        int length = nums.length;
        int temp;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (nums[j+1]>nums[j]) {
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        return nums;
    }


    public static void matchStr(String str) {

    }


}
