package com.project.milos.myrestaurant;

import android.graphics.Bitmap;
import android.location.Address;

import java.net.URL;
import java.util.List;

/**
 * Created by Miloš on 1/6/2017.
 */

public class Restaurant {
    private int id;
    private String name;
    private String description;
    private Bitmap smallPhoto;
    private Bitmap largePhoto;
    private Address address;
    private int startHour;
    private int startMinute;
    private int endHour;
    private int endMinute;
    private String phone;
    private String email;
    private URL site;
    private List<Meal> meals;
}
