package BusinessLogicLayer;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Bookings
 */

public class Events {
    
    public Events(){
        
    }

    public String EventType;
    public LocalDateTime EventDate;
    public String VenueName;
    public String VenueAddress;     //this will store venue address
    public String VenueContact;
    public int AdultCount;
    public int ChildCount;
    public List<String> FoodSelection;
    public List<String> Decorations;
    

    public String getEventType()
    {
        return EventType;
    };

    public void setEventType(String EventType)
    {
        this.EventType = EventType;
    };

    public LocalDateTime getEventDate()
    {
        return EventDate;
    };

    public void setEventDate(LocalDateTime EventDate)
    {
        this.EventDate = EventDate;
    };

    public String getVenueName()
    {
        return VenueName;
    };

    public void setVenueName(String VenueName)
    {
        this.VenueName = VenueName;
    };

    public String getVenueAddress()
    {
        return VenueAddress;
    };

    public void setVenueAddress(String VenueAddress)
    {
        this.VenueAddress = VenueAddress;
    };

    public String getVenueContact()
    {
        return VenueContact;
    };

    public void setVenueContact(String VenueContact)
    {
        this.VenueContact = VenueContact;
    };
    
    public int getAdultCount()
    {
        return AdultCount;
    };

    public void setAdultCount(int AdultCount)
    {
        this.AdultCount = AdultCount;
    };

    public int getChildCount()
    {
        return AdultCount;
    };

    public void setChildCount(int ChildCount)
    {
        this.ChildCount = ChildCount;
    };

    public List<String> getFood()
    {
        return FoodSelection;
    };

    public void setFood(List<String> Food)
    {
        this.FoodSelection = Food;
    };

    public List<String> getDecorations()
    {
        return Decorations;
    };

    public void setDecorations(List<String> deco)
    {
        this.Decorations = deco;
    };

    public Events(String event,LocalDateTime date,String VenueName,String VenueAddress,String VenueContact,int Adults,int Children,List<String> food,List<String> decorations)
    {
        this.EventType = event;
        this.EventDate = date;
        this.VenueName = VenueName;
        this.VenueAddress = VenueAddress;
        this.VenueContact = VenueContact;
        this.AdultCount = Adults;
        this.ChildCount = Children;
        this.FoodSelection = food;
        this.Decorations = decorations;
    };


}