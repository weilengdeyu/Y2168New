package cn.happy.entity;

/**
 * Created by Happy on 2017-12-27.
 */
//员工实体
public class Emp{
    private Integer empno;
    private String empname;
    private String empcity;
    //植入部门单个对象
    private Dept dept;

    public String getEmpcity() {
        return empcity;
    }

    public void setEmpcity(String empcity) {
        this.empcity = empcity;
    }

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }
}
