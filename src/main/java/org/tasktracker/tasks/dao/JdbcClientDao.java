package org.tasktracker.tasks.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.tasktracker.tasks.models.Client;

import javax.sql.DataSource;

public class JdbcClientDao implements ClientDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcClientDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private Client mapRowToClient(SqlRowSet rowSet) {
        Client client = new Client();
        client.setClientId(rowSet.getInt("client_id"));
        client.setClientName(rowSet.getString("client_name"));
        if (rowSet.getString("phone_number") != null) {
            client.setPhoneNumber(rowSet.getString("phone_number"));
        }
        if (rowSet.getString("email_address") != null) {
            client.setEmailAddress(rowSet.getString("email_address"));
        }
        return client;
    }
}
