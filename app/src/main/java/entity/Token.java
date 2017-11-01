package entity;

/**
 * Created by haganicolau on 15/10/17.
 */

public class Token {

    private String status;
    private String token;
    private String message;

    public Token(){

    }

    public Token(String token){
        this.token = token;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
