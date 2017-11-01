package entity;

/**
 * Created by haganicolau on 15/10/17.
 */

public class Message {

    private String status;
    private String version_api;
    private String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getVersion_api() {
        return version_api;
    }

    public void setVersion_api(String version_api) {
        this.version_api = version_api;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
