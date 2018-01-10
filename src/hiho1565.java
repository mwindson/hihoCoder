import java.util.Scanner;

/**
 * Created by mwindson on 2017/8/28.
 * https://hihocoder.com/problemset/problem/1565
 */
public class hiho1565 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] block = new int[n];
        for (int i = 0; i < n; i++) {
            block[i] = in.nextInt();
        }
        int[] b = new int[n];
        int[] c = new int[n];
        preProgress(b, c, block);
        int q = in.nextInt();
        for (int i = 0; i < q; i++) {
            int x = in.nextInt();
            if (x == 1) {
                int y = in.nextInt();
                System.out.println(query(y, b, c, block));
            } else {
                int u = in.nextInt();
                int v = in.nextInt();
                modify(u, v, b, c, block);
            }
        }
    }

    //  𝑩[𝒊]：从𝒊开始离开当前段所需要的步数
    //  𝑪[𝒊]：从𝒊开始经过𝑩[𝒊]步后到达的位置
    private static void preProgress(int[] b, int[] c, int[] block) {
        int len = (int) Math.sqrt(block.length);
        for (int i = block.length - 1; i >= 0; i--) {
            update(i, block, b, c, len);
        }
    }

    private static int query(int y, int[] b, int[] c, int[] block) {
        int count = 1;
        while (y < block.length && y + block[y] < block.length) {
            count += b[y];
            y = c[y];
        }
        return count;
    }

    private static void modify(int u, int v, int[] b, int[] c, int[] block) {
        int len = (int) Math.sqrt(block.length);
        block[u] = v;
        for (int i = (u / len + 1) * len - 1; i >= u; i--) {
            update(i, block, b, c, len);
        }
    }

    private static void update(int i, int[] block, int[] b, int[] c, int len) {
        if (i + block[i] > block.length || (i + block[i]) / len != i / len) {
            b[i] = 1;
            c[i] = i + block[i];
        } else {
            b[i] = b[i + block[i]] + 1;
            c[i] = c[i + block[i]];
        }
    }
}
