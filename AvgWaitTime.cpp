class Solution {
public:
    double averageWaitingTime(vector<vector<int>>& customers) {
        int nextIdleTime=0; // to store the idle time of the chef
        long long netWaitTime=0; // to store the waiting time of each customers for their order

        for(int i=0; i<customers.size();i++)
        {
            nextIdleTime = max(customers[i][0],nextIdleTime)+customers[i][1];

            netWaitTime += nextIdleTime - customers[i][0]; //arrival time is denoted by [i][0]
        }
        // following operation to use for the average waiting time
        double averageWaitTime = 
         static_cast<double>(netWaitTime) / customers.size(); 
         // typecasting is used to convert the int to double for the netWaitTime

         return averageWaitTime;
        
    }
};
