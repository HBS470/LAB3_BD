package DAO;

import POJO.Dept;
import POJO.Emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpDAO extends DAO{
    public EmpDAO(Connection connect) {
        super(connect);
    }

    @Override
    public Emp find(int id) throws SQLException {
        DeptDAO deptDAO = new DeptDAO(connect);
        Emp emp = new Emp();
        PreparedStatement ps = connect.prepareStatement("SELECT * FROM emp WHERE empno = ? ");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            Dept dept = deptDAO.find(rs.getInt("deptno"));

            emp.setEmpNo(rs.getLong("empno"));
            emp.setEname(rs.getString("ename"));
            emp.setEfirst(rs.getString("efirst"));
            emp.setJob(rs.getString("job"));
            emp.setHireDate(rs.getDate("hiredate"));
            emp.setSal(rs.getInt("sal"));
            emp.setComm(rs.getInt("comm"));
            emp.setTel(rs.getInt("tel"));
            emp.setDepartment(dept);
            emp.setMgr(find(rs.getInt("mgr")));
            return emp;
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
