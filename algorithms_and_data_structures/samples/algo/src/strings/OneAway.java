package strings;

public class OneAway {

    // There are three type of edits that can be performed on strings: Insert a character, remove a character, or
    // replace a character. Give two strings, write a function to check if they are one edit (or zero edits) away.
    // Example:
    //pale, ple   -> true
    //pales, pale -> true
    //pale, bale  -> true
    //pale, bake  -> false

    public static boolean isEdit(String first, String second) {

        if (first.equals(second)) {
            return true;
        }

        if (second.length() - first.length() > 1 || first.length() - second.length() > 1) {
            return false;
        }

        String shorter = first.length() > second.length() ? second : first;
        String longer = first.length() > second.length() ? first : second;

        int differenceCount = 0;
        int shorterPointer = 0;
        int longerPointer = 0;
        while (shorterPointer < shorter.length() && longerPointer < longer.length()) {

            if (differenceCount > 1) {
                return false;
            }

            if (shorter.charAt(shorterPointer) == longer.charAt(longerPointer)) {
                shorterPointer++;
            } else {
                differenceCount++;
                if (shorter.length() == longer.length()) {
                    shorterPointer++;
                }
            }

            longerPointer++;
        }
        return true;
    }


    public static void main(String[] args) {

        System.out.println(isEdit("pale", "ple"));
        System.out.println(isEdit("pales", "pale"));
        System.out.println(isEdit("pale", "bale"));
        System.out.println(isEdit("pale", "bake"));
        System.out.println(isEdit("pale", "balet"));
        //pale, ple   -> true
        //pales, pale -> true
        //pale, bale  -> true
        //pale, bake  -> false
    }

}
