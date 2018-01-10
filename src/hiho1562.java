import java.util.Scanner;

/**
 * Created by mwindson on 2017/8/28.
 * https://hihocoder.com/problemset/problem/1562
 */
public class hiho1562 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int h = in.nextInt();
            int m = in.nextInt();
            int s = in.nextInt();
            int delta = in.nextInt();
            System.out.println(String.format("%.4f", calAngle(h, m, s, delta)));
        }
    }

    // 时针:1小时走30度 分针:1分钟走6度 秒针:1秒走6度
    private static double calAngle(int h, int m, int s, int delta) {
        int deltaH = delta / 3600;
        int deltaM = (delta % 3600) / 60;
        int deltaS = (delta % 3600) % 60;
        // 走完时间
        int newS = (s + deltaS) % 60;
        int newM = (m + deltaM + (s + deltaS) / 60) % 60;
        int newH = (h + deltaH + (m + deltaM + (s + deltaS) / 60) / 60) % 12;
        double minuteAngle = newS * 6.0000 / 60 + newM * 6.0000;
        double hourAngle = newS * 30.0000 / 3600 + newM * 30.0000 / 60 + newH * 30;
        double diff = Math.abs(hourAngle - minuteAngle);
        return Math.min(360 - diff, diff);
    }
}
