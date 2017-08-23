import java.util.Scanner;

/**
 * Created by mwindson on 2017/8/22.
 * 描述
 * 小Ho给自己定了一个宏伟的目标：连续100天每天坚持在hihoCoder上提交一个程序。
 * 100天过去了，小Ho查看自己的提交记录发现有N天因为贪玩忘记提交了。
 * 于是小Ho软磨硬泡、强忍着小Hi鄙视的眼神从小Hi那里要来M张"补提交卡"。每张"补提交卡"都可以补回一天的提交，将原本没有提交程序的一天变成有提交程序的一天。
 * 小Ho想知道通过利用这M张补提交卡，可以使自己的"最长连续提交天数"最多变成多少天。
 * 输入
 * 第一行是一个整数T(1 <= T <= 10)，代表测试数据的组数。
 * 每个测试数据第一行是2个整数N和M(0 <= N, M <= 100)。
 * 第二行包含N个整数a1, a2, ... aN(1 <= a1 < a2 < ... < aN <= 100)，表示第a1, a2, ...  aN天小Ho没有提交程序。
 * 3
 * 5 1
 * 34 77 82 83 84
 * 5 2
 * 10 30 55 56 90
 * 5 10
 * 10 30 55 56 90
 * 输出
 * 对于每组数据，输出通过使用补提交卡小Ho的最长连续提交天数最多变成多少。
 */
public class hiho1051 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int m = in.nextInt();
            int[] date = new int[n];
            for (int j = 0; j < n; j++)
                date[j] = in.nextInt();
            System.out.println(longestDay(date, m));
        }
    }

    public static int longestDay(int[] date, int m) {
        int[] dayCount = new int[date.length + 1];
        int longest = 0;
        for (int i = 0; i < date.length; i++) {
            if (i == 0)
                dayCount[i] = date[i] - 1;
            else
                dayCount[i] = date[i] - date[i - 1] - 1;
        }
        dayCount[date.length] = 100 - date[date.length - 1];
        int len = dayCount[0];
        for (int i = 1; i <= Math.min(m, dayCount.length - 1); i++)
            len += dayCount[i] + 1;
        longest = len;
        for (int i = m + 1; i < dayCount.length; i++) {
            len = len + dayCount[i] - dayCount[i - m - 1];
            longest = Math.max(longest, len);
        }
        return longest;
    }
}
