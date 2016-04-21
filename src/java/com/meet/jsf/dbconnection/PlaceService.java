/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meet.jsf.dbconnection;

import com.meet.jsf.basicClasses.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlaceService {

    public static List<Place> GetAllPlaces() throws SQLException {
        String query = "CALL `GetAllPlaces`();";
        List<Place> placesList = new ArrayList<Place>();

        try (DbConnection db = new DbConnection()) {
            ResultSet rs = db.executeQuery(query);

            while (rs.next()) {
                placesList.add(new Place(rs.getInt("ID"), rs.getString("Name"), rs.getString("Description"), rs.getString("LocationX"), rs.getString("LocationY")));
            }
        }

        return placesList;
    }

    public static Place GetPlaceByID(int id) throws SQLException {

        String query = "CALL `GetPlaceById`(" + id + ");";
        Place place = null;

        try (DbConnection db = new DbConnection()) {
            ResultSet rs = db.executeQuery(query);

            while (rs.next()) {
                place = new Place(rs.getInt("ID"), rs.getString("Name"), rs.getString("Description"), rs.getString("LocationX"), rs.getString("LocationY"));
            }
        }

        return place;
    }

    public static void Save(Place place) throws SQLException {
        String query = "CALL `SavePlace`('" + place.getDescription() + "','" + place.getLocationX() + "','" + place.getLocationY() + "','" + place.getName() + "');";

        try (DbConnection db = new DbConnection()) {
            ResultSet rs = db.executeQuery(query);
        }
    }

}
