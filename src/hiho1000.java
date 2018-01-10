import java.util.Scanner;

/**
 * Created by mwindson on 2017/8/24.
 * https://hihocoder.com/problemset/problem/1000
 * 描述
 * 求两个整数A+B的和
 * 输入
 * 输入包含多组数据。
 * 每组数据包含两个整数A(1 ≤ A ≤ 100)和B(1 ≤ B ≤ 100)。
 * 输出
 * 对于每组数据输出A+B的和。
 */
public class hiho1000 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            int A = in.nextInt();
            int B = in.nextInt();
            System.out.println(A + B);
        }
    }
}
