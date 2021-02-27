package BusinessLogicLayer;

import java.sql.Date;
import java.util.*;
import java.time.*;

/**
 * Bookings
 */
public class Bookings {

    public String EventType;
    public LocalDate EventDate;
    public String[][] EventVenue = new String[1][2];
    public int[][] PeopleCount = new int[1][2];
    public String[][] Food = new String[1][4];

    public String getEventType()
    {
        return EventType;
    }

    public void setEventType(String EventType)
    {
        this.EventType = EventType;
    }

    public LocalDate getEventDate()
    {
        return EventDate;
    }

    public void setEventDate(LocalDate EventDate)
    {
        this.EventDate = EventDate;
    }

    public String[][] getEventVenue()
    {
        return EventVenue;
    }

    public void setEventVenue(String[][] EventVenue)
    {
        this.EventVenue = EventVenue;
    }

    public int[][] getPeopleCount()
    {
        return PeopleCount;
    }

    public void setPeopleCount(int[][] PeopleCount)
    {
        this.PeopleCount = PeopleCount;
    }

    public String[][] getFood()
    {
        return Food;
    }

    public void setFood(String[][] Food)
    {
        this.Food = Food;
    }

    

}