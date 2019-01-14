package sort;

import java.util.Arrays;

//直接插入排序
//每次插入之后 就和左边的数据进行比较
public class IntertSort {

    public static void main(String args[]) {
        int[] array=new int[]{2,3,4,5,6,7,1,8,9};
       insertAndSor(array);
       System.out.print(Arrays.toString(array));
    }

    private static void insertAndSor(int[] array) {
        int length = array.length;
        for (int i = 1; i < length; i++) {
            int j = i;
            int temp = array[j];
            while (j>0 && array[j]<array[j--]){
                array[j] = array[j-1];
                j--;
            }
            array[j-1] = temp;
        }
    }

}
