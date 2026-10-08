package bank;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private int balance = 0;
    private final List<String> transaction = new ArrayList<>();

    public void deposit(int amount){
        if(amount<=0){
            throw new IllegalArgumentException("Monto invalido");
        }
        balance+= amount;
        transaction.add(" + "+amount + " | Balance: " + balance);
    }
    public void withdraw(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Monto inválido");
        }
        if (amount > balance) {
            throw new IllegalStateException("Saldo insuficiente");
        }
        balance -= amount;
        transaction.add(" - " + amount + " | Balance: " + balance); }

    public String printStatement() {
        StringBuilder statement = new StringBuilder("Transaccion | Saldo Resultante");
        for (String t : transaction) {
            statement.append("\n").append(t);
        }
        return statement.toString();
    }
}
