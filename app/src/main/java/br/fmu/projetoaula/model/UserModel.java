package br.fmu.projetoaula.model;

import java.time.Instant;

public class UserModel {

    private final String username;
    private String name;
    private String password;
    private String email;
    private final Instant signUpAt;
    private Instant lastLogin;

    public UserModel(String username, String name, String password, String email, Instant signUpAt, Instant lastLogin) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.email = email;
        this.signUpAt = signUpAt;
        this.lastLogin = lastLogin;
    }

    public String getUsername() {
        return username;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Instant getSignUpAt() {
        return signUpAt;
    }

    public Instant getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Instant lastLogin) {
        this.lastLogin = lastLogin;
    }
}
