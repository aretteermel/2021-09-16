package ee.bcs.valiit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class Lesson4Controller {

    // Store account nr as a key and account balance as value
    public HashMap<String, Double> accountBalanceMap = new HashMap<>();

    // TODO 1
    // Add command: "createAccount ${accountNr}"
    // this has to store accountNr with 0 balance

    // http://localhost:8080/lesson4controller/createaccount?accountnr=EE123
    @GetMapping("lesson4controller/createaccount")
    public String createAccount(String accountnr) {
        accountBalanceMap.put(accountnr, 0.0);
        return "Sinu sisestatud konto nr on " + accountnr;
    }

    // TODO 2
    // Add command: "getBalance ${accountNr}"
    // this has to display account balance of specific acount

    // http://localhost:8080/lesson4controller/getbalance?accountnr=EE123
    @GetMapping("lesson4controller/getbalance")
    public String getBalance(String accountnr) {
        return "Sinu sisestatud konto nr'i bilanss on " + accountBalanceMap.get(accountnr);
    }

    // TODO 3
    // Add command: "depositMoney ${accountNr} ${amount}
    // this has to add specified amount of money to account
    // You have to check that amount is positive number

    // http://localhost:8080/lesson4controller/depositmoney?accountnr=EE123&amount=100
    @GetMapping("lesson4controller/depositmoney")
    public String depositMoney(@RequestParam("accountnr") String accountnr, @RequestParam("amount") int amount) {
        if (amount > 0) {
            Double oldBalance = accountBalanceMap.get(accountnr);
            Double newBalance = accountBalanceMap.get(accountnr) + amount;
            accountBalanceMap.put(accountnr, newBalance);
            return "Sinu eelnev kontojääk oli " + oldBalance + " Sinu uus kontojääk on " + newBalance;
        } else {
            return "Kontole kantav raha ei saa olla negatiivne";
        }
    }

    // TODO 4
    // Add command: "withdrawMoney ${accountNr} ${amount}
    // This has to remove specified amount of money from account
    // You have to check that amount is positive number
    // You may not allow this transaction if account balance would become negative

    // http://localhost:8080/lesson4controller/withdrawmoney?accountnr=EE123&amount=100
    @GetMapping("lesson4controller/withdrawmoney")
    public String withdrawMoney(@RequestParam("accountnr") String accountnr, @RequestParam("amount") int amount) {
        if (amount < 0) {
            return "Kontolt väljavõetav summa ei saa olla negatiivne";
        } else {
            Double oldBalance = accountBalanceMap.get(accountnr);
            Double newBalance = accountBalanceMap.get(accountnr) - amount;
            accountBalanceMap.put(accountnr, newBalance);
            if (newBalance <= 0) {
                return "Sa ei saa võtta kontolt välja raha rohkem kui sul on";
            }
            return "Sinu eelnev kontojääk oli " + oldBalance + " Sinu uus kontojääk on " + newBalance;
        }
    }

    // TODO 5
    // Add command: "transfer ${fromAccount} ${toAccount} ${amount}
    // This has to remove specified amount from fromAccount and add it to toAccount
    // Your application needs to check that toAccount and fromAccount exists
    // And that fromAccount has enough money to do that transaction

    // http://localhost:8080/lesson4controller/transfer?fromaccount=EE123&toaccount=EE456&amount=100
    @GetMapping("lesson4controller/transfer")
    public String transfer(@RequestParam("fromaccount") String fromaccount, @RequestParam("toaccount") String toaccount, @RequestParam("amount") int amount) {
        if ((null == accountBalanceMap.get(fromaccount)) || (null == accountBalanceMap.get(toaccount))) {
            return "Antud kontonumbrit ei ole olemas";
        }
        Double fromAccountOldBalance = (accountBalanceMap.get(fromaccount));
        Double fromAccountNewBalance = (accountBalanceMap.get(fromaccount) - amount);
        if (fromAccountNewBalance >= 0) {
            accountBalanceMap.put(fromaccount, accountBalanceMap.get(fromaccount) - amount);
            Double toAccountOldBalance = (accountBalanceMap.get(toaccount));
            Double toAccountNewBalance = (accountBalanceMap.get(toaccount) + amount);
            accountBalanceMap.put(toaccount, accountBalanceMap.get(toaccount) + amount);
            return "fromAccountOldBalance = " + fromAccountOldBalance + " fromAccountNewBalance = " + fromAccountNewBalance
                    + " toAccountOldBalance = " + toAccountOldBalance + " toAccountNewBalance = " + toAccountNewBalance;
        }
        return "Sa ei saa raha üle kanda rohkem kui kontol on";
    }
}