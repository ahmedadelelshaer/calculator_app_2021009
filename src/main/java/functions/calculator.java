package functions;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ejb.calcculationFunction;

@Stateless
@Path("/func")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class calculator {
    @EJB
    calcculationFunction x;
    ArrayList<calcculationFunction> nums = new ArrayList<calcculationFunction>();
     @POST
     @Path("/calc")
        
        public float calculateOperation(calcculationFunction request) {
            
    	 int num1 = request.number1;
         int num2 = request.number2;
         String operation = request.operation;

         float result = 0;

         switch (operation) {
             case "+":
                 result = num1 + num2;
                 break;
             case "-":
                 result = num1 - num2;
                 break;
             case "*":
                 result = num1 * num2;
                 break;
             case "/":
                 result = (float) num1 / num2;
                 break;
             
         }
         nums.add(request);
         return result;
         }
     
            

            
        
     @GET
        @Path("/calculations")
        public Response getAllCalculations() {
            return Response.ok().entity(nums).build();
        }
    

}