package com.services; 

 

 
public class Customer1
{
   private String id;
  

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}


private String firstName;  

 

private String lastName;
   private String street;
   private String city;
   private String state;
   private String zip;
   private String country;

    
   /*public Customer(@JsonProperty("id") String  id,
		   @JsonProperty("firstName") String firstName,
		   @JsonProperty("lastName") String  lastName ,		   
		   @JsonProperty("street") String  street ,		   
		   @JsonProperty("city") String  city ,
		   @JsonProperty("state") String  state, 
		   @JsonProperty("zip") String  zip ,
		   @JsonProperty("country") String  country)
		{
	   System.out.println("Customer.json Customer()"); 
        this.id = id;
        this.firstName = firstName;
        this.lastName= lastName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
   } 
   */
   public Customer1()
   {
	  // System.out.println("Customer_default_Customer()");
   }
      
   public String getFirstName()
   {
      return firstName;
   }

   public void setFirstName(String firstName)
   {
      this.firstName = firstName;
   }

    
   public String getLastName()
   {
      return lastName;
   }

   public void setLastName(String lastName)
   {
      this.lastName = lastName;
   }

    
   public String getStreet()
   {
      return street;
   }

   public void setStreet(String street)
   {
      this.street = street;
   }

    
   public String getCity()
   {
      return city;
   }

   public void setCity(String city)
   {
      this.city = city;
   }

   
   public String getState()
   {
      return state;
   }

   public void setState(String state)
   {
      this.state = state;
   }

    
   public String getZip()
   {
      return zip;
   }

   public void setZip(String zip)
   {
      this.zip = zip;
   }

    
   public String getCountry()
   {
      return country;
   }

   public void setCountry(String country)
   {
      this.country = country;
   }

    
   public String toString()
   {
      return "{id:" +id+
               ",firstName:'" + firstName + '\'' +
              ", lastName:'" + lastName + '\'' +
              ", street:'" + street + '\'' +
              ", city:'" + city + '\'' +
              ", state:'" + state + '\'' +
              ", zip:'" + zip + '\'' +
              ", country:'" + country + '\'' +
              '}';
   }
}
