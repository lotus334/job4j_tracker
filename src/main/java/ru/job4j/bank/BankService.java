package ru.job4j.bank;

import java.util.*;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
        var user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> accounts = users.get(user.get());
            if (accounts.contains(account)) {
                System.out.println("The account was added earlier");
            } else {
                accounts.add(account);
            }
        } else {
            System.out.println("User not found");
        }
    }

    public Optional<User> findByPassport(String passport) {
        return users.keySet().stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst();
    }

    public Optional<Account> findByRequisite(String passport, String requisite) {
        var user = findByPassport(passport);
        Optional<Account> account = Optional.empty();
        if (user.isPresent()) {
            account = users.getOrDefault(findByPassport(passport).get(), new ArrayList<>()).stream()
                    .filter(account1 -> account1.getRequisite().equals(requisite))
                    .findFirst();
        }
        return account;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        var rsl = false;
        var srcAccount = findByRequisite(srcPassport, srcRequisite);
        var destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount.isPresent()
                && destAccount.isPresent()
                && srcAccount.get().getBalance() >= amount) {
            rsl = true;
            destAccount.get()
                    .setBalance(destAccount.get().getBalance() + amount);
            srcAccount.get()
                    .setBalance(srcAccount.get().getBalance() - amount);
        }
        return rsl;
    }
}