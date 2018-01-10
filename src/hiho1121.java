import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by mwindson on 2017/8/24.
 * https://hihocoder.com/problemset/problem/1121
 * 选取一个未染色的点u进行染色
 * 遍历u的相邻节点v：若v未染色，则染色成与u不同的颜色，并对v重复第2步；若v已经染色，如果 u和v颜色相同，判定不可行退出遍历。
 * 若所有节点均已染色，则判定可行。
 * 输入
 * 第1行：1个正整数T(1≤T≤10)
 * 接下来T组数据，每组数据按照以下格式给出：
 * 第1行：2个正整数N,M(1≤N≤10,000，1≤M≤40,000)
 * 第2..M+1行：每行两个整数u,v表示u和v之间有一条边
 * 输出
 * 第1..T行：第i行表示第i组数据是否有误。如果是正确的数据输出”Correct”，否则输出”Wrong”
 */
public class hiho1121 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            int n = in.nextInt();
            int m = in.nextInt();
            int[][] graph = new int[n][n];
            // 0 represents none,1 represents white,2 represents black
            int[] colors = new int[n];
            for (int j = 0; j < m; j++) {
                int p = in.nextInt() - 1;
                int q = in.nextInt() - 1;
                graph[q][p] = graph[p][q] = 1;
            }
            System.out.println(canColor(graph, colors, n) ? "Correct" : "Wrong");
        }
    }

    // 可能有多个联通图
    private static boolean canColor(int[][] graph, int[] colors, int n) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        colors[0] = 1;
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            int currentColor = colors[currentNode];
            for (int i = 0; i < n; i++) {
                if (graph[currentNode][i] == 1) {
                    if (colors[i] == 0) {
                        colors[i] = 3 - currentColor;
                        queue.add(i);
                    } else {
                        if (currentColor == colors[i])
                            return false;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (colors[i] == 0)
                return false;
        }
        return true;
    }
}
