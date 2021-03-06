package BusinessLogicLayer;

public class ClientClass {
    private String Cname;
    private String Csurname;
    private String Cnumber;

    public String getCname(){
        return Cname;
    }

    public String getCsurname(){
        return Csurname;
    }

    public String getCnumber(){
        return Cnumber;
    }
    public  ClientClass(){
        
    }
    public ClientClass(String Cname , String Csurname, String Cnumber)
	{
		this.Cname = Cname;
		this.Csurname = Csurname;
		this.Cnumber = Cnumber;
	}

}
