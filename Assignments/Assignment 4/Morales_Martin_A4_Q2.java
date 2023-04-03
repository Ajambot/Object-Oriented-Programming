/*
Name: Martin Morales Arana
Student ID: 1172178
Assignment 4, Q2

The program implements a bank account that can be locked with a key.
If the account is locked, its methods cannot be accessed. The class
has some utility functions like withdraw, deposit, and addInterest
 */

import java.text.NumberFormat;

/**
 * Lockable interface which defines methods to lock and unlock a class with
 * a user key.
 */
interface Lockable{
    abstract public void setKey(int key);
    abstract public void lock(int key);
    abstract public void unlock(int key);
    abstract public boolean locked();
}

// Class Account. Can't access methods when locked with lock interface
class Account implements Lockable {
    private int key; // key to unlock and lock account
    private boolean locked; // true if class is locked, false if not
    private final double RATE = 0.035; // interest rate of 3.5%
    private String name;
    private long acctNumber;
    private double balance;

    // Initialized constructor. Class is always initialized as true
    public Account(String owner, long account, double initial, int key) {
        name = owner;
        acctNumber = account;
        balance = initial;
        this.key=key;
        locked = true;
    }

    /**
     * Deposits an amount to the account
     * @param amount money to be deposited
     * @return balance if class isn't locked, null if it is
     */
    public Double deposit(double amount) {
        if(locked){
            System.out.println("Account is locked, method cannot be invoked");
            return null;
        }
        if (amount > 0) {
            balance = balance + amount;
            return balance;
        }
        System.out.println("Cannot deposit negative amount");
        return balance;
    }

    /**
     * Withdraws an amount from the account
     * @param amount money to be withdrawn
     * @return balance if class isn't locked, null if it is
     */
    public Double withdraw(double amount, double fee) {
        if(locked){
            System.out.println("Account is locked, method cannot be invoked");
            return null;
        }
        if (amount + fee > 0 && amount + fee < balance) {
            balance = balance - amount - fee;
            return balance;
        }
        System.out.println("Cannot withdraw funds");
        return balance;
    }

    /**
     * Compunds interest to the account
     * @return balance if class isn't locked, null if it is
     */
    public Double addInterest() {
        if(locked){
            System.out.println("Account is locked, method cannot be invoked");
            return null;
        }
        balance += (balance * RATE);
        return balance;
    }

    /**
     * Gets the balance of the account
     * @return balance if class isn't locked, null if it is
     */
    public Double getBalance() {
        if(locked){
            System.out.println("Account is locked, method cannot be invoked");
            return null;
        }
        return balance;
    }

    /**
     * Converts account information to string
     * @return info as string if class isn't locked, null if it is
     */
    public String toString() {
        if(locked){
            System.out.println("Account is locked, method cannot be invoked");
            return null;
        }
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        return (acctNumber + "\t" + name + "\t" + fmt.format(balance));
    }

    /**
     * Sets key
     * @param key of account
     */
    @Override
    public void setKey(int key) {
        this.key=key;
    }

    /**
     * Locks the account if the key is correct
     * @param key key to be tried
     */
    @Override
    public void lock(int key) {
        if(this.key==key) locked=true;
        else System.out.println("The key provided is incorrect");
    }

    /**
     * Unlocks the account if the key is correct
     * @param key key to be tried
     */
    @Override
    public void unlock(int key) {
        if(this.key==key) locked=false;
        else System.out.println("The key provided is incorrect");
    }

    /**
     *
     * @return true if account is locked, false otherwise
     */
    @Override
    public boolean locked() {
        return locked;
    }
}

public class Morales_Martin_A4_Q2 {
    public static void main(String[] args) {
        Account acc = new Account("Martin", 1234, 25.0, 9999);
        System.out.println("The balance of the account is " + acc.getBalance());
        acc.unlock(1111);
        acc.unlock(9999);
        System.out.println("The balance of the account is " + acc.getBalance());
        acc.withdraw(12, 1.5);
        System.out.println("The balance of the account is " + acc.getBalance());
        System.out.println(acc.toString());
        acc.lock(9999);
        System.out.println("The balance of the account is " + acc.getBalance());
    }
}