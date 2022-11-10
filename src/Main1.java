import org.junit.Test;

import java.util.HashMap;
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main1 {
    //dasdasdas
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别

    }
    //二分查找
    public int binary_search(int num,int[] arr){
        int left = 0,right = arr.length-1;
        if (num<arr[left] || num>arr[right]) return -1;
        while (left<right){
            int middle = left+(right-left)/2;
            if (num>arr[middle]) {
                left =middle+1;
            } else if (num<arr[middle]) {
                right =middle-1;
            }
            else return middle;
        }
        return -1;
    }
    @Test
    public void test_binary_search(){
        int[] arr ={-1,0,3,5,9,12};
        int num =2;
        System.out.printf("%d", binary_search(num, arr));
    }
}