package sample;

public class Person {
    protected String username;
    protected String password;
    protected String lastOpened;

    public Person() {
        this.username = "";
        this.password = "";
        this.lastOpened = "";
    }

    public Person(String username, String password) {
        this.username = username;
        this.password = password;
        this.lastOpened = "";
    }

    public Person(String username, String password, String lastOpened) {
        this.username = username;
        this.password = password;
        this.lastOpened = lastOpened;
    }

    public void setLastOpened(String name) {
        this.lastOpened = name;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getLastOpened() {
        return this.lastOpened;
    }
}
