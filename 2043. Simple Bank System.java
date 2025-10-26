class Bank {

    // Use a private array to store the balances.
    private long[] balances;
    // Store the total number of accounts for easy validation.
    private int numAccounts;

    /**
     * Initializes the Bank object.
     * @param balance A 0-indexed array of initial balances.
     * balance[i] is the initial balance for account (i + 1).
     */
    public Bank(long[] balance) {
        this.balances = balance;
        this.numAccounts = balance.length;
    }

    /**
     * Helper function to check if an account number is valid (between 1 and n).
     */
    private boolean isValidAccount(int account) {
        return account >= 1 && account <= numAccounts;
    }
    
    /**
     * Transfers money from account1 to account2.
     * @return true if the transaction is successful, false otherwise.
     */
    public boolean transfer(int account1, int account2, long money) {
        // 1. Validate both account numbers.
        if (!isValidAccount(account1) || !isValidAccount(account2)) {
            return false;
        }

        // Get 0-based indices
        int index1 = account1 - 1;
        int index2 = account2 - 1;

        // 2. Validate the funds in the source account.
        if (balances[index1] < money) {
            return false;
        }
        
        // 3. Perform the transaction (all checks passed).
        balances[index1] -= money;
        balances[index2] += money;
        return true;
    }
    
    /**
     * Deposits money into an account.
     * @return true if the transaction is successful, false otherwise.
     */
    public boolean deposit(int account, long money) {
        // 1. Validate the account number.
        if (!isValidAccount(account)) {
            return false;
        }

        // 2. Perform the deposit (no other checks needed).
        balances[account - 1] += money;
        return true;
    }
    
    /**
     * Withdraws money from an account.
     * @return true if the transaction is successful, false otherwise.
     */
    public boolean withdraw(int account, long money) {
        // 1. Validate the account number.
        if (!isValidAccount(account)) {
            return false;
        }

        // Get 0-based index
        int index = account - 1;

        // 2. Validate the funds.
        if (balances[index] < money) {
            return false;
        }

        // 3. Perform the withdrawal (all checks passed).
        balances[index] -= money;
        return true;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */
