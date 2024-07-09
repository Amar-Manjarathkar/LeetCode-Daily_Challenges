class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        //track how many water bottles we have drunk
        int count = 0;
        //track the empty bottles we have
        int empty = 0;
        
        //as long as we have water bottles, keep drinking
        while(numBottles > 0){
            //drink a water bottle
            numBottles--;
            count++;
            //if we have any empty bottles, use them to get more water
            empty++;
            //if we have enough empties for an exchange, do it
            if(empty >= numExchange){
                //exchange empties for water
                numBottles += empty / numExchange;
                //update empty count
                empty = empty % numExchange;
            }
        }
        return count;
    }
}
