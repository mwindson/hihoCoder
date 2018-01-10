package hihoWeek;

import java.util.Scanner;

/**
 * Created by mwindson on 2017/8/21.
 * 描述
 * 对于一个01字符串，你每次可以将一个0修改成1，或者将一个1修改成0。
 * 那么，你最少需要修改多少次才能把一个01串 S 变为有序01字符串(有序01字符串是指满足所有0在所有1之前的01串)呢
 * 输入
 * 第一行是一个整数 T，代表测试数据的组数。(1 ≤ T ≤ 10)
 * 以下T行每行包含一个01串 S 。(1 ≤ |S| ≤ 1000)
 * 输出
 * 对于每组测试数据输出最少需要修改的次数
 * 3
 * 000111
 * 010001
 * 100000
 */
public class Week164 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for (int i = 0; i < t; i++) {
            String s = input.next();
            System.out.println(modifyStr(s));
        }
    }

    // dp[i][0] 以0结尾最小步数/ dp[i][1] 以1结尾最小步数
    private static int modifyStr(String s) {
        int[][] dp = new int[s.length()][2];
        if (s.charAt(0) == '0') {
            dp[0][1] = 1;
        } else {
            dp[0][0] = 1;
        }
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                dp[i][0] = dp[i - 1][0] + 1;
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]);
            } else {
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + 1;
            }
        }
        return Math.min(dp[s.length() - 1][0], dp[s.length() - 1][1]);
    }
}
