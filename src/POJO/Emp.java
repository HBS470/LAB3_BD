package POJO;

import java.util.Date;
public class Emp {
    private Long empNo;
    private String ename;
    private String efirst;
    private String job;
    private Emp mgr;
    private Date hireDate;
    private int sal;
    private int comm;
    private int tel;
    private Dept department;

    public void setEmpNo(Long empNo) {
        this.empNo = empNo;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setEfirst(String efirst) {
        this.efirst = efirst;
    }

    public void setMgr(Emp mgr) {
        this.mgr = mgr;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public void setComm(int comm) {
        this.comm = comm;
    }

    public void setDepartment(Dept department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empNo=" + empNo +
                ", ename='" + ename + '\'' +
                ", efirst='" + efirst + '\'' +
                ", job='" + job + '\'' +
                ", mgr=" + mgr +
                ", hireDate=" + hireDate +
                ", sal=" + sal +
                ", comm=" + comm +
                ", tel=" + tel +
                ", department=" + department +
                '}';
    }
}
