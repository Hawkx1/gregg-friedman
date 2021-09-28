package DAO;

import java.sql.SQLException;
import java.util.List;

public interface ProjectCRUD<T> {

    //create
        //save object to database method
        public void save(T row) throws SQLException;
    //read
        //query data from database, fill in empty model object
        public T getItemByID(int id) throws SQLException;
        public List<T> getAllItems() throws SQLException;
   //delete
        //remove by ID
        public void deleteByID(int id) throws SQLException;
}
