import java.util.Scanner;

/**
 * Created by mwindson on 2017/8/22.
 * https://hihocoder.com/problemset/problem/1481
 * 描述
 * 小Hi的算法课老师每次上课都会统计小Hi的出勤记录。迟到会被记录一个L，缺席会被记录一个A，按时上课会被记录一个O。
 * 一学期结束，小Hi的出勤记录可以看成是一个只包含LAO的字符串，例如"OOOOLOOOLALLO……"。
 * 如果小Hi整学期缺席不超过1次，并且没有连续3次迟到，小Hi的出勤记录就算合格。
 * 输入
 * 输入第一行包含一个整数T(1 <= T <= 10)，代表测试数据的组数。
 * 以下T行每行一个程度不超过100的字符串S，代表小Hi的出勤记录。
 * 输出
 * 对于每一份出勤记录，输出YES或者NO表示该份记录是否合格。
 */
public class hiho1481 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            String record = in.next();
            System.out.println(isPass(record) ? "YES" : "NO");
        }
    }

    private static boolean isPass(String s) {
        int A_count = 0;
        int L_count = 0;
        for (char c : s.toCharArray()) {
            if (c == 'A') {
                A_count++;
                if (A_count > 1) return false;
                L_count = 0;
            } else if (c == 'L') {
                L_count++;
                if (L_count >= 3) return false;
            } else {
                L_count = 0;
            }
        }
        return true;
    }
}
