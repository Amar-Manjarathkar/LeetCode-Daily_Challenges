class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Integer[] indexes = new Integer[n];

        for (int i = 0; i < n; i++) {
            indexes[i] = i;
        }

        Arrays.sort(indexes, (a, b) -> positions[a] - positions[b]);

        List<Integer> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for (int index : indexes) {
            if (directions.charAt(index) == 'R') {
                stack.push(index);
            } else {
                while (!stack.isEmpty() && healths[index] > 0) {
                    int topIndex = stack.peek();
                    if (directions.charAt(topIndex) == 'R') {
                        if (healths[topIndex] == healths[index]) {
                            healths[topIndex] = 0;
                            healths[index] = 0;
                            stack.pop();
                        } else if (healths[topIndex] < healths[index]) {
                            healths[topIndex] = 0;
                            healths[index]--;
                            stack.pop();
                        } else {
                            healths[topIndex]--;
                            healths[index] = 0;
                        }
                    } else {
                        break;
                    }
                }
                if (healths[index] > 0) {
                    stack.push(index);
                }
            }
        }

        for (int health : healths) {
            if (health > 0) {
                res.add(health);
            }
        }

        return res;
    }
}
