package modelsPack;


import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class EmployerData_Pojo {
	@Getter @Setter
	private int id;
    private String email;
  
    private String firstName;
    
    private String lastName;
    
    private String name;
    
    private String job;

    public void UserData(String name, String job) {
        this.name = name;
        this.job = job;
    }
}
