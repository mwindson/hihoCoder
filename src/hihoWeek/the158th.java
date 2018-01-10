package hihoWeek;

import java.util.Scanner;

/**
 * Created by mwindson on 2017/8/30.
 * https://hihocoder.com/problemset/problem/1318
 */
public class the158th {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] dp = new long[n + 10];
        dp[1] = 0;
        dp[2] = 1;
        int temp = 1;
        for (int i = 3; i <= n; i++) {
            temp = (temp * 2) % (int) (Math.pow(10, 9) + 7);
            dp[i] = (dp[i - 1] + dp[i - 2] + temp) % (int) (Math.pow(10, 9) + 7);
        }
        System.out.println(dp[n]);
    }
}
