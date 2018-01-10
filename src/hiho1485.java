import java.util.Scanner;

/**
 * Created by mwindson on 2017/8/22.
 * https://hihocoder.com/problemset/problem/1485
 * 描述
 * 如果一个字符串恰好包含2个'h'、1个'i'和1个'o'，我们就称这个字符串是hiho字符串。
 * 例如"oihateher"、"hugeinputhugeoutput"都是hiho字符串。
 * 现在给定一个只包含小写字母的字符串S，小Hi想知道S的所有子串中，最短的hiho字符串是哪个。
 * 输入
 * 字符串S
 * 对于80%的数据，S的长度不超过1000
 * 对于100%的数据，S的长度不超过100000
 * 输出
 * 找到S的所有子串中，最短的hiho字符串是哪个，输出该子串的长度。如果S的子串中没有hiho字符串，输出-1。
 */
public class hiho1485 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(shortestSequence(in.next()));
    }

    private static int shortestSequence(String s) {
        int start = 0, end = 0;
        int h_count = 0, i_count = 0, o_count = 0;
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'h' || s.charAt(i) == 'i' || s.charAt(i) == 'o') {
                start = i;
            }
        }
        return 0;
    }
}
