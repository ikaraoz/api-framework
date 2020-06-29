package api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payloads.BookingPayLoad;

import static io.restassured.RestAssured.*;

public class BookingApi extends BaseApi {

    private static final String bookingUrl = baseUrl + "booking/";

    public static Response getBookings() {
        return given()
                .get(bookingUrl);
    }

    public static Response getBookingById(String bookingId, String mediaType) {
        return given()
                .header("Accept", mediaType)
                .get(bookingUrl + bookingId);
    }

    public static Response postBooking(BookingPayLoad bookingPayLoad) {

        return given()
                .contentType(ContentType.JSON)
                .body(bookingPayLoad)
                .when()
                .post(bookingUrl);
    }

    public static Response deleteBooking(String bookingId, String token) {
        return given()
                .header("Cookie", "token=" + token)
                .delete(bookingUrl + bookingId);
    }

}
