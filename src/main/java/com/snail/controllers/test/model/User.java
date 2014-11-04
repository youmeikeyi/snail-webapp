package com.snail.controllers.test.model;

import com.fasterxml.jackson.annotation.JsonView;

/**
 * User: jinchao.xu
 * Date: 14-10-23
 * Time: 下午3:52
 */
public class User {
    public interface WithoutPasswordView{};
    public interface WithPasswordView extends WithoutPasswordView{};

    private int id;
    private String username;
    private String password;

    public User(){}

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @JsonView(WithoutPasswordView.class)
    public String getUsername(){
        return this.username;
    }

    @JsonView(WithPasswordView.class)
    public String getPassword(){
        return this.password;
    }
}
