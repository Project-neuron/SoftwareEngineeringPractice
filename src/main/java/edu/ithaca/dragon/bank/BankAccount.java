package edu.ithaca.dragon.bank;

public class BankAccount {

    private String email;
    private double balance;

    /**
     * @throws IllegalArgumentException if email is invalid
     */
    public BankAccount(String email, double startingBalance){
        if (isEmailValid(email)){
            this.email = email;
            this.balance = startingBalance;
        }
        else {
            throw new IllegalArgumentException("Email address: " + email + " is invalid, cannot create account");
        }
    }

    public double getBalance(){
        return balance;
    }

    public String getEmail(){
        return email;
    }

    /**
     * @post reduces the balance by amount if amount is non-negative and smaller than balance
     * if balance is zero and withdrawal is made the balance should remain 0 and not go negative.
     *
     */
    public void withdraw (double amount)  {
        this.balance -= amount;
        if(this.balance < 0){
            this.balance = 0;
        }

    }


    /**
     *
     * @param email needs to have at least an @ symbol and a . inside of it at some points
     *@return true or false
     */
    public static boolean isEmailValid(String email){
        if (email.indexOf('@') == -1 || email.indexOf('.') == -1){
            return false;
        }
        else {
            return true;
        }
    }
}
