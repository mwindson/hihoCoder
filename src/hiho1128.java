import java.util.Scanner;

/**
 * Created by mwindson on 2017/8/24.
 * https://hihocoder.com/problemset/problem/1128
 * 非有序数组的二分查找
 * 输入
 * 第1行：2个整数N,K。N表示数组长度，K表示需要查找的数；
 * 第2行：N个整数，表示a[1..N]，保证不会出现重复的数，1≤a[i]≤2,000,000,000。
 * 输出
 * 第1行：一个整数t，表示K在数组中是第t小的数，若K不在数组中，输出-1。
 */
public class hiho1128 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int target = in.nextInt();
        int index = 1;
        boolean find = false;
        for (int i = 0; i < n; i++) {
            int curr = in.nextInt();
            if (curr < target) {
                index++;
            } else if (curr == target) {
                find = true;
            }
        }
        System.out.println(find ? index : -1);
    }
}
