package payloads;

/*
{
"token": "077d7cacsdjf384ksd"
 */

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthResponsePayload {

    @JsonProperty
    private String token;

    public String getToken() {
        return token;
    }
}
