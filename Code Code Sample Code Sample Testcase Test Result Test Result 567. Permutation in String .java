class Solution {
    static {
        for (int i = 0; i < 200; i++) {
            checkInclusion("a", "");
        }
    }

    public static boolean checkInclusion(String s1, String s2) {
        final int len1 = s1.length();
        final int len2 = s2.length();
        if (len1 > len2) {
            return false;
        }

        final int[] counters = new int[26];
        for (int i = 0; i < len1; i++) {
            counters[s1.charAt(i) - 'a']++;
            counters[s2.charAt(i) - 'a']--;
        }

        int deltaCount = 0;
        for (int i = 0; i < 26; i++) {
            if (counters[i] < 0) {
                deltaCount++;
            }
        }
        if (deltaCount == 0) {
            return true;
        }

        for (int i = len1; i < len2; i++) {
            final int removeC = s2.charAt(i - len1) - 'a';
            final int addC = s2.charAt(i) - 'a';

            counters[removeC]++;
            if (counters[removeC] == 0) {
                deltaCount--;
            }

            counters[addC]--;
            if (counters[addC] == -1) {
                deltaCount++;
            }

            if (deltaCount == 0) {
                return true;
            }
        }
        return false;
    }
    
}
