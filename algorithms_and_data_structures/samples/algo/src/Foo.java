import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

public class Foo {

    private static int doWork(int input) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {}
        return input;
    }

    public static void main(String[] args) {

    }
}