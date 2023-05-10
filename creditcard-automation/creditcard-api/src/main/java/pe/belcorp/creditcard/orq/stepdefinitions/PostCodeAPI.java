package pe.belcorp.creditcard.orq.stepdefinitions;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import net.serenitybdd.rest.SerenityRest;
import pe.belcorp.creditcard.orq.model.Booking;
import pe.belcorp.creditcard.orq.model.Bookingdates;
import pe.belcorp.creditcard.orq.steps.LocationResponse;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class PostCodeAPI {


    private static final Object TEMPLATE_REVPAYMENT = "https://restful-booker.herokuapp.com/booking";
    private String Nombre;

    public void fetchLocationByPostCodeAndCountry() {
        SerenityRest.given()
                .body(LocationResponse.Name)
                .contentType("application/json");
        SerenityRest.when().post("https://restful-booker.herokuapp.com/auth");
    }

    public void fetchLocation() {
        restAssuredThat(response -> response.statusCode(200));
        System.out.println("el Token es = " + SerenityRest.lastResponse().jsonPath().getString("token"));
    }

    public void ObtengoID() {
        SerenityRest.given()
                .contentType("application/json");
        SerenityRest.when().get("https://restful-booker.herokuapp.com/booking");
    }

    public void ValidoID() {
        restAssuredThat(response -> response.statusCode(200));
        System.out.println("el ID es = " + SerenityRest.lastResponse().jsonPath().getString("bookingid"));

    }

    public void ObtengoPing() {
        SerenityRest.when().get("https://restful-booker.herokuapp.com/ping");
    }

    public void ValidoPing() {
        RestAssured.registerParser("Created", Parser.JSON);
        //   Assert.assertTrue( response -> response.statusCode(200));
        System.out.println(SerenityRest.lastResponse().htmlPath().getString("Created"));
    }

    public void ObtengoURl(String firstname, String lastname, String totalprice, String depositpaid, String checkin, String checkout, String additionalneeds) {
        PostCodeStepDefinitions pos = new PostCodeStepDefinitions();
        Bookingdates bookingdates1 = Bookingdates.builder()
                .checkin(checkin)
                .checkout(checkout)
                .build();

        Booking booking = Booking.builder()
                .firstname(firstname)
                .lastname(lastname)
                .totalprice(Integer.valueOf(totalprice))
                .depositpaid(depositpaid)
                .bookingdates(bookingdates1)
                .additionalneeds(additionalneeds)
                .build();

        SerenityRest.given()
                .contentType("application/json")
                .body(booking);
        SerenityRest.when().post("https://restful-booker.herokuapp.com/booking");
    }


}




