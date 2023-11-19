package strings;

public class URLify {

    // Write a method to replace all spaces in a string with '%20'. You may assume that the string has
    // sufficient space at the end to hold additional characters, and that you are given the "true" length of
    // string. (Note: If implementing in Java, please use character array so that you can perform this
    // operation in place.)

    public String urlify(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') sb.append("%20");
            else sb.append(c);
        }

        return sb.toString();

    }

    public String urlify(char arr[], int len) {
        // Keep two pointers - one for actual string traversal other for new string

        for (int i = len - 1, j = arr.length - 1; i >= 0; i--) {
            if (arr[i] == ' ') {
                arr[j--] = '0';
                arr[j--] = '2';
                arr[j--] = '%';
            } else {
                arr[j--] = arr[i];
            }
        }

        return new String(arr);

    }

    public static void main(String[] args) {
        URLify main = new URLify();
        System.out.println(main.urlify("".toCharArray(), 0));
        System.out.println(main.urlify("abc".toCharArray(), 3));
        System.out.println(main.urlify("Mr John Smith    ".toCharArray(), 13));
    }

}
