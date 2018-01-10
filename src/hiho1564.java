import java.util.*;

/**
 * Created by mwindson on 2017/8/28.
 * https://hihocoder.com/problemset/problem/1564
 */
public class hiho1564 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] A = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            A[i] = in.nextInt();
        }
        Map<Integer, Set<Integer>> tree = new HashMap<>();
        Set<Integer> nodes = new HashSet<Integer>();
        for (int i = 1; i <= n; i++) {
            nodes.add(i);
            tree.put(i, new HashSet<Integer>());
        }
        for (int i = 1; i < n; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            Set<Integer> children = tree.get(a);
            children.add(b);
            tree.put(a, children);
            nodes.remove(b);
        }
        int root = nodes.iterator().next();
        long[] result = new long[1];
        dfs(A, tree, root, result);
        System.out.println(result[0]);
    }

    private static void dfs(int[] A, Map<Integer, Set<Integer>> g, int parent, long[] result) {
        if (!g.get(parent).isEmpty()) {
            for (int child : g.get(parent)) {
                dfs(A, g, child, result);
            }
            int max = 0;
            for (int child : g.get(parent)) {
                max = Math.max(max, A[child]);
            }
            for (int child : g.get(parent)) {
                result[0] += max - A[child];
            }
            A[parent] += max;
        }
    }
}
