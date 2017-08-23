import java.util.Scanner;

/**
 * Created by mwindson on 2017/8/22.
 * https://hihocoder.com/problemset/problem/1501
 * 小Hi写程序时习惯用蛇形命名法(snake case)为变量起名字，即用下划线将单词连接起来，例如：file_name、 line_number。
 * 小Ho写程序时习惯用驼峰命名法(camel case)为变量起名字，即第一个单词首字母小写，后面单词首字母大写，例如：fileName、lineNumber。
 * 输入
 * 第一行包含一个整数N，表示测试数据的组数。(1 <= N <= 10)
 * 以下N行每行包含一个以某种命名法命名的变量名，长度不超过100。
 * 输入保证组成变量名的单词只包含小写字母。
 * 输出
 * 对于每组数据，输出使用另一种命名法时对应的变量名。
 */
public class hiho1501 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            String name = in.next();
            if (name.indexOf('_') == -1) {
                System.out.println(camelCaseToSnakeCase(name));
            } else {
                System.out.println(snakeCaseToCamelCase(name));
            }
        }
    }

    private static String snakeCaseToCamelCase(String s) {
        StringBuilder sb = new StringBuilder();
        boolean needChange = false;
        for (char c : s.toCharArray()) {
            if (c == '_') {
                needChange = true;
            } else {
                sb.append(needChange ? Character.toUpperCase(c) : c);
                needChange = false;
            }
        }
        return sb.toString();
    }

    private static String camelCaseToSnakeCase(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                sb.append('_');
                sb.append(Character.toLowerCase(c));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
