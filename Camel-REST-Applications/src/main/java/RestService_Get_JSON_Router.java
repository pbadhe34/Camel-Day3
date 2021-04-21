

 
import org.apache.camel.ConsumerTemplate;
import org.apache.camel.Exchange;
import org.apache.camel.Expression;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.builder.ValueBuilder;
import org.apache.camel.builder.endpoint.EndpointRouteBuilder;
import org.apache.camel.model.RouteDefinition;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.model.rest.RestBindingMode;
import org.apache.camel.support.ExpressionAdapter;
import org.json.JSONObject;

import com.server.Http_Post_Processor;
import com.server.MyProcessor;
import com.server.ResponseProcessor;
import com.server.User;
import com.services.Customer1; 

//RouteBuilder EndpointRouteBuilder
public class RestService_Get_JSON_Router extends RouteBuilder {
//This connects to external rest service as with http get method and get the output data from the service
	
	ResponseProcessor responseprocessor = new ResponseProcessor();
	
    @Override
    public void configure() throws Exception {
    	
    	 getContext().setTracing(true);  
    	
    	    //Java DSL Code
			
			
			  from("stream:in?promptMessage='Enter the id value to get the output :'")
			  .setHeader(Exchange.HTTP_METHOD, constant("GET")) 
			  .process(new MyProcessor())
			  .to("http://localhost:8090/REST-Service-Customer/customers/")
			  .to("stream:out");
			 
			 
        
    	 //Equivalent java api code
       /*RouteDefinition rtd =   from("stream:in?promptMessage='Enter the id value to get the output :'");
        
       rtd.setHeader(Exchange.HTTP_METHOD, constant("GET"));       
       rtd.process(new MyProcessor());
       rtd.to("http://localhost:8090/REST-Service-Customer/customers/");
       rtd.to("stream:out");*/
    	 
    	    //DSL with RouteBuilder
			  
			/*
			 * from("direct:getData") .setHeader(Exchange.HTTP_METHOD, constant("GET"))
			 * .process(new MyProcessor())
			 * .to("http://localhost:8090/REST-Service-Customer/customers/")
			 * .process(responseprocessor).log("${body}");
			 */
    	
    	   //Process the response with Custom Processor
    	 
			/*
			 * from("direct:getData") .setHeader(Exchange.HTTP_METHOD, constant("GET"))
			 * .process(new MyProcessor())
			 * .to("http://localhost:8090/REST-Service-Customer/customers/") .process(new
			 * Processor() {
			 * 
			 * @Override public void process(Exchange exchange) throws Exception {
			 * System.out.println("The  response  in is "+exchange.getIn().getBody());
			 * System.out.println("The  response out is "+exchange.getOut().getBody());
			 * 
			 * //convert the output to string String myString =
			 * exchange.getIn().getBody(String.class);
			 * System.out.println("The  output response  is "+myString); } })
			 * .log("${body}");
			 */
    	 
    	 
    	// {id:2firstName:'Baba', lastName:'Vaishya', street:'M G Road', city:'Indore', state:'MP', zip:'3456', country:'Brazil'}
    	 
    	  
    	     //Parse json response and conditonal routing
    	    // $.store.book[?(@.price < 10)]   			 
    		 
    	    //DSL with EndpointRouteBuilder
				/*
				 * from("direct:getData").setHeader(Exchange.HTTP_METHOD, constant("GET"))
				 * .process(new MyProcessor()) //
				 * .to("http://localhost:8090/REST-Service-Customer/customers/")
				 * .to("http://localhost:8090/REST-Services/customers/")
				 * 
				 * .choice() .when().jsonpath("$.[?(@.id < 2)]") .to("stream:out")
				 * .when().jsonpath("$.[?(@.city =='Pune')]") .to("file:src/app")
				 * .when().jsonpath("$.[?(@.street =='Center street')]") .to("file:target/data")
				 * .otherwise() .to("file:target/test");
				 */
			 
  
    	       //Message Transformation to next EP
    	       //DSL with EndpointRouteBuilder   	 
    	 
    	  
			
			/*
			 * from("direct:getData").setHeader(Exchange.HTTP_METHOD, constant("GET"))
			 * .process(new MyProcessor())
			 * .to("http://localhost:8090/REST-Services/customers/")
			 * //.transform().constant("YES") //.transform().simple("${body}")
			 * .transform().jsonpath("$.firstName") .to("stream:out");
			 * 
			 */
    	 
    	 //Transformm with valueBuilder
    	 
			/*
			 * from("direct:getData").setHeader(Exchange.HTTP_METHOD, constant("GET"))
			 * .process(new MyProcessor())
			 * .to("http://localhost:8090/REST-Services/customers/") .transform(new
			 * ValueBuilder(new ExpressionAdapter(){
			 * 
			 * @Override public Object evaluate(Exchange exchange) { String s =
			 * exchange.getIn().getBody(String.class); String ns = s.replaceFirst("branch",
			 * "Location"); System.out.println("The string in ValueBuilder is "+s); return
			 * ns; } })).to("stream:out");
			 */
		   
    	 
    	 //conditional message transformation
    	 
			/*
			 * from("direct:getData").setHeader(Exchange.HTTP_METHOD, constant("GET"))
			 * .process(new MyProcessor())
			 * .to("http://localhost:8090/REST-Services/customers/") .choice()
			 * .when().jsonpath("$.[?(@.id < 2)]") .transform().jsonpath("$.firstName")
			 * .to("stream:out") .when().jsonpath("$.[?(@.city =='Pune')]")
			 * .transform(constant("Yes")) .to("stream:out")
			 * .when().jsonpath("$.[?(@.street =='Center street')]")
			 * .transform(constant("NO")) .to("stream:out") .otherwise()
			 * .transform(simple("${body}")) .to("stream:out")
			 * 
			 * .end();
			 */
		  
      
             System.out.println("\n\n");       
       
       
        
    	
    	  
 
       
       //Input Processor
       /*rtd.process(new Processor() {    			
		@Override
		public void process(Exchange exchange) throws Exception {		 		
 		
			 ///The Exchange out body part shoud not be modified to string by cvalling body.toString() here
			//System.out.println("The  process out is "+exchange.getOut().getBody());
			
            String data = (String) exchange.getIn().getBody();
			
			//System.out.println("The value read from stream is  "+data);	 		 

			exchange.getIn().setHeader(Exchange.HTTP_PATH,data)	;	
			 	
		}
	});*/
             
        //Output Processor
      /* rtd.to("http://localhost:8080/REST-Service/customers/").process(new Processor() {
		
		@Override
		public void process(Exchange exchange) throws Exception {
			System.out.println("The  response  in is "+exchange.getIn().getBody());	
			System.out.println("The  response out is "+exchange.getOut().getBody());			
			
			//convert the output to string
			String myString = exchange.getIn().getBody(String.class);
			System.out.println("The  output response  is "+myString);			
		}
	});*/      
          
        

    }
}
