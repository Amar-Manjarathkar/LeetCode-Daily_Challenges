class Solution {
    int winnerHelper(int n, int k) // using recursion relation 
    {
        if (n==1) return 0; // returns true for k=1 and n=1

        return (winnerHelper(n-1,k)+k)%n;// +k for that if n=1, k=n-1
    }
public:
    int findTheWinner(int n, int k) {

        return (winnerHelper(n,k))+1;
        
    }
};
