class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fiveDollarBills = 0, tenDollarBills = 0;
        
        for (int bill : bills) {
            if (bill == 5) {
                fiveDollarBills++;
            } else if (bill == 10) {
                if (fiveDollarBills == 0) return false;
                fiveDollarBills--;
                tenDollarBills++;
            } else {
                if (fiveDollarBills > 0 && tenDollarBills > 0) {
                    fiveDollarBills--;
                    tenDollarBills--;
                } else if (fiveDollarBills >= 3) {
                    fiveDollarBills -= 3;
                } else {
                    return false;
                }
            }
        }
        
        return true;
    }
}
