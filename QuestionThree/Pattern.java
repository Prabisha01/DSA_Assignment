package QuestionThree;

public class Pattern {
    public static void main(String[] args) {
        String a1 = "tt";
        String pattern1 = "@";
        System.out.println(matchesPattern(a1, pattern1));  // Expected output: true

        String a2 = "ta";
        String pattern2 = "t";
        System.out.println(matchesPattern(a2, pattern2));  // Expected output: false

        String a3 = "ta";
        String pattern3 = "t#";
        System.out.println(matchesPattern(a3, pattern3));  // Expected output: true
    }

    public static boolean matchesPattern(String a, String pattern) {
        int aLength = a.length();
        int patternLength = pattern.length();

        // Edge case: pattern "@" matches entire string.
        if (pattern.equals("@")) {
            return a.equals(pattern);
        }

        // Edge case: pattern length is greater than string length.
        if (patternLength > aLength) {
            return false;
        }

        int i = 0;
        int j = 0;

        while (i < aLength && j < patternLength) {
            char aChar = a.charAt(i);
            char patternChar = pattern.charAt(j);

            if (patternChar == '#') {
                i++;
                j++;
            } else if (patternChar == '@') {
                // Check if remaining substring of a matches remaining pattern.
                return a.substring(i).equals(pattern.substring(j + 1));
            } else {
                if (aChar != patternChar) {
                    return false;
                }

                i++;
                j++;
            }
        }

        // If both pointers reached the end, then the pattern matches the string.
        return i == aLength && j == patternLength;
    }
}