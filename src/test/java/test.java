import org.junit.Test;

import java.util.Scanner;

public class test {
    @Test
    public void test() {
        int a = 199;
        int m = fangfa(a);
        System.out.print("res="+m);

    }

    public int fangfa(int x) {
        String s = String.valueOf(x);
        int res = 0;
        if (s.length() > 1) {
            for (int i = 0; i < s.length(); i++) {
//                System.out.println("第" + (i+1) + "位:" + s.substring(i, i+1));
                res += Integer.parseInt(s.substring(i, i + 1));
            }
            return fangfa(res);
        }else {
            return x;
        }
    }
}
