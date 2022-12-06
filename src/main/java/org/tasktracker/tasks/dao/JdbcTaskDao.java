package org.tasktracker.tasks.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.tasktracker.tasks.models.Task;

import javax.sql.DataSource;

public class JdbcTaskDao implements TaskDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcTaskDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private Task mapRowToTask(SqlRowSet rowSet) {
        Task task = new Task();
        return task;
    }
}
