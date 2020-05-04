package stepDefinitions;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class BaseSteps {

    public String BaseURL;
    public String MakeApost;
    public String MakeACommnet;
    public String CreateAUser;
    public Headers headers;
    public Response response;


    public BaseSteps(){
        BaseURL = "https://jsonplaceholder.typicode.com";
        MakeApost = BaseURL + "Posts/";
        MakeACommnet = BaseURL + "comments/";
        CreateAUser = BaseURL + "users/";

    }
    public void setHeaders(Headers value){
        headers = null;
        headers = value;
    }
    public void setHeadersWithContentType(){
        Headers headers = new Headers(
                new Header("Content_Type", "application/json"));
        setHeaders(headers);

    }
    public Response getMethodCall(){
        response = RestAssured.given().log().all().relaxedHTTPSValidation().headers(headers).when().get(getURL()).
                then().log().all().extract().response();
        return response;
    }

    protected URL getURL() {

    }

   /* private URL getURL() {
        try {
            return new URL (endpointPath);

        }*/
    }
}
