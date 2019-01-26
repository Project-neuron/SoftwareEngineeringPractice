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
        BankAccount studentAccount = new BankAccount("s@edu.com", 0);
        studentAccount.withdraw(0);
        bankAccount.withdraw(100);
        studentAccount.withdraw(100);
        assertEquals(100, bankAccount.getBalance());
        assertEquals(0,studentAccount.getBalance());
    }

    @Test
    void isEmailValidTest(){
        assertEquals(true, BankAccount.isEmailValid( "a@b.com"));
        assertEquals(false, BankAccount.isEmailValid("ab.com"));
        assertEquals(false,BankAccount.isEmailValid("a@bcom"));
        assertFalse( BankAccount.isEmailValid(""));
    }

    @Test
    void constructorTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);

        assertEquals("a@b.com", bankAccount.getEmail());
        assertEquals(200, bankAccount.getBalance());
        //check for exception thrown correctly
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("", 100));
    }

}