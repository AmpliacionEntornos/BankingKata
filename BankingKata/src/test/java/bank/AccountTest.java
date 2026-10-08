package bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    private Account account;
    @BeforeEach
    void setUp() {
        account = new Account();
    }
    @Test
    @DisplayName("Deposito incrementa saldo")
    void depositoIncrementaSaldo() {
        account.deposit(500);
        assertTrue(account.printStatement().contains("+ 500"));
    }
    @Test
    @DisplayName("Retiro descuenta saldo")
    void retiroDescuentaSaldo() {
        account.deposit(500);
        account.withdraw(100);
        assertTrue(account.printStatement().contains("- 100"));
    }
    @Test
    @DisplayName("Lanza excepcion si el saldo es insuficiente")
    void errorSaldoInsuficiente() {
        assertThrows(IllegalStateException.class, () -> account.withdraw(100));
    }

}