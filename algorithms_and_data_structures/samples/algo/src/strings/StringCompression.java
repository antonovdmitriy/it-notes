package strings;

public class StringCompression {

    // Implement a method to perform basic string using counts of repeated characters.
    // If the compressed string would not become smaller than original string your method should return
    // the original string. You can assume the string has only uppercase and lowercase letters (a-z)
    //
    //Input: aabcccccaaa
    //Output: a2b1c5a3

    public static void main(String[] args) {
        System.out.println(compress("aabcccccaaa"));
    }

    private static String compress(String str) {

        if (str.isEmpty()) {
            return str;
        }

        StringBuilder compressed = new StringBuilder();
        int charCount = 1;
        Character previous = str.charAt(0);

        for (int i = 1; i < str.length(); i++) {
            Character current = str.charAt(i);

            if (current.equals(previous)) {
                charCount++;
            } else {
                compressed.append(previous);
                compressed.append(charCount);
                charCount = 1;
            }

            previous = current;
        }

        return compressed.length() < str.length() ? compressed.toString() : str;
    }

}
