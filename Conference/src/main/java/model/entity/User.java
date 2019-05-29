package model.entity;

import lombok.Data;

import java.util.Objects;


public class User {
    private long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private Role role;

    public User() {
    }

    public enum Role{LISTENER,MODERATOR,ADMIN,SPEAKER}

    private User(Builder builder){
        this.id = builder.id;
        this.name = builder.name;
        this.surname = builder.surname;
        this.email = builder.email;
        this.password = builder.password;
        this.role = builder.role;
    }

    public static class Builder {
        private long id;
        private String name;
        private String surname;
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

        public Builder setSurname(String surname) {
            this.surname = surname;
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

        public User build() {
            return new User(this);
        }
    }

        public long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getSurname() {
            return surname;
        }

        public String getEmail() {
            return email;
        }

        public String getPassword() {
            return password;
        }

        public User.Role getRole() {
            return role;
        }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return getId() == user.getId() &&
                Objects.equals(getName(), user.getName()) &&
                Objects.equals(getSurname(), user.getSurname()) &&
                Objects.equals(getEmail(), user.getEmail()) &&
                Objects.equals(getPassword(), user.getPassword()) &&
                getRole() == user.getRole();
    }

    @Override
        public int hashCode() {
            return Objects.hash(getId(), getName(), getSurname(), getEmail(), getPassword(), getRole());
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", email='" + email + '\'' +
                    ", password='" + password + '\'' +
                    ", role=" + role +
                    '}';
        }
    }

