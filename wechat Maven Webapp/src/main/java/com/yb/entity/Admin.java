package com.yb.entity;

public class Admin {
    private Integer id;
    private String name;
    private String password;
    private String code;

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", code='" + code + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Admin(Integer id, String name, String password, String code) {

        this.id = id;
        this.name = name;
        this.password = password;
        this.code = code;
    }

    public Admin() {

    }
}
