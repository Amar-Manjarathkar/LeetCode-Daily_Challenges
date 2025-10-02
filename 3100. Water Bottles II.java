class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int count =0;
        int empty = 0;
        while (numBottles > 0){
            numBottles--;
            count++;
            empty++;
            if(empty >=numExchange){
                empty=empty- numExchange;
                numBottles++;
                numExchange++;
            }
        }
        return count;
    }
}
