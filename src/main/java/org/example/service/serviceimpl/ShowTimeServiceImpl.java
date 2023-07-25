package org.example.service.serviceimpl;


import org.example.dao.TeatreDao;
import org.example.dao.daoimpl.ShowTimeDaoImpl;
import org.example.dao.daoimpl.TeatreDaoImpl;
import org.example.model.Movie;
import org.example.model.ShowTime;
import org.example.model.Teatre;
import org.example.service.MovieService;
import org.example.service.ShowTimeService;

import java.util.List;

public class ShowTimeServiceImpl implements ShowTimeService {
    ShowTimeDaoImpl showTimeService = new ShowTimeDaoImpl();
    TeatreDao teatreDaoService = new TeatreDaoImpl();
    MovieService movieService = new MovieServiceImpl();

    @Override
    public void createMovie(String tableName, List<String> columns) {

    }

    @Override
    public void saveMovie(Movie movie) {

    }

    @Override
    public Movie findMovieById(Long id) {
        return null;
    }

    @Override
    public void createTable(String tableName, List<String> columns) {

    }

    @Override
    public Object save(ShowTime showTime) {  // 1
        teatreDaoService.findById(showTime.getTeatre());
        movieService.findMovieById(showTime.getId());
        ShowTime timeMovie = showTimeService.save(showTime);
        showTimeService.save(showTime);
        System.out.println("Successfully saved fully id: " + timeMovie.toString());
        return null;
    }

    @Override
    public Movie findById(Long id) {
        return null;
    }

    @Override
    public String assigh(Long showTimeId, Long movieId, Long teatreId){
        ShowTime showTime = showTimeService.findById(showTimeId);
       //Movie movie = movieService.findById(movieId);
        Teatre teatre = teatreDaoService.findById(teatreId);
        showTime.setMovieid(movieId);
        showTime.setTeatre(teatreId);
        showTimeService.assign(showTime);
        return "Success assign";
    }

    }


