class Solution {
    public String countOfAtoms(String formula) {
        int n = formula.length();
        Stack<HashMap<String, Integer>> stack = new Stack<>();
        stack.push(new HashMap<String, Integer>());
        int index = 0;
        
        while (index < n) {
            char ch = formula.charAt(index);
            if (ch == '(') {
                stack.push(new HashMap<String, Integer>());
                index++;
            } else if (ch == ')') {
                HashMap<String, Integer> currMap = stack.pop();
                index++;
                // Find the multiplier
                StringBuilder multiplier = new StringBuilder();
                while (index < n && Character.isDigit(formula.charAt(index))) {
                    multiplier.append(formula.charAt(index));
                    index++;
                }
                // Multiply the count 
                int m = (multiplier.length() > 0) ? Integer.parseInt(multiplier.toString()) : 1;
                for (String atom : currMap.keySet()) {
                    currMap.put(atom, currMap.get(atom) * m);
                }
                for (String atom : currMap.keySet()) {
                    stack.peek().put(atom, stack.peek().getOrDefault(atom, 0) + currMap.get(atom));
                }
            } else {
                // Atom name and count are handled here
                StringBuilder atomName = new StringBuilder();
                atomName.append(ch);
                index++;
                while (index < n && Character.isLowerCase(formula.charAt(index))) {
                    atomName.append(formula.charAt(index));
                    index++;
                }
                StringBuilder count = new StringBuilder();
                while (index < n && Character.isDigit(formula.charAt(index))) {
                    count.append(formula.charAt(index));
                    index++;
                }
                int c = (count.length() > 0) ? Integer.parseInt(count.toString()) : 1;
                stack.peek().put(atomName.toString(), stack.peek().getOrDefault(atomName.toString(), 0) + c);
            }
        }
        
        TreeMap<String, Integer> sortedMap = new TreeMap<>(stack.peek());
        StringBuilder res = new StringBuilder();
        for (String atom : sortedMap.keySet()) {
            res.append(atom);
            int count = sortedMap.get(atom);
            if (count > 1) {
                res.append(count);
            }
        }
        return res.toString();
    }
}
