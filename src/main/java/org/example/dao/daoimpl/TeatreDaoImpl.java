package org.example.dao.daoimpl;

import org.example.config.JdbsConfig;
import org.example.dao.TeatreDao;
import org.example.model.Teatre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeatreDaoImpl implements TeatreDao {
    private final Connection connection = JdbsConfig.getConnection();

    @Override
    public Teatre findById(Long teatreid) {
        Teatre teatre = new Teatre();
        try {
           PreparedStatement preparedStatement = connection.prepareStatement("""
                select  * from  teatres where id = ?
                """);
            long teatreId = 0;
            preparedStatement.setLong(1,teatreId);
      ResultSet resultSet =  preparedStatement.executeQuery();
      if(resultSet.next()){
          teatre.setId(resultSet.getLong("id"));
          teatre.setName(resultSet.getString("name"));
          teatre.setLocation(resultSet.getString("Location"));

      }else {
          throw new RuntimeException(String.format("Teater with id %d not found",teatreId));
      }

            }catch (SQLException e){
           throw  new RuntimeException();
        }
        return teatre;
    }

}
