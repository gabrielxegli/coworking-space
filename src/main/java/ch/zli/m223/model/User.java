package ch.zli.m223.model;

public class User {
    private Long id;

    private String email;

    private String password;

    private String firstname;

    private String lastname;

    // private Role role;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /*
     * public Role getRole() {
     * return this.role;
     * }
     * 
     * public void setRole(Role role) {
     * this.role = role;
     * }
     */

}
