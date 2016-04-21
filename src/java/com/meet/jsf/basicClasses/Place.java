package com.meet.jsf.basicClasses;

import com.meet.jsf.dbconnection.*;

import java.sql.SQLException;
import java.util.List;

public class Place 
{
    public int ID ;
    public String Name ;
    public String Description ;
    public String LocationX ;
    public String LocationY ;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getLocationX() {
        return LocationX;
    }

    public void setLocationX(String LocationX) {
        this.LocationX = LocationX;
    }

    public String getLocationY() {
        return LocationY;
    }

    public void setLocationY(String LocationY) {
        this.LocationY = LocationY;
    }
   
    public Place(int id, String name, String des, String locX, String locY)
        {
            this.ID = id;
            this.Name = name;
            this.Description = des;
            this.LocationX = locX;
            this.LocationY = locY;
        }
//     public Place(int placeID) throws SQLException
//        {
//            Place place = PlaceService.GetPlaceByID(placeID);
//            this.ID = place.ID;
//            this.Name = place.Name;
//            this.Description = place.Description;
//            this.LocationX = place.LocationX;
//            this.LocationY = place.LocationY;
//        }
     
    @Override
     public String toString()
     {
        return this.Name + " " + this.Description;
     }
     
     public static void main(String[] args) throws SQLException 
    {
        System.out.println("Start"); 
        //PlaceService.GetPlaceByID(2);
        //Place miejsce = new Place(4);
        //System.out.println(miejsce.toString());

        List<Place> lista = PlaceService.GetAllPlaces();
        
        for (Place place : lista) 
        {
            System.out.println(place.toString());
        }

//Place nowe = new Place(0,"Olkusz","okolice rynku","2","3");

//PlaceService.Save(nowe);

    }
}
