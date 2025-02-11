class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int[][] distances = new int[26][26];
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                distances[i][j] = -1;
            }
        }
        for (int i = 0; i < 26; i++) {
            distances[i][i] = 0;
        }
        for (int i = 0; i < original.length; i++) {
            int a = original[i] - 'a';
            int b = changed[i] - 'a';
            if (distances[a][b] != -1) {
                distances[a][b] = Math.min(distances[a][b], cost[i]);
            } else {
                distances[a][b] = cost[i];
            }
        }
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    if (distances[i][k] != -1 && distances[k][j] != -1 && (distances[i][j] == -1 || distances[i][k] + distances[k][j] < distances[i][j])) {
                        distances[i][j] = distances[i][k] + distances[k][j];
                    }
                }
            }
        }
        long res = 0L;
        for (int i = 0; i < source.length(); i++) {
            int c = distances[source.charAt(i) - 'a'][target.charAt(i) - 'a'];
            if (c == -1) {
                return -1;
            }
            res += c;
        }
        return res;
    }
}
