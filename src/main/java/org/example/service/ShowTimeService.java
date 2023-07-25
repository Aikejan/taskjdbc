package org.example.service;

import org.example.model.Movie;
import org.example.model.ShowTime;

import java.sql.SQLException;
import java.util.List;

public interface ShowTimeService {


    void createMovie(String tableName, List<String> columns);

    /// SAVE JANY MAAHI KIRGIZUU;
    void saveMovie(Movie movie);



    /// FINDBYID  ID ILERI MENEN IZDOO;

    Movie findMovieById(Long id);



    void createTable(String tableName, List<String> columns);
    Object save(ShowTime showTime);

    Movie findById(Long id);

    String assigh(Long showTimeId, Long movieId, Long teatreId) throws SQLException;




}
