import java.util.*;

/**
 * Created by mwindson on 2017/8/23.
 * https://hihocoder.com/problemset/problem/1559
 * 描述
 * 小Hi的电脑的文件系统中一共有N个文件，例如：
 * /hihocoder/offer23/solutions/p1
 * /hihocoder/challenge30/p1/test
 * /game/moba/dota2/uninstall
 * 经过统计，小Hi认为他的电脑中子目录实在太多了，于是他决定减少子目录的数量。小Hi发现其中一些子目录只包含另一个子目录，例如/hihocoder/offer22只包含一个子目录solution，/game只包含一个子目录moba，而moba也只包含一个子目录dota2。小Hi决定把这样的子目录合并成一个子目录，并且将被合并的子目录的名字用'-'连起来作为新子目录的名字。合并之后上例的3个文件的路径会变为：
 * /hihocoder/offer23-solutions/p1
 * /hihocoder/challenge30-p1/test
 * /game-moba-dota2/uninstall
 * 输入
 * 第一行包含一个整数N (1 ≤ N ≤ 10000)
 * 以下N行每行包含一个字符串，代表一个文件的绝对路径。保证路径从根目录"/"开始，并且文件名和目录名只包含小写字母和数字。
 * 对于80%的数据，N个文件的绝对路径长度之和不超过10000
 * 对于100%的数据，N个文件的绝对路径长度之和不超过500000
 * 输出
 * 对于输入中的每个文件，输出合并子目录之后该文件的绝对路径。
 */
/*
8
/hihocoder/offer23/solutions/p1
/hihocoder/challenge30/p1/test
/game/moba/dota2/uninstall
/game/moba/lol/install
/hihocoder/offer21/p1
/hihocoder/offer21
/1/11/1/1/1/1/1/1/1/1/1/1/1/1/1/1/1/1/11//11/1/11/1/1/1/1/1/1
/b/b/bb
*/
public class hiho1559 {
    static class Trie {
        public String val;
        public List<Trie> children;

        Trie(String s) {
            val = s;
            children = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        List<String> list = new ArrayList<>();
        Trie root = new Trie("");
        for (int i = 0; i < N; i++) {
            String s = in.next();
            list.add(s);
            buildFileTree(root, s);
        }
        for (String s : list)
            printNewDir(root, s);
    }

    private static void buildFileTree(Trie root, String s) {
        String[] strs = s.split("/");
        for (int i = 1; i < strs.length; i++) {
            Trie node = new Trie(strs[i]);
            boolean has = false;
            for (Trie t : root.children) {
                if (Objects.equals(t.val, node.val)) {
                    node = t;
                    has = true;
                }
            }
            if (!has) root.children.add(node);
            root = node;
        }
    }

    private static void printNewDir(Trie root, String s) {
        String[] strs = s.split("/");
        StringBuilder sb = new StringBuilder();
        sb.append("/").append(strs[1]);
        Trie currentT = root;
        for (Trie t : currentT.children) {
            if (Objects.equals(t.val, strs[1]))
                currentT = t;
        }
        if (currentT.children.size() == 0) {
            System.out.println(sb.toString());
            return;
        }
        for (int i = 2; i < strs.length - 1; i++) {
            if (currentT.children.size() == 1) {
                sb.append("-");
            } else {
                sb.append("/");
            }
            sb.append(strs[i]);
            for (Trie t : currentT.children) {
                if (Objects.equals(t.val, strs[i]))
                    currentT = t;
            }
        }
        sb.append("/").append(strs[strs.length - 1]);
        System.out.println(sb.toString());
    }
}
