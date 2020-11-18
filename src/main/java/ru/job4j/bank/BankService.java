package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
        users.computeIfPresent(findByPassport(passport),
                ((user, accounts) -> {
                    if (accounts.contains(account)) {
                        System.out.println("The account was added earlier");
                    } else {
                        accounts.add(account);
                    }
                    return accounts;
                })
        );
    }

    public User findByPassport(String passport) {
        return users.keySet().stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    public Account findByRequisite(String passport, String requisite) {
        return users.getOrDefault(findByPassport(passport), new ArrayList<>()).stream()
                .filter(account -> account.getRequisite().equals(requisite))
                .findFirst()
                .orElse(null);
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null && srcAccount.getBalance() >= amount) {
            rsl = true;
            destAccount.setBalance(destAccount.getBalance() + amount);
            srcAccount.setBalance(srcAccount.getBalance() - amount);
        }
        return rsl;
    }
}