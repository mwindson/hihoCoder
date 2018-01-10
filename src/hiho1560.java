import java.util.Scanner;

/**
 * Created by mwindson on 2017/8/23.
 * https://hihocoder.com/problemset/problem/1560
 * 描述
 * H国的身份证号码是一个N位的正整数(首位不能是0)。此外，由于防伪需要，一个N位正整数是合法的身份证号码当且仅当每位数字都小于等于K，并且任意相邻两位数字的乘积也小于等于K。
 * 例如对于K=5, 101、211、210等都是合法的号码，而106、123、421等都是非法的号码。
 * 给定一个正整数N以及K，H国总统想知道一共有多少个合法的号码可用。
 * 输入
 * 两个整数N和K。
 * 对于30%的数据，1 ≤ N ≤ 10
 * 对于50%的数据，1 ≤ N ≤ 1000000
 * 对于100%的数据，1 ≤ N ≤ 10^12，1 ≤ K ≤ 81。
 * 输出
 * 合法号码的总数。由于答案可能非常大，你只需要输出答案对109+7取模的结果
 */
public class hiho1560 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        System.out.println(validNumberCount(n, k));
    }

    private static int validNumberCount(int n, int k) {
        // dp[i][j] 以j为结尾的i位数字
        int[][] dp = new int[n + 1][10];
        for (int j = 1; j < 10; j++) {
            dp[1][j] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                for (int o = 0; o <= Math.min(k / (j == 0 ? 1 : j), 9); o++) {
                    dp[i][j] += dp[i - 1][o];
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < 10; i++)
            sum += dp[n][i];
        return sum;
    }
}
