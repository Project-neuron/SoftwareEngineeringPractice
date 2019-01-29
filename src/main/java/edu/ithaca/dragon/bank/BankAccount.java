package edu.ithaca.dragon.bank;

public class BankAccount {

    private String email;
    private double balance;

    /**
     * @throws IllegalArgumentException if email is invalid
     */
    public BankAccount(String email, double startingBalance){
        if (isEmailValid(email) && isAmountValid(startingBalance)){
            this.email = email;
            this.balance = startingBalance;
        }
        else {
            throw new IllegalArgumentException("Email address: " + email + " or Starting balance " + startingBalance + " is invalid, cannot create account" );
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
     * if balance is lower that the amount withdrawn and withdrawal is made the balance should remain 0.01 and not go negative.
     *
     */
    public void withdraw (double amount)  {

        if(isAmountValid(amount)) {
            this.balance -= amount;
            if (this.balance < 0) {
                this.balance = 0.01;
            }
        }
        else{
            throw new IllegalArgumentException("Amount inputted isn't valid double check documentation");

        }

    }


    /**
     *
     *@param email needs to have at least an @ symbol and a . inside of it at some point
     *             cannot have duplicate . or @ symbols or a . and an @ right together
     *             the ending dot needs to have at least 2 charachters near it
     *             there needs to be at least one charachter before the @ symbol
     *@return true or false
     */
    public static boolean isEmailValid(String email){
        if (email.indexOf('@') == -1 || email.indexOf('.') == -1){
            return false;
        }
        else if(email.contains("..") || email.contains("@@") || email.contains("@.")){
            return false;
        }
        else if(email.substring(0,email.indexOf(".")).length() < 1){
            return false;
        }
        else if(email.substring(email.lastIndexOf(".")).length() < 3){
            return false;
        }
        else if(email.substring(0,email.indexOf("@")).length() < 1) {
            return false;
        }
        return true;

    }

    /**
     *
     * @param amount needs to only have two decimal places and be not negative
     * @return true or false
     */

    public  static boolean isAmountValid(double amount){
        String text = Double.toString(Math.abs(amount));
        int integerPlaces = text.indexOf('.');
        int decimalPlaces = text.length() - integerPlaces - 1;
        boolean ans;
        if(amount > 0 && decimalPlaces <= 2){
             ans =true;
        }
        else{
            ans = false;

        }
        return ans;
    }
}
