package org.example.dao;

import org.example.model.ShowTime;

import java.sql.SQLException;

public interface ShowTimeDao {
    ShowTime save(ShowTime showTime);
    ShowTime  findById(Long showTimeId);

    void assign(ShowTime showTime) throws SQLException;
}
