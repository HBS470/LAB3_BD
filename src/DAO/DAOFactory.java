package DAO;

import java.sql.Connection;

public class DAOFactory {
    private Connection connect;
    public DAOFactory(Connection connect) {
        this.connect = connect;
    }
    public DAO getDeptDAO(){
        return new DeptDAO(connect);
    }
    public DAO getEmpDAO(){
        return new EmpDAO(connect);
    }
    public DAO getdependentsDAO(){
        return new dependentsDAO(connect);
    }
    public DAO getBonusDAO(){
        return new BonusDAO(connect);
    }

}
