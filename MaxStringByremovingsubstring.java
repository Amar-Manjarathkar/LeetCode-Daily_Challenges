class Solution {
    public int maximumGain(String s, int x, int y) {
        // Determine high and low priority pairs
        String highPriorityPair = x > y ? "ab" : "ba";
        String lowPriorityPair = x > y ? "ba" : "ab";
        int highValue = Math.max(x, y);
        int lowValue = Math.min(x, y);

        // First pass: remove high priority pairs
        Result firstPassResult = removePairs(s, highPriorityPair);
        int score = firstPassResult.removedPairs * highValue;

        // Second pass: remove low priority pairs
        Result secondPassResult = removePairs(firstPassResult.remainingString, lowPriorityPair);
        score += secondPassResult.removedPairs * lowValue;

        return score;
    }

    private Result removePairs(String s, String pair) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (char c : s.toCharArray()) {
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == pair.charAt(0) && c == pair.charAt(1)) {
                sb.deleteCharAt(sb.length() - 1);
                count++;
            } else {
                sb.append(c);
            }
        }
        return new Result(sb.toString(), count);
    }

    private static class Result {
        String remainingString;
        int removedPairs;

        Result(String remainingString, int removedPairs) {
            this.remainingString = remainingString;
            this.removedPairs = removedPairs;
        }
    }
}
