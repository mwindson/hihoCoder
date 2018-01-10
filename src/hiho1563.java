import java.util.Scanner;

/**
 * Created by mwindson on 2017/8/28.
 * https://hihocoder.com/problemset/problem/1563
 */
public class hiho1563 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] seats = new int[n];
        for (int i = 0; i < n; i++) {
            seats[i] = in.nextInt();
        }
        System.out.println(minDisSum(seats, m));
    }

    private static int minDisSum(int[] seats, int m) {
        int count = 0;
        for (int seat : seats) {
            count += seat;
        }
        if (count < m) return -1;
        int min = Integer.MAX_VALUE;
        int[] copy = new int[seats.length * 3];
        for (int i = 0; i < seats.length; i++)
            copy[i] = copy[i + seats.length] = copy[i + 2 * seats.length] = seats[i];
        // 左右座位数
        int leftCount = 0;
        int rightCount = 0;
        int dis = 0;
        for (int i = 0; i < seats.length; i++) {

            min = Math.min(min, dis);
        }
        return count;
    }
}
