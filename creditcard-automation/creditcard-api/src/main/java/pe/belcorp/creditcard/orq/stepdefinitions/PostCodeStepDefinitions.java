package pe.belcorp.creditcard.orq.stepdefinitions;


import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import net.thucydides.core.annotations.Steps;


public class PostCodeStepDefinitions {

    public static String firstname;
    public static String lastname;
    public static String Date1;
    public static String Date2;
    public static String totalprice;
    public static String depositpaid;
    public static String additionalneeds;


    @Steps
    PostCodeAPI postCodeAPI;

    @Dado("ingreso usuario y clave")
    public void ingreso_usuario_admin_y_clave_password123() {
        postCodeAPI.fetchLocationByPostCodeAndCountry();
    }

    @Entonces("valido token")
    public void validoToken() {
        postCodeAPI.fetchLocation();

    }

    @Dado("obtengo id")
    public void obtengoId() {
        postCodeAPI.ObtengoID();
    }

    @Entonces("valido numero de id")
    public void validoNumeroDeId() {
        postCodeAPI.ValidoID();
    }

    @Dado("obtengo Ping")
    public void obtengoPing() {
        postCodeAPI.ObtengoPing();
    }

    @Entonces("valido numero de Ping")
    public void validoNumeroDePing() {
        postCodeAPI.ValidoPing();
    }

    @Cuando("completo el campo firstname (.*)")
    public void completoElCampoNombreNOMBRE(String nombre) {
        this.firstname = nombre;

    }

    @Y("completo el campo Apellido (.*)")
    public void completoElCampoApellidoAPELLIDO(String apellido) {
        this.lastname = apellido;
    }

    @Y("completo el campo Precio (.*)")
    public void completoElCampoPrecioPRECIO(String precio) {
        this.totalprice = precio;
    }

    @Y("completo el campo Depósito (.*)")
    public void completoElCampoDepósitoDEPOSITOP(String Depositpaid) {
        this.depositpaid = Depositpaid;
    }

    @Y("completo el campo Fecha reserva (.*) fecha de pago (.*)")
    public void completoElCampoFechaReservaFECHARFechaDePagoFECHAP(String chekin, String checkout) {
        this.Date1 = chekin;
        this.Date2 = checkout;
    }

    @Y("completo el campo adicionales (.*)")
    public void completoElCampoAdicionalesADICIONALES(String Additionalneeds) {
        this.additionalneeds = Additionalneeds;
    }

    @Entonces("se envia solicitud")
    public void seEnviaSolicitud() {
        PostCodeAPI postCodeAPI1 = new PostCodeAPI();
        postCodeAPI1.ObtengoURl(this.firstname,
                this.lastname,
                this.totalprice,
                this.depositpaid,
                this.totalprice,
                this.depositpaid,
                this.additionalneeds);
    }
}





