package hihoWeek;

import java.util.Scanner;

/**
 * Created by mwindson on 2017/9/22.
 * https://hihocoder.com/contest/hiho168/problem/1
 */
public class the168th {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        System.out.println(numberOfExpandBinaryBit(num));
    }

    private static int numberOfExpandBinaryBit(int num) {
        String s = Integer.toBinaryString(num);
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                dp[i] = dp[i - 1];
            } else {
                if (s.charAt(i - 1) == '1') {
                    dp[i] = i >= 2 ? dp[i - 2] * 2 : 2;
                } else {
                    dp[i] = dp[i - 1];
                }
            }
        }
        return dp[s.length()];
    }
}
