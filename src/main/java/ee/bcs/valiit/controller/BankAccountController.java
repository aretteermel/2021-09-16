package ee.bcs.valiit.controller;

import ee.bcs.valiit.controller.model.*;
import ee.bcs.valiit.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BankAccountController {

    @Autowired
    private BankAccountService bankAccountService;

    // http://localhost:8080/bankaccountcontroller/addcustomer
    @PostMapping("bankaccountcontroller/addcustomer")
    public Integer addCustomer(@RequestBody CustomerDto x) {
        return bankAccountService.addCustomer(x.getFirstName(), x.getLastName(), x.getAddress());
    }

    // http://localhost:8080/bankaccountcontroller/createaccount?accountnr=EE111&customerid=1
    @PostMapping("bankaccountcontroller/createaccount")
    public String createAccount(@RequestParam("accountnr") String accountNr, @RequestParam("customerid") Integer customerId) {
        return bankAccountService.createAccount(accountNr, customerId);
    }

    // http://localhost:8080/bankaccountcontroller/getbalance?accountnr=EE111
    @GetMapping("bankaccountcontroller/getbalance")
    public String getBalance(@RequestParam("accountnr") String accountNr) {
        return bankAccountService.getBalance(accountNr);
    }

    // http://localhost:8080/bankaccountcontroller/getbalanceandstatus?accountnr=EE111
    @GetMapping("bankaccountcontroller/getbalanceandstatus")
    public BalanceAndStatusDto geBalanceAndStatus(@RequestParam("accountnr") String accountNr) {
        return bankAccountService.geBalanceAndStatus(accountNr);
    }

    // http://localhost:8080/bankaccountcontroller/depositmoney?accountnr=EE111&amount=100
    @PutMapping("bankaccountcontroller/depositmoney")
    public String depositMoney(@RequestParam("accountnr") String accountNr, @RequestParam("amount") Integer amount) {
        return bankAccountService.depositMoney(accountNr, amount);
    }

    // http://localhost:8080/bankaccountcontroller/withdrawmoney?accountnr=EE111&amount=100
    @PutMapping("bankaccountcontroller/withdrawmoney")
    public String withdrawmoney(@RequestParam("accountnr") String accountNr, @RequestParam("amount") Integer amount) {
        return bankAccountService.withdrawmoney(accountNr, amount);
    }

    // http://localhost:8080/bankaccountcontroller/transfermoney?fromaccount=EE111&toaccount=EE112&amount=10
    @PutMapping("bankaccountcontroller/transfermoney")
    public String transferMoney(@RequestParam("fromaccount") String fromAccount, @RequestParam("toaccount") String toAccount, @RequestParam("amount") Integer amount) {
        return bankAccountService.transferMoney(fromAccount, toAccount, amount);
    }

    // http://localhost:8080/bankaccountcontroller/updatestatus?accountnr=EE111&status=unlocked
    @PutMapping("bankaccountcontroller/updatestatus")
    public void updateStatus(@RequestParam("accountnr") String accountNr, @RequestParam("status") String status) {
        bankAccountService.updateStatus(accountNr, status);
    }

    // http://localhost:8080/bankaccountcontroller/allaccountslist
    @GetMapping("bankaccountcontroller/allaccountslist")
    public List<BankAccountCustomerDto> allAccountsList() {
        return bankAccountService.allAccountsList();
    }

    // http://localhost:8080/bankaccountcontroller/getcustomerallaccounts?id=2
    @GetMapping("bankaccountcontroller/getcustomerallaccounts")
    public List<CustomerAllAccountsDto> getCustomerAllAccounts(@RequestParam("id") Integer id) {
        return bankAccountService.getCustomerAllAccounts(id);
    }

    // http://localhost:8080/bankaccountcontroller/gettransactionlog?accountnr=EE111
    @GetMapping("bankaccountcontroller/gettransactionlog")
    public List<TransactionLogDto> getTransactionLog(@RequestParam("accountnr") String accountNr) {
        return bankAccountService.getTransactionLog(accountNr);
    }

}
