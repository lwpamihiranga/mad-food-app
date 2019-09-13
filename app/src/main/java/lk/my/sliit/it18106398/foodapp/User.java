package lk.my.sliit.it18106398.foodapp;

public class User {
    private String username;
    private String email;
    private String phone;
    private String password;
    private String type;

    public User() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String usernname) {
        this.username = usernname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
