package automationFramework;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.api.tests.Emp;

import implementation.Employer_Impl;
import io.cucumber.java.Before;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import modelsPack.EmployerData_Pojo;

public class Employer_Test {

	private RequestSpecification requestSpec;

    @Before
    public void setup() {
        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://httpbin.org/")
                .setContentType(ContentType.JSON)
                .build();
    }

    @Test
    public void testGetEmps() {
        Response response = Employer_Impl.getEmpsGetRequest(requestSpec);
        response.then()
                .statusCode(200);
    }

//    Send /post request with Json body and validate response contains relevant data : - Question requirement is not clear.
//    The link given for referring to the question doesn't indicate any information for the response data or the 
//    parameters to be passed as part of headers.
    
    @Test
    public void testCreateEmp() {
    	EmployerData_Pojo Emp = EmployerData_Pojo.builder()
                .name("Boss")
                .email("Boss@example.com")
                .age(30)
                .build();

        Response response = Employer_Impl.createEmpPostRequest(requestSpec, Emp);
        response.then()
                .statusCode(201)
                .body("name", is(Emp.getName()))
                .body("email", is(Emp.getEmail()))
                .body("age", is(Emp.getAge()));
    }


    @Test
    public void testGetEmpsDelayed() {
        int delayTime = 2;
        Response response = Employer_Impl.getEmpsDelayedRequest(requestSpec, delayTime);
        response.then()
                .statusCode(200)
                .time(Matchers.is(Matchers.greaterThan(delayTime * 1000L)));
    }

    
    

    @Test
    public void testDeleteEmp() {
        int EmpId = 1;
        Response response = Employer_Impl.deleteEmpRequest(requestSpec, EmpId);
        response.then()
                .statusCode(204);
    }

    @Test
    public void testUnauthorizedAccess() {
        requestSpec.header("Authorization", "Bearer invalid_token");
        Response response = Employer_Impl.getEmpsGetRequest(requestSpec);
        response.then()
                .statusCode(401);
    }
}


