package ee.bcs.valiit.tasks;

import ee.bcs.valiit.controller.Account;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class Lesson5 {
    // Lahenduse põhi on copytud Lesson4Controllerist
    // TODO täienda oma BankControllerit nii, et sa hoiad Map-is konto balanssi asemel konto objekti
    //  1)
    // Selleks loo uus konto objekt, mis sisaldab minimaalselt
    // * kontoNr
    // * kontoOmanikuNimi
    // * balanss
    // * kas konto on lukustatud
    // 2)
    // täienda konto loomis teenust nii, et sa salvestad ka konto omaniku nime
    // 3)
    // loo 2 uut teenust: lockAccount ja unlockAccount
    // 4)
    // juhul kui konto on lukustatud ei tohi saada sellele kontole raha juurde kande ega kontolt raha ära võtta
    // ehk siis withdrawMoney, depositMoney ja transferMoney teenused ei tohi töötada


    // Store account nr as a key and account balance as value
    public HashMap<String, Account> accountBalanceMap = new HashMap<>();

    // TODO 1
    // Add command: "createAccount ${accountNr}"
    // this has to store accountNr with 0 balance

    // http://localhost:8080/lesson5/createaccount?accountnr=EE123
    @GetMapping("lesson5/createaccount")
    public String createAccount(String accountNr) {
        Account a = new Account();
        a.setBalance(0.0);
        a.setAccountNr(accountNr);
        a.setLocked(false);
        accountBalanceMap.put(accountNr, a);
        return "Sinu sisestatud konto nr on " + accountNr;
    }

    // TODO 2
    // Add command: "getBalance ${accountNr}"
    // this has to display account balance of specific acount

    // http://localhost:8080/lesson5/getbalance?accountnr=EE123
    @GetMapping("lesson5/getbalance")
    public String getBalance(String accountnr) {
        Account accountSmth = accountBalanceMap.get(accountnr);
        return "Sinu sisestatud konto nr'i bilanss on " + accountSmth.getBalance();
    }

    // TODO 3
    // Add command: "depositMoney ${accountNr} ${amount}
    // this has to add specified amount of money to account
    // You have to check that amount is positive number

    // http://localhost:8080/lesson5/depositmoney?accountnr=EE123&amount=100
    @GetMapping("lesson5/depositmoney")
    public String depositMoney(@RequestParam("accountnr") String accountnr, @RequestParam("amount") int amount) {
        Account accountSmth = accountBalanceMap.get(accountnr);
        if (amount > 0) {
            Double oldBalance = accountSmth.getBalance();
            Double newBalance = oldBalance + amount;
            accountSmth.setBalance(newBalance);
            accountBalanceMap.put(accountnr, accountSmth);
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

    // http://localhost:8080/lesson5/withdrawmoney?accountnr=EE123&amount=100
    @GetMapping("lesson5/withdrawmoney")
    public String withdrawMoney(@RequestParam("accountnr") String accountnr, @RequestParam("amount") int amount) {
        Account accountSmth = accountBalanceMap.get(accountnr);
        if (amount < 0) {
            return "Kontolt väljavõetav summa ei saa olla negatiivne";
        } else {
            Double oldBalance = accountSmth.getBalance();
            Double newBalance = oldBalance - amount;
            accountBalanceMap.put(accountnr, accountSmth);
            if (newBalance < 0) {
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

    // http://localhost:8080/lesson5/transfer?fromaccount=EE123&toaccount=EE456&amount=100
    @GetMapping("lesson5/transfer")
    public String depositMoney(@RequestParam("fromaccount") String fromaccount, @RequestParam("toaccount") String toaccount, @RequestParam("amount") int amount) {
        Account accountSmth1 = accountBalanceMap.get(fromaccount);
        Account accountSmth2 = accountBalanceMap.get(toaccount);
        if ((null == accountBalanceMap.get(fromaccount)) || (null == accountBalanceMap.get(toaccount))) {
            return "Antud kontonumbrit ei ole olemas";
        }
        Double fromAccountOldBalance = (accountSmth1.getBalance());
        Double fromAccountNewBalance = (fromAccountOldBalance - amount);
        if (fromAccountNewBalance >= 0) {
//            accountBalanceMap.put(fromaccount, fromAccountNewBalance);
//            accountBalanceMap.put(fromaccount, accountBalanceMap.get(fromaccount) - amount);
//            Double toAccountOldBalance = (accountBalanceMap.get(toaccount));
//            Double toAccountNewBalance = (accountBalanceMap.get(toaccount) + amount);
//            accountBalanceMap.put(toaccount, accountBalanceMap.get(toaccount) + amount);
//            return "fromAccountOldBalance = " + fromAccountOldBalance + " fromAccountNewBalance = " + fromAccountNewBalance
//                    + " toAccountOldBalance = " + toAccountOldBalance + " toAccountNewBalance = " + toAccountNewBalance;
        }
        return "Sa ei saa raha üle kanda rohkem kui kontol on";
    }
}
