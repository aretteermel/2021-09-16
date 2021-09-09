package ee.bcs.valiit.tasks;

import java.util.HashMap;
import java.util.Scanner;

public class Lesson4 {
    // Store account nr as a key and account balance as value
    static HashMap<String, Double> accountBalanceMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Kirjuta allolevatest valikutest üks");
        System.out.println("createAccount");
        System.out.println("getBalance");
        System.out.println("depositMoney");
        System.out.println("withdrawMoney");
        System.out.println("transfer");
        System.out.println("Lõpetamiseks kirjuta exit");
        while (true) {
            String line = scanner.nextLine();
            if (line.equalsIgnoreCase("exit")) {
                break;
            }
            // TODO 1
            // Add command: "createAccount ${accountNr}"
            // this has to store accountNr with 0 balance
            else if (line.equalsIgnoreCase("createAccount")) {
                System.out.println("Sisesta uus kontonumber, mida soovid luua");
                String accountNumber = scanner.nextLine();
                accountBalanceMap.put(accountNumber, 0.0);
                System.out.println("Sisesta uus käsklus");
            }
            // TODO 2
            // Add command: "getBalance ${accountNr}"
            // this has to display account balance of specific acount
            else if (line.equalsIgnoreCase("getBalance")) {
                System.out.println("Sisesta kontonumber");
                String accountNumber = scanner.nextLine();
                System.out.println(accountBalanceMap.get(accountNumber));
                System.out.println("Sisesta uus käsklus");
            }
            // TODO 3
            // Add command: "depositMoney ${accountNr} ${amount}
            // this has to add specified amount of money to account
            // You have to check that amount is positive number
            else if (line.equalsIgnoreCase("depositMoney")) {
                System.out.println("Sisesta kontonumber");
                String accountNumber = scanner.nextLine();
                System.out.println("Sisesta summa, mida soovid kontole lisada");
                Double amount = scanner.nextDouble();
                scanner.nextLine();
                if (amount > 0) {
                    accountBalanceMap.put(accountNumber, accountBalanceMap.get(accountNumber) + amount);
                    System.out.println(accountBalanceMap.get(accountNumber));
                    System.out.println("Sisesta uus käsklus");
                } else {
                    System.out.println("Kontole kantav raha ei saa olla negatiivne");
                }
            }
            // TODO 4
            // Add command: "withdrawMoney ${accountNr} ${amount}
            // This has to remove specified amount of money from account
            // You have to check that amount is positive number
            // You may not allow this transaction if account balance would become negative
            else if (line.equalsIgnoreCase("withdrawMoney")) {
                System.out.println("Sisesta kontonumber");
                String accountNumber = scanner.nextLine();
                System.out.println("Sisesta summa, mida soovid kontolt välja võtta");
                Double amount = scanner.nextDouble();
                scanner.nextLine();

                if (amount < 0) {
                    System.out.println("Kontolt väljavõetav summa ei saa olla negatiivne");
                    System.out.println("Sisesta uus käsklus");
                } else if (accountBalanceMap.get(accountNumber) - amount < 0) {
                    System.out.println("Sa ei saa võtta kontolt välja raha rohkem kui sul on");
                    System.out.println("Sisesta uus käsklus");
                } else {
                    accountBalanceMap.put(accountNumber, accountBalanceMap.get(accountNumber) - amount);
                    System.out.println(accountBalanceMap.get(accountNumber));
                    System.out.println("Sisesta uus käsklus");
                }
            }
            // TODO 5
            // Add command: "transfer ${fromAccount} ${toAccount} ${amount}
            // This has to remove specified amount from fromAccount and add it to toAccount
            // Your application needs to check that toAccount and fromAccount exists
            // And that fromAccount has enough money to do that transaction
            else if (line.equalsIgnoreCase("transfer")) {
                System.out.println("Sisesta kontonumber, kust soovid raha üle kanda");
                String fromAccount = scanner.nextLine();

                if (null == accountBalanceMap.get(fromAccount)) {
                    System.out.println("Antud kontonumbrit ei ole olemas");
                    System.out.println("Sisesta uus käsklus");

                } else if (null != accountBalanceMap.get(fromAccount)) {
                    System.out.println("Sisesta kontonumber, kuhu soovid raha üle kanda");
                    String toAccount = scanner.nextLine();

                    if (null == accountBalanceMap.get(toAccount)) {
                        System.out.println("Antud kontonumbrit ei ole olemas");
                        System.out.println("Sisesta uus käsklus");

                    } else if (null != accountBalanceMap.get(toAccount)) {
                        System.out.println("Sisesta summa, mida soovid üle kanda");
                        Double amount = scanner.nextDouble();
                        scanner.nextLine();

                        if (accountBalanceMap.get(fromAccount) - amount < 0) {
                            System.out.println("Sa ei saa raha üle kanda rohkem kui kontol on");
                            System.out.println("Sisesta uus käsklus");

                        } else {
                            System.out.println("fromAccount kontol oli raha " + (accountBalanceMap.get(fromAccount)));
                            System.out.println("fromAccount konto bilanss on nüüd " + (accountBalanceMap.get(fromAccount) - amount));
                            accountBalanceMap.put(fromAccount, accountBalanceMap.get(fromAccount) - amount);
                            System.out.println("toAccount kontol oli raha " + (accountBalanceMap.get(toAccount)));
                            System.out.println("toAccount konto bilanss on nüüd " + (accountBalanceMap.get(toAccount) + amount));
                            accountBalanceMap.put(toAccount, accountBalanceMap.get(toAccount) + amount);

                            System.out.println("Sisesta uus käsklus");
                        }
                    }
                }
            }
        }
    }
}