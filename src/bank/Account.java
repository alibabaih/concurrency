package bank;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {

    //что быдет если добавить volatile int balance?
    private int balance;

    public Lock getLock() {
        return l;
    }

    public void setLock(Lock l) {
        this.l = l;
    }

    Lock l = new ReentrantLock();

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Account(int initialBalance, Lock l) {
        this.balance = initialBalance;
        this.l = l;
    }

    public void withdraw(int amount) {
        balance -= amount;
    }

    public void deposit(int amount) {
        balance += amount;
    }
}
