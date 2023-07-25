package org.example.service;

import org.example.model.Movie;

import java.util.List;

public interface MovieService {
    void createMovie(String tableName, List<String> columns);

    /// SAVE JANY MAAHI KIRGIZUU;
    boolean saveMovie(Movie movie);

    /// FINDBYID  ID ILERI MENEN IZDOO;

    Movie findMovieById(Long id);

    void createTable(String tableName, List<String> columns);
}












