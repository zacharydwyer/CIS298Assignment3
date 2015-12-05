package edu.kvcc.cis298.cis298assignment3;

import android.content.Context;

import java.io.InputStream;
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
    public Beverage getBeverageById(String id) {
        for (Beverage beverage : mBeverages) {
            if (beverage.getID() == id) {
                return beverage;
            }
        }
        return null;
    }

    private void getBeveragesFromCSVFile(Context context) {         // Needs context in order to access resources
        // Create input stream from csv file
        InputStream is = context.getResources().openRawResource(R.raw.BeverageList);

        // Create a scanner that can be used to look at this stream
        Scanner myScanner = new Scanner(is);

        // Set the delimiter
        myScanner.useDelimiter(",");

        // While the scanner has something to look at...
        while (myScanner.hasNext()) {

            // Get the tokens; split using comma
            String[] tokens = myScanner.nextLine().split(",");

            // Example: 12401,20/20 Red Grape,750 ml,74.23,False

            // Using the tokens we just got, divvy them up
            String id = tokens[0];
            String name = tokens[1];
            String pack = tokens[2];
            double price = Double.parseDouble(tokens[3]);
            boolean isActive = Boolean.parseBoolean(tokens[4]);

            // Use this information to create a new Beverage
            Beverage newBeverage = new Beverage();
            newBeverage.setID(id);
            newBeverage.setName(name);
            newBeverage.setPack(pack);
            newBeverage.setPrice(price);
            newBeverage.setIsActive(isActive);

            // Finally, add this beverage to the beverage list (NOT THE CSV FILE THOUGH)
            this.mBeverages.add(newBeverage);
        }
    }

    /* SINGLETON IMPLEMENTATION BELOW HERE */

    // Singleton instance of Beverages
    public static Beverages sBeverages;

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
