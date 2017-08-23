import java.util.Scanner;

/**
 * Created by mwindson on 2017/8/22.
 * 描述
 * fjxmlhx每天都在被沼跃鱼刷屏，因此他急切的找到了你希望你写一个程序屏蔽所有句子中的沼跃鱼(“marshtomp”，不区分大小写)。
 * 为了使句子不缺少成分，统一换成 “fjxmlhx” 。
 * 输入
 * The Marshtomp has seen it all before.
 * marshTomp is beaten by fjxmlhx!
 * AmarshtompB
 * 输出
 * The fjxmlhx has seen it all before.
 * fjxmlhx is beaten by fjxmlhx!
 * AfjxmlhxB
 */
public class hiho1082 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            System.out.println(replaceMarshtomp(in.nextLine()));
        }
    }

    private static String replaceMarshtomp(String s) {
        String regex = "(?i)marshtomp";
        return s.replaceAll(regex, "fjxmlhx");
    }
}
