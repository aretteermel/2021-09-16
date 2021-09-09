package ee.bcs.valiit.controller;

public class Account {

    private String AccountNr;
    private String ownersName;
    private Double Balance;
    private boolean Locked;

    public String getAccountNr() {
        return AccountNr;
    }

    public void setAccountNr(String accountNr) {
        this.AccountNr = accountNr;
    }

    public String getOwnersName() {
        return ownersName;
    }

    public void setOwnersName(String ownersName) {
        this.ownersName = ownersName;
    }

    public Double getBalance() {
        return Balance;
    }

    public void setBalance(Double balance) {
        this.Balance = balance;
    }

    public boolean isLocked() {
        return Locked;
    }

    public void setLocked(boolean locked) {
        Locked = locked;
    }
}
