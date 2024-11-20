package finalExamMaterial.week15_Dec3_tues;

public class Account {
    private int _balance;
    private boolean _elite;

    //what do we need for the private fields?
    public int getBalance() {
        return _balance;
    }

    public boolean isElite() {
        return _elite;
    }

    //write global invariants
    //@public invariant getBalance() >= 0;
    //@public invariant isElite() == (getBalance() >= 1000000);

    //write globalAsserts method
    private void globalAsserts() {
        assert getBalance() >= 0;
        assert isElite() == (getBalance() >= 1000000);
    }

    public Account() {
        _balance = 0;
        _elite = false;
    }

    //write withdrawal and deposit methods + specifications

    /*@
        requires amount >= 0;
        ensures getBalance() == \old(getBalance()) + amount;
    */
    public void deposit(int amount) {
        //global invariants should hold
        globalAsserts();

        //enforce precondition
        if (amount < 0) {
            throw new IllegalArgumentException("amount must be nonnegative");
        }

        //save current balance for postcondition check
        int oldBalance = _balance;

        _balance += amount;

        if (_balance >= 1000000) {
            _elite = true;
        }

        //assert postcondition
        assert getBalance() == oldBalance + amount;


        //assert global invariants hold
        globalAsserts();
    }

    /*@
        requires amount <= getBalance();
        requires amount > 0;
        ensures getBalance() == \old(getBalance()) - amount;
     */
    public void withdraw(int amount) {
        //global invariants should hold
        globalAsserts();

        //save current balance for postcondition check
        int oldBalance = _balance;

        _balance -= amount;

        if (_balance < 1000000) {
            _elite = false;
        }

        //assert postcondition
        assert getBalance() == oldBalance - amount;


        //assert global invariants hold
        globalAsserts();
    }

}