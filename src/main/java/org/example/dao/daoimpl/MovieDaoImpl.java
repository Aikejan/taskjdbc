package org.example.dao.daoimpl;

import org.example.config.JdbsConfig;
import org.example.dao.MovieDao;
import org.example.model.Movie;

import java.sql.*;
import java.util.List;

public class MovieDaoImpl implements MovieDao {


    @Override
    public void createTable(String tableName, List<String> columns) {
        StringBuilder stringBuilder =
                new StringBuilder(String.format("create  table if not exists %s (", tableName));
        try {
            Connection connection = JdbsConfig.getConnection();
            Statement statement = connection.createStatement();
            for (int i = 0; i < columns.size(); i++) {
                stringBuilder.append(columns.get(i));
                if (i < columns.size() - 1) {
                    stringBuilder.append(", ");
                }
            }
            stringBuilder.append(")");
            statement.executeUpdate(stringBuilder.toString());
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void save(Movie movie) {
        try (
                Connection connection = JdbsConfig.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("""
                        insert into  movies (title,genre,duration)
                        values (?, ?,?)""")) {
            preparedStatement.setString(1, movie.getTitle());
            preparedStatement.setString(2, movie.getGenre());
            preparedStatement.setInt(3, movie.getDuration());
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Movie findById(Long id) {


        Movie movie = new Movie();
        try {
            Connection connection = JdbsConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("""
                     select * from  movies where id =?
                    """);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (!(resultSet.next())) {
                throw new RuntimeException("Movie with id: " + "not found!!!");
            } else {
                movie.setId((resultSet.getLong("id")));
                movie.setTitle(resultSet.getString("title"));
                movie.setGenre(resultSet.getString("genre"));
                movie.setDuration(resultSet.getInt("duration"));
            }


        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return movie;
    }
}






















