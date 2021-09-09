package ee.bcs.valiit.controller;

import ee.bcs.valiit.controller.model.SampleEmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {

    @Autowired
    private NamedParameterJdbcTemplate jbdcTemplate;

    @GetMapping("test")
    public String getHelloWorld(){
        return "Hello World";
    }
    //http://localhost:8080/test2/Arette
    //http://localhost:8080/test2/John

    @GetMapping("test2/{name}")
    public String test2(@PathVariable("name") String nimi) {
        return "Hello " + nimi;
    }

    //http://localhost:8080/test3?name=Arette   //?name= on antud juhul kohustuslik
    //http://localhost:8080/test3?name=John
    @GetMapping("test3")
    public String test3(@RequestParam("name") String nimi) {
        return "Hello " + nimi;
    }

    //http://localhost:8080/test4?name=Arette   //?name= on antud juhul kohustuslik
    //http://localhost:8080/test4?name=John
    @GetMapping("test4")
    public String test4(String name) {
        return "Hello " + name;
    }

    //http://localhost:8080/test5/
    @GetMapping("test5")
    public SampleEmployeeDto test5() {
        SampleEmployeeDto employee = new SampleEmployeeDto();
        employee.setName("Arette");
        employee.setAddress("Tallinn");
        return employee;
    }

    // GET - anna andmeid
    // POST - salvesta uued andmed
    // PUT - muuda andmeid
    // DELETE - kustuta andmed
    // :8080/employee
    // :8080/employee/1
    List<SampleEmployeeDto> employees = new ArrayList<>();

    @GetMapping("employee")
    public List<SampleEmployeeDto> getAllEmployees() {
        return employees;
    }

//    //http://localhost:8080/employee/1
//    @GetMapping("employee/{id}")
//    public SampleEmployeeDto getEmployee(@PathVariable("id") int id) {
//        return employees.get(id);
//    }

    // http://localhost:8080/employee/1
    @GetMapping("employee/{id}")
    public String getEmployee(@PathVariable("id") int id) {
        String sql = "SELECT name FROM employee WHERE id = :a1";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("a1", id);
        String vastus = jbdcTemplate.queryForObject(sql, paramMap, String.class);
        return vastus;
    }

    // http://localhost:8080/sql-test2  tagastab listi nimedest
    @GetMapping("sql-test2")
    public List<String> test2() {
        String sql = "SELECT name FROM employee";
        Map<String, Object> paramMap = new HashMap<>();
        List<String> vastus = jbdcTemplate.queryForList(sql, paramMap, String.class);
        return vastus;
    }

    // http://localhost:8080/sql-test3/1  väljasta ühe objekti kohta kogu info
    @GetMapping("sql-test3/{id}")
    public SampleEmployeeDto test3(@PathVariable("id") int id) {
        String sql = "SELECT * FROM employee WHERE id = :id";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        SampleEmployeeDto vastus = jbdcTemplate.queryForObject(sql, paramMap, new SampleEmployeeDtoRowMapper());
        return vastus;
    }

    // http://localhost:8080/sql-test4
    @GetMapping("sql-test4")
    public List<SampleEmployeeDto> test4() {
        String sql = "SELECT * FROM employee";
        Map<String, Object> paramMap = new HashMap<>();
        List<SampleEmployeeDto> vastus = jbdcTemplate.query(sql, paramMap, new SampleEmployeeDtoRowMapper());
        return vastus;
    }


    public static class SampleEmployeeDtoRowMapper implements RowMapper<SampleEmployeeDto> {
        @Override
        public SampleEmployeeDto mapRow(ResultSet resultSet, int i) throws SQLException {
            SampleEmployeeDto result = new SampleEmployeeDto();
            result.setId(resultSet.getInt("id"));
            result.setAddress(resultSet.getString("address"));
            result.setName(resultSet.getString("name"));
            return result;
        }
    }

//    //http://localhost:8080/employee/1
//    @PutMapping("employee/{id}")
//    public void updateEmployee(@PathVariable("id") int id, @RequestBody SampleEmployeeDto employeeDto) {
//        employees.set(id, employeeDto);
//    }

    //http://localhost:8080/employee/1
    @PutMapping("employee/{id}")

    public void updateEmployee(@PathVariable("id") int id, @RequestBody SampleEmployeeDto employeeDto) {
        String sql = "UPDATE employee SET name = :a1, address = :a2 WHERE id = :a3";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("a1", employeeDto.getName());
        paramMap.put("a2", employeeDto.getAddress());
        paramMap.put("a3", id);
        jbdcTemplate.update(sql,paramMap);
    }

    //http://localhost:8080/employee
    @PostMapping("employee")        //Palun lisa töötaja andmetega: nimi, aadress
    public void addEmployee(@RequestBody SampleEmployeeDto x) {
        String sql = "INSERT INTO employee (name, address) " + "VALUES (:employeeName, :employeeAddress)";
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("employeeName", x.getName());
        paramMap.put("employeeAddress", x.getAddress());
        jbdcTemplate.update(sql,paramMap);
//        employees.add(x);
    }


    //http://localhost:8080/employee/2
    @DeleteMapping("employee/{abcd}")
    public void deleteEmployee(@PathVariable("abcd") int qwerty) {
        String sql = "DELETE FROM employee WHERE id = :zxcv";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("zxcv", qwerty);
        jbdcTemplate.update(sql,paramMap);
//        employees.remove(id);
    }

}
