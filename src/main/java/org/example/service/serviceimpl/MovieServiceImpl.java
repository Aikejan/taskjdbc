package org.example.service.serviceimpl;

import org.example.dao.daoimpl.MovieDaoImpl;
import org.example.model.Movie;
import org.example.service.MovieService;

import java.util.List;

public class MovieServiceImpl implements MovieService {


    MovieDaoImpl movieDaoService = new MovieDaoImpl();


    @Override
    public void createMovie(String tableName, List<String> columns) {
        movieDaoService.createTable(tableName, columns);
    }

    @Override
    public boolean saveMovie(Movie movie) {
        movieDaoService.save(movie);
        System.out.println("Success saved");
        return false;
    }

    @Override
    public Movie findMovieById(Long id) {
        return movieDaoService.findById(id);
    }


    @Override
    public void createTable(String tableName, List<String> columns) {
        movieDaoService.createTable(tableName, columns);
        System.out.println("Successfully created table with name: " + tableName);

    }
}
