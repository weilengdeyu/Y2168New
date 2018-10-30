package cn.happy.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Happy on 2017-12-27.
 * 部门实体
 */
public class Dept {

    private Integer deptno; //部门编号
    private String deptname; //部门名称
    //部门实体中植入员工的一个集合
    //集合选择的时候，博客+课本为什么选择 Set，不选择List，List不是大家 最熟悉的吗？
    //List<>  Set<>
    //Set集合中元素唯一的   （） add():法则，依据 ： equals() hashcode()
    //两个hash值一样的对象，不一定是同一个对象，
    //同一个对象，hash一定相同
    private Set<Emp> emps=new HashSet<Emp>();

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public Set<Emp> getEmps() {
        return emps;
    }

    public void setEmps(Set<Emp> emps) {
        this.emps = emps;
    }
}
