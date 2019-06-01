package com.baizhi.entity;

import java.util.*;

public class User {
    private Integer id;
    private String username;
    private String password;
    private  String[]  names;
    private List<String> tels;
    private Set<String> sts;
    private Map<Integer,String> maps;
    private Properties props;

    public Properties getProps() {
        return props;
    }

    public void setProps(Properties props) {
        this.props = props;
    }

    public Map<Integer, String> getMaps() {
        return maps;
    }

    public void setMaps(Map<Integer, String> maps) {
        this.maps = maps;
    }

    public Set<String> getSts() {
        return sts;
    }

    public void setSts(Set<String> sts) {
        this.sts = sts;
    }

    public List<String> getTels() {
        return tels;
    }

    public void setTels(List<String> tels) {
        this.tels = tels;
    }

    public String[] getNames() {
        return names;
    }

    public void setNames(String[] names) {
        this.names = names;
    }

    public User() {
    }

    public User(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", names=" + Arrays.toString(names) +
                ", tels=" + tels +
                ", sts=" + sts +
                ", maps=" + maps +
                ", props=" + props +
                '}';
    }
}
