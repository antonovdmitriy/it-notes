package dynamic.tab;

public class Fib {

    public static int fib(int n) {

        if(n == 0){
            return 0;
        }

        int[] tab = new int[n + 1];
        tab[1] = 1;

        for (int i = 0; i <= n; i++) {
            if (i + 1 < tab.length) {
                tab[i + 1] += tab[i];
            }
            if (i + 2 < tab.length) {
                tab[i + 2] += tab[i];
            }
        }

        return tab[n];
    }

    public static void main(String[] args) {

        // TIME: 0(n)
        // SPACE: 0(n)

        System.out.println(fib(1));
        System.out.println(fib(9)); // 34
        System.out.println(fib(30)); // 832040
    }
}
