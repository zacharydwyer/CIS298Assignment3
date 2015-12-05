package edu.kvcc.cis298.cis298assignment3;

import android.content.Context;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Singleton class representing the main collection of Beverages.
public class Beverages {

    // Private backing field for List property
    private List<Beverage> mBeverages;

    // How to access the list itself
    public List<Beverage> getBeverages() {
        return mBeverages;
    }

    // Get a Beverage by using its ID
    public Beverage getBeverageById(int id) {
        for (Beverage beverage : mBeverages) {
            if (beverage.getID() == id) {
                return beverage;
            }
        }
        return null;
    }

    /* SINGLETON IMPLEMENTATION BELOW HERE */

    // Singleton instance of Beverages
    public static Beverages sBeverages;

    private static void loadBeveragesFromCSV(Context context) {
        // Create input stream from csv file
        InputStream is = context.getResources().openRawResource(R.raw.BeverageList);

        // Create a scanner that can be used to look at this stream
        Scanner myScanner = new Scanner(is);

        // Set the delimiter
        myScanner.useDelimiter(",");

        // While the scanner has something to look at...
        while (myScanner.hasNext()) {
            String[] tokens = myScanner.nextLine().split(",");

            // Example: 12401,20/20 Red Grape,750 ml,74.23,False

            // Using the tokens we just got, divvy them up


        }
    }

    // Get the Beverages list
    public static Beverages get(Context context) {
        if (sBeverages == null) {
            sBeverages = new Beverages(context);
        }
        return sBeverages;
    }

    // Private constructor to protect from being instantiated explicitly
    private Beverages(Context context) {
        mBeverages = new ArrayList<>();         // Create new list of beverages - this is the first time this singleton has been made
    }

}
