package bank;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private int saldo = 0;
    private final List<String> movimientos = new ArrayList<>();

    public void deposit(int monto){
        if(monto<=0){
            throw new IllegalArgumentException("Monto invalido");
        }
        saldo+= monto;
        movimientos.add(" + "+monto + " | Balance: " + saldo);
    }
    public void withdraw(int monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("Monto inválido");
        }
        if (monto > saldo) {
            throw new IllegalStateException("Saldo insuficiente");
        }
        saldo -= monto;
        movimientos.add(" - " + monto + " | Balance: " + saldo); }

    public String printStatement() {
        StringBuilder statement = new StringBuilder("Transaccion | Saldo Resultante");
        for (String movimiento : movimientos) {
            statement.append("\n").append(movimiento);
        }
        return statement.toString();
    }
}
