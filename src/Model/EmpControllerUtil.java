package Model;

import javax.servlet.http.HttpServletRequest;
import Model.Emp;

public class EmpControllerUtil {
	
    public static Emp GetInf(HttpServletRequest request) {
    	
    	String id = request.getParameter("id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String salary = request.getParameter("salary");

        Emp e = new Emp();
        e.setId(Integer.parseInt(id));
        e.setName(name);      
        e.setEmail(email);
        e.setPassword(password);
        e.setSalary(salary);
        return e;
    }

}
