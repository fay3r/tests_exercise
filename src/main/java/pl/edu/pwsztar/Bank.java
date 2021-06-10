package pl.edu.pwsztar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// TODO: Prosze dokonczyc implementacje oraz testy jednostkowe
// TODO: Prosze nie zmieniac nazw metod - wszystkie inne chwyty dozwolone
// TODO: (prosze jedynie trzymac sie dokumentacji zawartej w interfejsie BankOperation)
class Bank implements BankOperation {

    private Map<Integer, Account> accounts = new HashMap<Integer, Account>();

    private int accountNumber = 0;

    public int createAccount() {
        accountNumber++;
        accounts.put(accountNumber, new Account(accountNumber, 0));
        return accountNumber;
    }

    public int deleteAccount(int accountNumber) {

        Account account = accounts.remove(accountNumber);
        if(account==null){
            return ACCOUNT_NOT_EXISTS;
        }
        return account.getAmount();
    }

    public boolean deposit(int accountNumber, int amount) {
        if (amount < 0) {
            return false;
        }
        Account account = accounts.get(accountNumber);
        if (account == null) {
            return false;
        }
        account.setAmount(amount);
        accounts.put(accountNumber, account);

        return true;
    }

    public boolean withdraw(int accountNumber, int amount) {
        if (amount < 0) {
            return false;
        }
        Account account = accounts.get(accountNumber);
        if (account == null) {
            return false;
        }
        int newAmount = account.getAmount() - amount;
        if(newAmount<0){
            return false;
        }
        account.setAmount(newAmount);
        accounts.put(accountNumber, account);

        return true;
    }

    public boolean transfer(int fromAccount, int toAccount, int amount) {
        return false;
    }

    public int accountBalance(int accountNumber) {
        return 0;
    }

    public int sumAccountsBalance() {
        return 0;
    }
}
