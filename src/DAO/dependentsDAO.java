package DAO;

import java.sql.Connection;
import java.sql.SQLException;

public class dependentsDAO extends DAO{
    public dependentsDAO(Connection connect) {
        super(connect);
    }

    @Override
    public Object find(int id) throws SQLException {
        return null;
    }

    @Override
    public boolean update(Object object) {
        return false;
    }

    @Override
    public boolean create(Object object) {
        return false;
    }

    @Override
    public boolean delete(Object object) {
        return false;
    }
}
