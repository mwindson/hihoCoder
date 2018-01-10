import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mwindson on 2017/8/23.
 * https://hihocoder.com/problemset/problem/1558
 * 描述
 * H国的身份证号码是一个N位的正整数(首位不能是0)。此外，由于防伪需要，一个N位正整数是合法的身份证号码当且仅当每位数字都小于等于K，并且任意相邻两位数字的乘积也小于等于K。
 * 例如对于K=5, 101、211、210等都是合法的号码，而106、123、421等都是非法的号码。
 * 给定一个正整数N以及K，请从小到大输出所有合法的号码。
 * 输入
 * 两个整数N和K。
 * 对于80%的数据，1 ≤ N ≤ 6。
 * 对于100%的数据，1 ≤ N ≤ 9，1 ≤ K ≤ 5。
 * 输出
 * 按从小到大的顺序输出所有合法的N位号码，每个号码占一行。
 */
public class hiho1558 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        validNumber(n, k);
    }

    private static void validNumber(int n, int k) {
        backTracking("", 0, 1, n, k);
    }

    private static void backTracking(String cur, int index, int prev, int n, int k) {
        if (index == n) {
            System.out.println(cur);
        } else {
            for (int i = index == 0 ? 1 : 0; i <= k / (prev == 0 ? 1 : prev); i++) {
                backTracking(cur + i, index + 1, i, n, k);
            }
        }
    }
}
