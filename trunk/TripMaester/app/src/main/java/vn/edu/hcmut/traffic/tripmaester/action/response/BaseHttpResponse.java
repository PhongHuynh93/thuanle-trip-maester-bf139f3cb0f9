package vn.edu.hcmut.traffic.tripmaester.action.response;

/**
 * Created by thuanle on 12/18/15.
 */
public class BaseHttpResponse {
    private String description;
    private int code;

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
