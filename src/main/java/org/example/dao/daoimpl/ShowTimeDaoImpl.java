package org.example.dao.daoimpl;

import org.example.config.JdbsConfig;
import org.example.dao.ShowTimeDao;
import org.example.model.ShowTime;

import java.sql.*;
import java.time.LocalDateTime;

import static java.sql.Timestamp.*;

public class ShowTimeDaoImpl implements ShowTimeDao {
    private Connection connection = JdbsConfig.getConnection();

    @Override
    public ShowTime save(ShowTime showTime) {

        ShowTime showTime1 = new ShowTime();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("""
                    insert into  show_time(movie_id, teatre_id, start_time, end_time)
                    values (?,?,?,?)
                    """);
            preparedStatement.setLong(1, showTime.getMovieid());
            preparedStatement.setLong(2, showTime.getTeatre());
            preparedStatement.setTimestamp(3, valueOf(showTime.getStartTime()));
            preparedStatement.setTimestamp(4, valueOf(showTime.getEndTime()));
            preparedStatement.execute();


            preparedStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return getShowTimeFindStartAndEnd(showTime.getStartTime(), showTime.getEndTime());
    }

    @Override
    public ShowTime findById(Long showTimeId) {


        ShowTime showTime = new ShowTime();
        try {
            Connection connection = JdbsConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("""
                    select * from  show_time where id =?
                    """);
            preparedStatement.setLong(1, showTimeId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (!(resultSet.next())) {
                throw new RuntimeException("Show Time with id: " + showTimeId + "not found!!!");
            } else {
                showTime.setId(resultSet.getLong("id"));
                showTime.setMovieid(resultSet.getLong("movie_id"));
                showTime.setTeatre(resultSet.getLong("tetre_id"));
                showTime.setStartTime(resultSet.getTimestamp("start_time").toLocalDateTime());
                showTime.setStartTime(resultSet.getTimestamp("end_time").toLocalDateTime());
            }


        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return showTime;
    }

    @Override
    public void assign(ShowTime showTime)  {


          try {
            PreparedStatement preparedStatement = connection.prepareStatement("""
                update  show_time set 
                movie_id = ?,
                tetre_id = ?
                where id = ? 
                """);

            preparedStatement.setLong(1,showTime.getMovieid());
            preparedStatement.setLong(2,showTime.getTeatre());
            preparedStatement.setLong(3,showTime.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();

          }catch (SQLException e){
            throw  new RuntimeException(e);
         }
         }




    public ShowTime getShowTimeFindStartAndEnd(LocalDateTime start, LocalDateTime end) {

        ShowTime showTime = new ShowTime();
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement("""
                    select  * show_time where start_time ? and end_time = ?
                    """);
            statement.setTimestamp(1, valueOf(start));
            statement.setTimestamp(2, valueOf(end));
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                showTime.setId(resultSet.getLong("id"));

            } else {
                throw new RuntimeException("Not found shoe time");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return showTime;

    }
}
