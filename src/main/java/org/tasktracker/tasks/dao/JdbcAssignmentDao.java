package org.tasktracker.tasks.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.tasktracker.tasks.models.Assignment;

import javax.sql.DataSource;

public class JdbcAssignmentDao implements AssignmentDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcAssignmentDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private Assignment mapRowToAssignment(SqlRowSet rowSet) {
        Assignment assignment = new Assignment();
        return assignment;
    }
}
