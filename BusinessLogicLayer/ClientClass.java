
public class ClientClass {
    private string Cname;
    private string Csurname;
    private int Cnumber;

    public string getCname(){
        return Cname;
    }

    public string getCsurname(){
        return Csurname;
    }

    public int getCnumber(){
        return Cnumber;
    }
    public  Client(){
        
    }
    public Client(String Cname , String Csurname, int Cnumber)
	{
		this.Cname = Cname;
		this.Csurname = Csurname;
		this.Cnumber = Cnumber;
	}

}
