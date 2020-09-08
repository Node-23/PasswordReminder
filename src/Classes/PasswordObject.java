package Classes;

public class PasswordObject {
    private String local;
    private String password;
    private String username;

    public PasswordObject(String local,String username,String password) {
        this.local = local;
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLocal() {
        return this.local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return getLocal()+ " -----" + "\n"+ "UserName = "+ getUsername()+ "\n"+ "password = " + getPassword();
    }

}
