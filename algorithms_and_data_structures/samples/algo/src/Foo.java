import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class Foo {

    public void variables(int v) {
        int b = 1;
        Predicate<Integer> p1 = a -> {  // DOES NOT COMPILE
            int b = 0;                    // DOES NOT COMPILE
            int c = 0;
            return b == c; }  ;            // DOES NOT COMPILE
    }
}