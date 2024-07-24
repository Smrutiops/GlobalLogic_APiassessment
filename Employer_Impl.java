package implementation;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import modelsPack.EmployerData_Pojo;

public class Employer_Impl {
	
	  public static Response getEmpsGetRequest(RequestSpecification requestSpec) {
	        return requestSpec
	                .get("/Emps");
	    }

	    public static Response createEmpPostRequest(RequestSpecification requestSpec, EmployerData_Pojo emp) {
	        return requestSpec
	                .body(emp)
	                .post("/Emps");
	    }

	    public static Response getEmpsDelayedRequest(RequestSpecification requestSpec, int delayTime) {
	        return requestSpec
	                .pathParam("delay_time", delayTime)
	                .get("/delay/{delay_time}");
	    }

	    public static Response updateEmpPutRequest(RequestSpecification requestSpec, int empId, EmployerData_Pojo updatedEmp) {
	        return requestSpec
	                .pathParam("EmpId", empId)
	                .body(updatedEmp)
	                .put("/Emps/{EmpId}");
	    }

	    public static Response updateEmpPatchRequest(RequestSpecification requestSpec, int empId, EmployerData_Pojo partiallyUpdatedEmp) {
	        return requestSpec
	                .pathParam("EmpId", empId)
	                .body(partiallyUpdatedEmp)
	                .patch("/Emps/{EmpId}");
	    }

	    public static Response deleteEmpRequest(RequestSpecification requestSpec, int empId) {
	        return requestSpec
	                .pathParam("EmpId", empId)
	                .delete("/Emps/{EmpId}");
	    }
	    
}
