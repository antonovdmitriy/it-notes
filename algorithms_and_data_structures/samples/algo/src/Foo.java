import java.util.Arrays;

public class Foo {


    void bar(String s1, String s2) {
        if (s1.length() > s2.length()) {

            for (int i = 0; i < s1.length(); i++) {
                System.out.println(s1.charAt(i));
            }

        } else {
            for (int j = 0; j < s1.length(); j++) {
                System.out.println(s2.charAt(j));
            }
        }
    }

}
