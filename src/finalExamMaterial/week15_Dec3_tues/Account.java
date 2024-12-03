package finalExamMaterial.week15_Dec3_tues;

public class Account {
    private int _balance;
    private boolean _elite;

    public int getBalance() {
        return _balance;
    }

    public boolean isElite() {
        return _elite;
    }

    //global invariants
    /*@
        public invariant getBalance() >= 0;
        public invariant isElite() == (getBalance() >= 1000000);
    */

    //asserts the global invariants
    private void globalAsserts() {
        assert getBalance() >= 0;
        assert isElite() == (getBalance() >= 1000000);
    }

    public Account() {
        _balance = 0;
        _elite = false;

        //what should we do here?
    }
    /*@
        requires amount >= 0;
        ensures getBalance() == \old(getBalance()) + amount;
    */
    public void deposit(int amount) {
        //what do we do here?

        //check the preconditions
        if (amount < 0) {
            throw new IllegalArgumentException("deposit amount must be nonnegative");
        }

        //global invariants should be true
        globalAsserts();

        int oldBalance = _balance;

        _balance += amount;

        if (_balance >= 1000000) {
            _elite = true;
        }

        //what do we do here?
        //global invariants should still hold
        globalAsserts();

        //assert postconditions
        assert getBalance() == oldBalance + amount;
    }

    /*@
        requires amount <= getBalance();
        requires amount > 0;
        ensures getBalance() == \old(getBalance()) - amount;
     */
    public void withdraw(int amount) {
        //what do we do here?

        int oldBalance = _balance;

        _balance -= amount;

        if (_balance < 1000000) {
            _elite = false;
        }

        //what do we do here?
    }
}