package edu.ithaca.dragon.bank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void getBalanceTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);

        assertEquals(200, bankAccount.getBalance());
    }

    @Test
    void withdrawTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);
        BankAccount studentAccount = new BankAccount("s@edu.com", 0.01);
        bankAccount.withdraw(100);
        studentAccount.withdraw(100);
        assertEquals(100, bankAccount.getBalance());
        assertEquals(0.01,studentAccount.getBalance());

        assertThrows(IllegalArgumentException.class, () -> bankAccount.withdraw(-1));
        assertThrows(IllegalArgumentException.class, () -> bankAccount.withdraw(100.001));
    }

    @Test
    void isEmailValidTest(){
        assertEquals(true, BankAccount.isEmailValid( "a@b.com"));
        assertEquals(false, BankAccount.isEmailValid("ab.com"));
        assertEquals(false,BankAccount.isEmailValid("a@bcom"));
        assertFalse(BankAccount.isEmailValid("..@.com"));
        assertFalse(BankAccount.isEmailValid("@.com"));
        assertFalse(BankAccount.isEmailValid(".stuff@.com"));
        assertFalse(BankAccount.isEmailValid("a.b@gmail.c"));
        assertTrue(BankAccount.isEmailValid("a.b@gmail.co"));
        assertFalse( BankAccount.isEmailValid(""));
    }

    @Test
    void constructorTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);

        assertEquals("a@b.com", bankAccount.getEmail());
        assertEquals(200, bankAccount.getBalance());

        //check for exception thrown correctly
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("", 100));
        assertThrows(IllegalArgumentException.class, () -> new BankAccount("a@b.com", 100.001));
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("a@b.com", -1));
    }
    @Test
    void isAmountValidTest(){
        assertEquals(false, BankAccount.isAmountValid(0.00));
        assertEquals(false, BankAccount.isAmountValid(0.001));
        assertEquals(false, BankAccount.isAmountValid(0.009));
        assertEquals(true, BankAccount.isAmountValid(0.01));
        assertEquals(true, BankAccount.isAmountValid(20.00));
        assertEquals(false, BankAccount.isAmountValid(20.001));
        assertEquals(false, BankAccount.isAmountValid(20.009));
        assertEquals(true, BankAccount.isAmountValid(20.01));

    }

}