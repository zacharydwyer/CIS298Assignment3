package edu.kvcc.cis298.cis298assignment3;

// Data object. Represents a beverage.
public class Beverage {

    // Beverage properties
    private String mName;
    private int mID;
    private String mPack;
    private double mPrice;
    private boolean mIsActive;

    // ToString override
    @Override
    public String toString() {
        return mName;
    }

    // Getters and setters
    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getID() {
        return mID;
    }

    public void setID(int ID) {
        mID = ID;
    }

    public String getPack() {
        return mPack;
    }

    public void setPack(String pack) {
        mPack = pack;
    }

    public double getPrice() {
        return mPrice;
    }

    public void setPrice(double price) {
        mPrice = price;
    }

    public boolean isActive() {
        return mIsActive;
    }

    public void setIsActive(boolean isActive) {
        mIsActive = isActive;
    }
}
