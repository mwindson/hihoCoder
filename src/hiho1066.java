import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

/**
 * Created by mwindson on 2018/1/12.
 * https://hihocoder.com/problemset/problem/1066
 */
public class hiho1066 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int op = in.nextInt();
            String name1 = in.next();
            String name2 = in.next();
            if (op == 0) {
                merge(name1, name2, map);
            } else {
                System.out.println(findRepresent(name1, map).equals(findRepresent(name2, map)) ? "yes" : "no");
            }
        }
    }

    private static void merge(String name1, String name2, Map<String, String> map) {
        String root1 = findRepresent(name1, map);
        String root2 = findRepresent(name2, map);
        if (root1.equals(root2)) {
            return;
        }
        map.put(root1, root2);
    }

    private static String findRepresent(String v, Map<String, String> map) {
        if (!map.containsKey(v)) {
            map.put(v, v);
            return v;
        }
        if (Objects.equals(v, map.get(v))) {
            return v;
        } else {
            String represent = findRepresent(map.get(v), map);
            map.put(v, represent);
            return represent;
        }
    }
}
