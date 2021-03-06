 


  
public class Account
{
   private int  id;
   private int acNumber;   
   private String branch;   
   
   
   public Account()
   {
	   System.out.println("Account default constructor");
   }   
   
   public Account(int id,int num,String branchName)
   {
	   System.out.println("Account params constructor");
	    this.id = id;
	    this.acNumber = num;
	    this.branch=branchName;
   }
   public int getAcNumber() {
	 return acNumber;
}

public void setAcNumber(int acNumber) {
	this.acNumber = acNumber;
}

public String getBranch() {
	return branch;
}

public void setBranch(String branch) {
	this.branch = branch;
}
public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

  public String toString()
   {
      /*return "{id:" +id+
               ",acNumber:'" + acNumber + '\'' +               
               ", branch:'" + branch + '\'' +
               '}';*/
	  
	  return "{\"id\":" +id+
              ",\"acNumber\":" + acNumber  +               
              ",\"branch\":"+"\""+ branch + "\"" +
              "}";
   }
}
