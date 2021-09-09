package ee.bcs.valiit.service;

import ee.bcs.valiit.controller.model.BalanceAndStatusDto;
import ee.bcs.valiit.controller.model.BankAccountCustomerDto;
import ee.bcs.valiit.controller.model.CustomerAllAccountsDto;
import ee.bcs.valiit.controller.model.TransactionLogDto;
import ee.bcs.valiit.exception.ApplicationException;
import ee.bcs.valiit.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BankAccountService {

    @Autowired
    private BankAccountRepository accountRepository;

    public String createAccount(String accountNr, Integer customerId) {
        accountRepository.createAccount(accountNr, customerId);
        return accountNr + " balance is: 0";
    }

    public Integer addCustomer(String firstName, String lastName, String address) {
        return accountRepository.addCustomer(firstName, lastName, address);
    }

//    public String getBalance(String accountNr) {
//        Integer currentBalance = accountRepository.currentBalance(accountNr);
//        return accountNr + " balance is " + currentBalance;
//    }

    public String depositMoney(String accountNr, Integer amount) {
        BalanceAndStatusDto account = accountRepository.getAccountBalanceAndStatus(accountNr);
        String status = account.getAccountStatus();
        String qwerty = "locked";
        if (status.equals(qwerty)) {
            throw new ApplicationException("your account is locked");
        }
        if (amount < 0) {
            throw new ApplicationException("no can do this with negative amount");
        }
        Integer oldBalance = account.getAccountBalance();
        Integer newBalance = oldBalance + amount;
        accountRepository.newBalance(accountNr, newBalance);
        accountRepository.addTransactionLog(accountNr, amount, "deposit money", null);
        return accountNr + " balance is " + newBalance;
    }

    public String withdrawmoney(String accountNr, Integer amount) {
        BalanceAndStatusDto account = accountRepository.getAccountBalanceAndStatus(accountNr);
        String status = account.getAccountStatus();
        String qwerty = "locked";
        if (status.equals(qwerty)) {
            throw new ApplicationException("your account is locked");
        } else if (amount < 0) {
            throw new ApplicationException("no can do this with negative amount");
        }
        Integer oldBalance = account.getAccountBalance();
        Integer newBalance = oldBalance - amount;
        accountRepository.newBalance(accountNr, newBalance);
        accountRepository.addTransactionLog(accountNr, amount, "withdraw money", null);
        return accountNr + " balance is " + newBalance;
    }

    public String transferMoney(String fromAccount, String toAccount, Integer amount) {
        BalanceAndStatusDto accountFrom = accountRepository.getAccountBalanceAndStatus(fromAccount);
        BalanceAndStatusDto accountTo = accountRepository.getAccountBalanceAndStatus(toAccount);
        String statusFrom = accountFrom.getAccountStatus();
        String statusTo = accountTo.getAccountStatus();
        Integer fromAccountCurrentBalance = accountFrom.getAccountBalance();
        Integer toAccountCurrentBalance = accountTo.getAccountBalance();
        Integer fromAccountNewBalance = fromAccountCurrentBalance - amount;
        Integer toAccountNewBalance = toAccountCurrentBalance + amount;
        String qwerty = "locked";
        if ((statusFrom.equals(qwerty)) || (statusTo.equals(qwerty))) {
            throw new ApplicationException("no can transfer money, one of the accounts is locked");
        } else if (fromAccountNewBalance < 0) {
            throw new ApplicationException("no can transfer more money than you have");
        }
        accountRepository.newBalance(toAccount, toAccountNewBalance);
        accountRepository.newBalance(fromAccount, fromAccountNewBalance);
        accountRepository.addTransactionLog(fromAccount, amount, "transfer money", toAccount);
        accountRepository.addTransactionLog(toAccount, amount, "transfer money", fromAccount);
        return "fromAccountCurrentBalance is " + fromAccountCurrentBalance + " & fromAccountNewBalance is " + fromAccountNewBalance +
                " & toAccountCurrentBalance is " + toAccountCurrentBalance + " & toAccountNewBalance " + toAccountNewBalance;
    }

    public void updateAccountStatus(String accountNr, String status) {
        accountRepository.newStatus(accountNr, status);
    }

    public List<BankAccountCustomerDto> customerList() {
        return accountRepository.customerList();
    }

    public List<CustomerAllAccountsDto> getCustomerAllAccounts(Integer id) {
        return accountRepository.getCustomerAllAccounts(id);
    }

    public BalanceAndStatusDto getAccountBalanceAndStatus(String accountNr) {
        return accountRepository.getAccountBalanceAndStatus(accountNr);
    }

    public List<TransactionLogDto> getTransactionLog(String accountNr) {
        return accountRepository.getTransactionLog(accountNr);
    }


}
