package ee.bcs.valiit.repository;

import ee.bcs.valiit.controller.model.BalanceAndStatusDto;
import ee.bcs.valiit.controller.model.BankAccountCustomerDto;
import ee.bcs.valiit.controller.model.CustomerAllAccountsDto;
import ee.bcs.valiit.controller.model.TransactionLogDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BankAccountRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void createAccount(String accountNr, Integer customerId) {
        String sql = "INSERT INTO bank_account (account_id, balance, customer_id, status)" + "VALUES (:accountNr, 0, :customerId, 'unlocked')";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("accountNr", accountNr);
        paramMap.put("customerId", customerId);
        jdbcTemplate.update(sql, paramMap);
    }

    public Integer addCustomer(String firstName, String lastName, String address) {
        String sql = "INSERT INTO customer (first_name, last_name, address)" + "VALUES (:firstName, :lastName, :address)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("firstName", firstName);
        paramMap.put("lastName", lastName);
        paramMap.put("address", address);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(sql, new MapSqlParameterSource(paramMap), keyHolder);
        return (Integer) keyHolder.getKeys().get("id");
    }

    public Integer currentBalance(String accountNr) {
        String sql = "SELECT balance FROM bank_account WHERE account_id = :accountNr";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("accountNr", accountNr);
        return jdbcTemplate.queryForObject(sql, paramMap, Integer.class);
    }

    public void newBalance(String accountNr, Integer newBalance) {
        String sql = "UPDATE bank_account SET balance = :newBalance WHERE account_id = :accountNr";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("accountNr", accountNr);
        paramMap.put("newBalance", newBalance);
        jdbcTemplate.update(sql, paramMap);
    }

    public void updateStatus(String accountNr, String newStatus) {
        String sql = "UPDATE bank_account SET status = :newStatus WHERE account_id = :accountNr";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("accountNr", accountNr);
        paramMap.put("newStatus", newStatus);
        jdbcTemplate.update(sql, paramMap);
    }

    public String currentStatus(String accountNr) {
        String sql = "SELECT status FROM bank_account WHERE account_id = :accountNr";
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("accountNr", accountNr);
        return jdbcTemplate.queryForObject(sql, paramMap, String.class);
    }

    public static class BankAccountCustomerDtoRowMapper implements RowMapper<ee.bcs.valiit.controller.model.BankAccountCustomerDto> {

        @Override
        public ee.bcs.valiit.controller.model.BankAccountCustomerDto mapRow(ResultSet resultSet, int i) throws SQLException {
            BankAccountCustomerDto result = new BankAccountCustomerDto();
            result.setAccountNumber(resultSet.getString("account_id"));
            result.setAccountBalance(resultSet.getInt("balance"));
            result.setCustomerFirstName(resultSet.getString("first_name"));
            result.setCustomerLastName(resultSet.getString("last_name"));
            result.setCustomerAddress(resultSet.getString("address"));
            return result;
        }
    }

    public List<BankAccountCustomerDto> allAccountsList() {
        String sql = "SELECT * FROM bank_account ba JOIN customer c on ba.customer_id = c.id";
        Map<String, Object> paramMap = new HashMap<>();
        List<BankAccountCustomerDto> listOfAllCustomers = jdbcTemplate.query(sql, paramMap, new BankAccountCustomerDtoRowMapper());
        return listOfAllCustomers;
    }

    public static class CustomerAllAccountsDtoRowMapper implements RowMapper<CustomerAllAccountsDto> {

        @Override
        public CustomerAllAccountsDto mapRow(ResultSet resultSet, int i) throws SQLException {
            CustomerAllAccountsDto result = new CustomerAllAccountsDto();
            result.setAccountNumber(resultSet.getString("account_id"));
            result.setAccountBalance(resultSet.getInt("balance"));
            return result;
        }
    }

    public List<CustomerAllAccountsDto> getCustomerAllAccounts(Integer id) {
        String sql = "SELECT * FROM bank_account WHERE customer_id = :id";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        List<CustomerAllAccountsDto> listOfCustomerAccounts = jdbcTemplate.query(sql, paramMap, new CustomerAllAccountsDtoRowMapper());
        return listOfCustomerAccounts;
    }

    public static class BalanceAndStatusDtoRowMapper implements RowMapper<BalanceAndStatusDto> {

        @Override
        public BalanceAndStatusDto mapRow(ResultSet resultSet, int i) throws SQLException {
            BalanceAndStatusDto result = new BalanceAndStatusDto();
            result.setAccountBalance(resultSet.getInt("balance"));
            result.setAccountStatus(resultSet.getString("status"));
            return result;
        }
    }

    public BalanceAndStatusDto geBalanceAndStatus(String accountNr) {
        String sql = "SELECT * FROM bank_account WHERE account_id = :accountNr";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("accountNr", accountNr);
        return jdbcTemplate.queryForObject(sql, paramMap, new BalanceAndStatusDtoRowMapper());
    }

    public static class TransactionLogDtoRowMapper implements RowMapper<TransactionLogDto> {

        @Override
        public TransactionLogDto mapRow(ResultSet resultSet, int i) throws SQLException {
            TransactionLogDto result = new TransactionLogDto();
            result.setLogId(resultSet.getInt("log_id"));
            result.setAccountId(resultSet.getString("account_id"));
            result.setAmount(resultSet.getInt("amount"));
            result.setAction(resultSet.getString("action"));
            result.setConnectedAccountId(resultSet.getString("connected_account_id"));
            result.setTimestamp(resultSet.getObject("timestamp", LocalDateTime.class));
            return result;
        }
    }

    public Integer addTransactionLog(String accountNr, Integer amount, String action, String connectedAccountId) {
        String sql = "INSERT INTO transaction_log (account_id, timestamp, amount, action, connected_account_id)" + "VALUES " +
                "(:accountId, :timestamp, :amount, :action, :connectedAccountId)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("accountId", accountNr);
        paramMap.put("timestamp", LocalDateTime.now());
        paramMap.put("amount", amount);
        paramMap.put("action", action);
        paramMap.put("connectedAccountId", connectedAccountId);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(sql, new MapSqlParameterSource(paramMap), keyHolder);
        return (Integer) keyHolder.getKeys().get("log_id");
    }

    public List<TransactionLogDto> getTransactionLog(String accountNr) {
        String sql = "SELECT * FROM transaction_log WHERE account_id = :accountNr";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("accountNr", accountNr);
        List<TransactionLogDto> vastus = jdbcTemplate.query(sql, paramMap, new TransactionLogDtoRowMapper());
        return vastus;
    }

}
