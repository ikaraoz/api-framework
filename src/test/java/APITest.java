import api.AuthApi;
import api.BookingApi;
import io.restassured.response.Response;
import org.junit.Test;
import payloads.AuthPayLoad;
import payloads.AuthResponsePayload;
import payloads.BookingDatesPayLoad;
import payloads.BookingPayLoad;

import java.util.Date;

import static api.BookingApi.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class APITest {
    @Test
    public void getBookingsReturns200() {
        //Response response = given().get("https://restful-booker.herokuapp.com/booking");
//        given()
//                .get("https://restful-booker.herokuapp.com/booking")
//                .then()
//                .statusCode(200);





//        Response response3= given()
//                .get("https://restful-booker.herokuapp.com/booking");
//        response3
//                .then()
//                .statusCode(200);
        Response response = getBookings();
        response.prettyPrint();
        assertThat(response.getStatusCode(), equalTo(200));
        //getBookings().then().statusCode(200); this is another alternative that we can use the response

    }

    @Test
    public void getBookingIdReturns200() {
//        Response response = given().get("https://restful-booker.herokuapp.com/booking/1");
        Response response = getBookingById("1", "application/json");
        assertThat(response.getStatusCode(), equalTo(200));
        response.prettyPrint();


    }

    /*
    The path can change in the future. For example, /bookings/ can be
    /reservations/ or something else. So,in order to prevent this happening, the
    base url can be abstracted, so that one can have easier control over the url and
    the endpoints.
     */
    @Test
    public void getBookingIdReturns418() {
        Response response = getBookingById("1", "application/json");
        assertThat(response.getStatusCode(), equalTo(418));
    }

    @Test
    public void postBookingReturns200() {
        BookingDatesPayLoad bookingDatesPayLoad = new BookingDatesPayLoad("2020/06/29", "2020/06/30");
        BookingPayLoad bookingPayLoad = new BookingPayLoad("Mark", "Tar"
                , 200, true, bookingDatesPayLoad, "Breakfast wanted");
/*
We defined the json body payload above.
Down, by using extract.path, we extracted the booking id only.
 */
        Response response = postBooking(bookingPayLoad);
        assertThat(response.getStatusCode(), equalTo(200)); //this is an intentional error made by designer.
        int bookingId = response.then().extract().path("bookingid");
        System.out.println("bookingId = " + bookingId);
    }


    @Test
    public void deleteBookingReturns201() {
//create a booking here, then extract the booking id, and
        //then check down if it is deleted.


        // log in and get token
        AuthPayLoad authPayLoad = new AuthPayLoad("admin", "password123");
        Response authResponse = AuthApi.postAuth(authPayLoad);
        // use token to delete booking

        String token = authResponse.as(AuthResponsePayload.class).getToken();
//        System.out.println("token = " + token);
/*
We opened another class AuthResponsePayload in order to extract the token.
 */
        Response bookingResponse = deleteBooking("1", token);
        assertThat(bookingResponse.getStatusCode(), equalTo(201));


    }




}
