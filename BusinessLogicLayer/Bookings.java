package BusinessLogicLayer;

import java.sql.Date;
import java.util.*;
import java.time.*;

/**
 * Bookings
 */
public class Bookings {

    public String Event;
    public LocalDate EventDate;
    public String[][] EventVenue = new String[1][2];
    public int[][] PeopleCount = new int[1][2];
    public String[][] Food = new String[1][4];


    public Bookings(String event,LocalDate date,String[][]venue,int[][] people,String[][] food)
    {
        event = this.Event;
        date = this.EventDate;
        venue = this.EventVenue;
        people = this.PeopleCount;
        food = this.Food;
    };


}