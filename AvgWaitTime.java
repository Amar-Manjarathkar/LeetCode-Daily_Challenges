class Solution {
    public double averageWaitingTime(int[][] customers) {
        int nextIdleTime = 0; // Time when the chef will be next idle
        long netWaitTime = 0; // Total waiting time for all customers

        for (int[] customer : customers) {
            nextIdleTime = Math.max(customer[0], nextIdleTime) + customer[1];
            netWaitTime += nextIdleTime - customer[0];
        }

        return (double) netWaitTime / customers.length;
    }
}
