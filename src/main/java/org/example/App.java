package org.example;

import org.example.model.Movie;
import org.example.model.ShowTime;
import org.example.service.MovieService;
import org.example.service.ShowTimeService;
import org.example.service.serviceimpl.MovieServiceImpl;
import org.example.service.serviceimpl.ShowTimeServiceImpl;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException {

        MovieService movieService = new MovieServiceImpl();
        ShowTimeService showTimeService = new ShowTimeServiceImpl();



        movieService.createMovie(
                "movies",
                List.of(
                        "id serial primary key",
//                        "movie_id int references movies(id)",
//                        "theatre_id int references theatres(id)",
                        "start_time timestamp ",
                        "end_time timestamp"
                ));



        Scanner scannerForStr = new Scanner(System.in);
        Scanner scannerForNumber = new Scanner(System.in);


        while (true){
            switch (new Scanner(System.in).nextLine()){
                case "1", "save" ->{
                    System.out.println("Write title: ");
                    String title = scannerForStr.nextLine();
                    System.out.println("Write genre:");
                    String genre = scannerForStr.nextLine();
                    System.out.println("Write duration");
                    int duration = scannerForNumber.nextInt();
                    System.out.println(movieService.saveMovie(new Movie(title, genre, duration)));
                }
                case "2", "find" ->{
                    System.out.println("Write movie id:");
                    System.out.println(movieService.findMovieById(scannerForNumber.nextLong()));
                }
                case "3" ->{
                    String save = String.valueOf(showTimeService.save(new ShowTime(6L, 1L,
                            LocalDateTime.of(2023, 7,
                                    20,
                                    18,
                                    30,
                                    0),
                            LocalDateTime.of(2023, 7,
                                    20,
                                    20,
                                    30,
                                    0))
                    ));
                    System.out.printf( save);
                }
                case "4" ->{
                    showTimeService.assigh(1L,3L,2L);
                }
            }
        }
    }
    }

