package BusinessLogicLayer;

public class ClientClass {
    private String Cname;
    private String Csurname;
    private int Cnumber;

    public String getCname(){
        return Cname;
    }

    public String getCsurname(){
        return Csurname;
    }

    public int getCnumber(){
        return Cnumber;
    }
    public  ClientClass(){
        
    }
    public ClientClass(String Cname , String Csurname, int Cnumber)
	{
		this.Cname = Cname;
		this.Csurname = Csurname;
		this.Cnumber = Cnumber;
	}

}
