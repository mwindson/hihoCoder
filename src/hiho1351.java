import java.util.*;

/**
 * Created by mwindson on 2018/1/13.
 * https://hihocoder.com/problemset/problem/1351
 */
public class hiho1351 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        TreeMap<String, Integer> purchase = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int m = in.nextInt();
            Set<String> prods = new HashSet<>();
            for (int j = 0; j < m; j++) {
                String id = in.next();
                in.next();
                String price = in.next();
                prods.add(id + price);
            }
            for (String p : prods) {
                int num = purchase.getOrDefault(p, 0);
                num++;
                purchase.put(p, num);
            }
        }
        for (Map.Entry<String, Integer> entry : purchase.entrySet()) {
            if (entry.getValue() == n) {
                System.out.println(entry.getKey().substring(0, 9));
            }
        }
    }
}
