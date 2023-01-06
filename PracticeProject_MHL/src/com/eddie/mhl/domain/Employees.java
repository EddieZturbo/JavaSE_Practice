package com.eddie.mhl.domain;

/**
 @author EddieZhang
 @create 2022-09-13 15:45
 */
public class Employees {
    private Integer id;
    private String account;
    private String password;
    private String name;
    private String job;

    @Override
    public String toString() {
        return "Employees{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", job='" + job + '\'' +
                '}';
    }

    public Integer getid() {
        return id;
    }

    public void setid(Integer id) {
        this.id = id;
    }

    public String getaccount() {
        return account;
    }

    public void setaccount(String account) {
        this.account = account;
    }

    public String getpassword() {
        return password;
    }

    public void setpassword(String password) {
        this.password = password;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getjob() {
        return job;
    }

    public void setjob(String job) {
        this.job = job;
    }

    public Employees(Integer id, String account, String password, String name, String job) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.name = name;
        this.job = job;
    }

    public Employees() {
    }
}
