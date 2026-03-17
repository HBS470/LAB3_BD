package DAO;

import POJO.Dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeptDAO extends DAO{
    public DeptDAO(Connection connect) {
        super(connect);
    }

    @Override
    public Dept find(int id) throws SQLException {
        Dept dept = new Dept();
        PreparedStatement ps = connect.prepareStatement("SELECT * FROM dept WHERE deptno = ? ");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {

            dept.setDeptno(rs.getLong("deptno"));
            dept.setDeptname(rs.getString("dname"));
            dept.setLoc(rs.getString("loc"));
            return dept;
        }
        return null;
    }

    @Override
    public boolean create(Object object) {
        return false;
    }

    @Override
    public boolean update(Object object) {
        return false;
    }

    @Override
    public boolean delete(Object object) {
        return false;
    }
}
