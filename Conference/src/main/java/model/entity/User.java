package model.entity;

import lombok.Data;

@Data
public class User {
    private long id;
    private String name;
    private String sureName;
    private String email;
    private String password;
    private Role role;
    public enum Role{USER,MODERATOR,ADMIN,SPEEKER}

    private User(Builder builder){
        this.id = builder.id;
        this.name = builder.name;
        this.sureName = builder.sureName;
        this.email = builder.email;
        this.password = builder.password;
        this.role = builder.role;
    }

    public static class Builder{
        private long id;
        private String name;
        private String sureName;
        private String email;
        private String password;
        private User.Role role;

        public Builder setId(long id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setSureName(String sureName) {
            this.sureName = sureName;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setRole(User.Role role) {
            this.role = role;
            return this;
        }

        public User build(){
            return new User(this);
        }

        public enum Role{USER,MODERATOR,ADMIN,SPEEKER}



    }
}
