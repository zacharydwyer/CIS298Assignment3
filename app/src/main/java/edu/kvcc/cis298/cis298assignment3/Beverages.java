package edu.kvcc.cis298.cis298assignment3;

import java.util.ArrayList;
import java.util.List;

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

    // Get the Beverages list
    public static Beverages get() {
        if (sBeverages == null) {
            sBeverages = new Beverages();
        }
        return sBeverages;
    }

    // Private constructor to protect from being instantiated explicitly
    private Beverages() {
        mBeverages = new ArrayList<>();         // Create new list of beverages - this is the first time this singleton has been made
    }

}
