package BusinessLogicLayer;

import java.io.FileNotFoundException;
import java.util.List;

import DataAccesLayer.FileHandeler;

public class ClientClass {
    private String Cname;
    private String Csurname;
    private String Cnumber;

    public ClientClass() {
    }

    public ClientClass(String Cname, String Csurname, String Cnumber) {
        this.Cname = Cname;
        this.Csurname = Csurname;
        this.Cnumber = Cnumber;
    }

    public String getCname() {
        return this.Cname;
    }

    public void setCname(String Cname) {
        this.Cname = Cname;
    }

    public String getCsurname() {
        return this.Csurname;
    }

    public void setCsurname(String Csurname) {
        this.Csurname = Csurname;
    }

    public String getCnumber() {
        return this.Cnumber;
    }

    public void setCnumber(String Cnumber) {
        this.Cnumber = Cnumber;
    }

    public ClientClass Cname(String Cname) {
        setCname(Cname);
        return this;
    }

    public ClientClass Csurname(String Csurname) {
        setCsurname(Csurname);
        return this;
    }

    public ClientClass Cnumber(String Cnumber) {
        setCnumber(Cnumber);
        return this;
    }

    public List<ClientClass> ClientInfo() throws FileNotFoundException
	{
		FileHandeler clientnfo = new FileHandeler();
		
		List<ClientClass> clientlist = clientnfo.GetClients();
		
		if(!clientlist.isEmpty())
		{
			return clientlist;
		}
		else
		{
			return null;
		}
	}
}
