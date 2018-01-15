import java.util.*;

/**
 * Created by mwindson on 2018/1/15.
 * https://hihocoder.com/problemset/problem/1684
 */
public class hiho1684 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] cars = new int[n];
        for (int i = 0; i < n; i++) {
            cars[i] = in.nextInt();
        }
        System.out.println(n - getLIS(cars, n));
    }

    // 反向求最长上升子序列  LIS
    private static int getLIS(int[] cars, int n) {
        int[] B = new int[n]; // B[i]为长度为i+1的最大上升子序列的最大元素的最小值
        int len = 1;
        B[0] = cars[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            // 比当前的子序列最大值更大,插入
            if (cars[i] >= B[len - 1]) {
                B[len] = cars[i];
                len++;
            } else {
                // 替换对应位置的元素
                int pos = Arrays.binarySearch(B, 0, len - 1, cars[i]);
                if (pos >= 0) {
                    B[pos] = cars[i];
                } else {
                    B[-pos - 1] = cars[i];
                }
            }
        }
        return len;
    }
}
