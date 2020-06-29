package payloads;

//"bookingdates": {
//        "checkin": "2018-01-01",
//        "checkout": "2019-01-01"
//        }

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class BookingDatesPayLoad {

    @JsonProperty
    private String checkin;
    @JsonProperty
    private String checkout;

    public BookingDatesPayLoad(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }
}
