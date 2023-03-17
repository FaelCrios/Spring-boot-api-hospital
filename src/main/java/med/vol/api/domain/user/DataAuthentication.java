package med.vol.api.domain.user;

public class DataAuthentication {
    private String login;
    private String password;


    public DataAuthentication(){
    }

    public DataAuthentication(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
