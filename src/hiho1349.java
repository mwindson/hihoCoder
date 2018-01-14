import java.util.Scanner;

/**
 * Created by mwindson on 2018/1/13.
 * https://hihocoder.com/problemset/problem/1349
 */
public class hiho1349 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(getDigit(n));
    }

    // 0-9 :1*10 => 10
    // 10-99 : 2*90 => 190
    // 100-999: 3*900 => 2890
    // 1000-9999: 4*9000=>38890
    private static int getDigit(int n) {
        int k = 0;// k位数
        int count = 0;// 位数和
        while (count < n) {
            k++;
            count += k * (k == 1 ? 10 : 9) * Math.pow(10, k - 1);
        }
        count -= k * (k == 1 ? 10 : 9) * Math.pow(10, k - 1);
        int number = (int) ((n - count) / k + (k == 1 ? 0 : Math.pow(10, k - 1)));
        int index = (n - count) % k;
        return Integer.valueOf(String.valueOf(number).substring(index, index + 1));
    }
}
