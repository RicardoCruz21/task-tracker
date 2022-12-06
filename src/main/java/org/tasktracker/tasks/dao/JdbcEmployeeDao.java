package org.tasktracker.tasks.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.tasktracker.tasks.models.Employee;

import javax.sql.DataSource;

public class JdbcEmployeeDao implements EmployeeDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcEmployeeDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private Employee mapRowToEmployee(SqlRowSet rowSet) {
        Employee employee = new Employee();
        employee.setEmployeeId(rowSet.getInt("employee_id"));
        employee.setFirstName(rowSet.getString("first_name"));
        employee.setLastName(rowSet.getString("last_name"));
        employee.setJobTitle(rowSet.getString("job_title"));
        employee.setEmailAddress(rowSet.getString("email_address"));
        return employee;
    }
}
