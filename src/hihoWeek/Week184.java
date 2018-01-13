package hihoWeek;

import java.util.Scanner;

/**
 * Created by mwindson on 2018/1/10.
 */
public class Week184 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x = in.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = in.nextInt();
        }
        System.out.println(calMinPerference(prices, n, x));
    }

    private static int calMinPerference(int[] prices, int n, int x) {
        int sum = 0;
        for (int p : prices) sum += p;
        if (sum < x) return -1;
        int rest = sum - x;
        int[] dp = new int[rest + 1]; // dp[v]:未选菜的总价格小于等于sum-v的总价格
        for (int i = 0; i < n; i++)
            for (int v = rest; v >= prices[i]; v--)
                dp[v] = Math.max(dp[v], dp[v - prices[i]] + prices[i]);
        int max = 0;
        for (int v = 0; v < dp.length; v++)
            max = Math.max(dp[v], max);
        return sum - max;
    }
}
