package POJO;

public class Dept {
    private Long deptno;
    private String deptname;
    private String loc;

    @Override
    public String toString() {
        return "Department " + deptno + " is for "
                + deptname + " and located in " + loc;
    }

    public void setDeptno(Long deptno) {
        this.deptno = deptno;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }
}
