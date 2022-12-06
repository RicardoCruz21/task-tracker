package org.tasktracker.tasks.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.tasktracker.tasks.models.Meeting;

import javax.sql.DataSource;

public class JdbcMeetingDao implements MeetingDao {

    public final JdbcTemplate jdbcTemplate;

    public JdbcMeetingDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private Meeting mapRowToMeeting(SqlRowSet rowSet) {
        Meeting meeting = new Meeting();
        return meeting;
    }
}
