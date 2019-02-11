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

        int nums[] = {7, 5, 2, 10, 4, 1, 8, 3, 6, 9};
//        int[] bubbleArray = bubbleSort(nums);
       quickSort(nums,0,nums.length-1);

        for (int num : nums) {
            System.out.print(" " + num);
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

    /**
     * tips
     * 1.寻找分割的基准点，将数组分成以基准点为切割线的两个部分(左侧的比基准点小），右侧的比基准点大
     * 2.如法炮制，左右的数组均以此方式进行二次排序
     * 3.最终得到左右均有顺序的“无数个”数组
     * 我们可以看到，先选择的是中间的数据，其次是左侧的节点，最后才是右侧的节点，所以快速排序其实是
     * 基于中序遍历的一次排序。
     * @param nums 待排序的数组
     * @param low 左侧指针下标
     * @param high 右侧指针下标
     */
    private static void quickSort(int[] nums,int low,int high) {
        if (nums == null || nums.length == 0) return;
        if (low>high) return;
        //进行首次的分割
        int privotPos = dividerPos(nums, low, nums.length-1);
        //再次进行递归比较
        //对于低字表进行递归
        quickSort(nums,low,privotPos-1);
        //对于高字表进行递归
        quickSort(nums,privotPos+1,high);
    }

    /**
     * 切割数组 分成以基准点为分割线的两半
     *
     * @param a
     * @param low
     * @param high
     * @return
     */
    private static int dividerPos(int[] a, int low, int high) {
        int privotKey = a[low];
        while (low < high) {
            //不断地从右边向左边进行扫描
            while (a[high] > privotKey && high > low) {
                high--;
            }
            //交换
            swap(a, low, high);
            //低位指针向右移动,直到遇到合数的数据
            while (a[low] <privotKey && low < high) {
                low++;
            }
            swap(a, low, high);
        }
        return low;
    }

    private static void swap(int[] a, int low, int high) {
        int temp = a[low];
        a[low] = a[high];
        a[high] = temp;
    }

    private static int[] bubbleSort(int[] nums) {
        int length = nums.length;
        int temp;
        int pos = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (nums[j + 1] > nums[j]) {
                    pos++;
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
            if (pos == 0) {
                //后面的顺序已经排完
                return nums;
            }
            pos = 0;
        }
        return nums;
    }


    public static void matchStr(String str) {

    }


}
