package org.example.dao;

import org.example.model.Movie;

import java.util.List;

public interface MovieDao {

    /// CREATE  TABLISA TUZUU;
        void createTable(String tableName, List<String> columns);

        //  SAVE  JANY MAANI KIRGIZUU

        void save(Movie movie);

        /// FINDBYID  ID IJERI MENEN IZDEYT;

        Movie findById(Long id);

    }

