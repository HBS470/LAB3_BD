import DAO.DAO;
import DAO.DeptDAO;
import DAO.EmpDAO;
import DAO.DAOFactory;
import POJO.Dept;
import POJO.Emp;

import java.sql.*;

void main() {
  /* Load JDBC Driver. */
    try {
        Class.forName( "org.postgresql.Driver" );
    } catch ( ClassNotFoundException e ) {
        e.printStackTrace();
    }
    String url = "jdbc:postgresql://localhost/bd_isep?currentSchema=lab1";
    String user = "postgres";
    String pass = "Madesu95470.";
    Connection connexion = null;
    try {
        connexion = DriverManager.getConnection( url, user, pass );
        DAOFactory factory = new DAOFactory(connexion);
        DAO<Dept> departmentDao = factory.getDeptDAO();
        Dept dept20 = departmentDao.find(20);
        System.out.println(dept20);

        DAO<Emp> empDao = factory.getEmpDAO();
        Emp emp7521 = empDao.find(7521);
        System.out.println(emp7521);
        //System.out.println("Bdd Connected");
        //displayDepartment(connexion);
        //displayTable(connexion,"emp");
    } catch ( SQLException e ) {
        e.printStackTrace();
    } finally {
        if ( connexion != null )
            try {
                connexion.close();
            } catch ( SQLException ignore ) {
                ignore.printStackTrace();
            }
    }
}
public static void displayDepartment(Connection connexion) throws SQLException {
    Statement statement = connexion.createStatement();
    ResultSet resultat = statement.executeQuery("SELECT deptno, dname,loc FROM dept");
    while (resultat.next()) {
        int deptno = resultat.getInt("deptno");
        String dname = resultat.getString("dname");
        String loc = resultat.getString("loc");
        System.out.println("Department " + deptno + " is for "
                + dname + " and located in " + loc);
    }
    resultat.close();
}

public static void moveDepartment(Connection connexion,int empno, int newDeptno) throws SQLException {
    PreparedStatement preparedStatement = connexion.prepareStatement("UPDATE emp SET deptno = ? WHERE empno = ?");
    preparedStatement.setInt(1, empno);
    preparedStatement.setInt(2, newDeptno);
    preparedStatement.executeUpdate();
}

public static void displayTable(Connection connexion, String tableName) throws SQLException {
    Statement statement = connexion.createStatement();
    ResultSet results = statement.executeQuery("SELECT * FROM " + tableName);

    ResultSetMetaData rsmd = results.getMetaData();
    int columnsNumber = rsmd.getColumnCount();

    for (int i = 1; i <= columnsNumber; i++) {
        System.out.print(rsmd.getColumnName(i).toUpperCase() + " | ");
    }
    System.out.println();
    while (results.next()) {
        for (int i = 1; i <= columnsNumber; i++) {
            System.out.print(results.getString(i) + " | ");
        }
        System.out.println();
    }
    results.close();

}