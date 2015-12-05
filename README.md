# Assignment 3 - Master Detail Wine List with Fragments

## Author
Zachary Dwyer


## Description

-----This is not finished yet-----

Create a master detail application to view the contents of a beverage list.
The master part will display a list of all of the beverage items in the list.
The Detail part will display the details of a specific beverage item.
The User should be able to go up and down items in the list by swiping left or right on a detail page.
The App should look like the screen shots I have provided.
There is no need to save any information changed in the application to the CSV file.

The properties of the CSV file are as follows:
1. Item Number
2. Item Description
3. Item Pack Size
4. Case Price
5. Currently Active Item

Solution Requirements:

* Portrat Master layout
* Landscape Master layout
* Portrait Detail layout
* Landscape Detail layout
* Fragments for all of the layouts
* Class to represent a Beverage Item
* ArrayList for the list of Beverage Items
* ListView to display the master view
* Read in CSV file and create ArrayList of Beverage Items from the data in the CSV file
* Use View Pager to swipe left and right on detail page to go up and down in the list
* Should look like the screen shots provided
* Remember Documentation, and README

![Application Master Portrait Layout](http://barnesbrothers.homeserver.com/cis298/assignmentImages/assignment3a.jpg "Application Master Portrait Layout")
![Application Master Landscape Layout](http://barnesbrothers.homeserver.com/cis298/assignmentImages/assignment3b.jpg "Application Master Landscape Layout")
![Application Detail Portrait Layout](http://barnesbrothers.homeserver.com/cis298/assignmentImages/assignment3c.jpg "Application Detail Portrait Layout")
![Application Detail Landscape Layout](http://barnesbrothers.homeserver.com/cis298/assignmentImages/assignment3d.jpg "Application Detail Landscape Layout")

### Notes

The book does not cover how to read in a CSV file, however, it should be fairly easy to find on the internet. If more help is needed, we can do something in class.

## Outside Resources Used
* Defining shadows on elements [http://developer.android.com/training/material/shadows-clipping.html]
* Double formatting [http://stackoverflow.com/questions/12806278/double-decimal-formatting-in-java]
* Double currency formatting [http://stackoverflow.com/questions/2379221/java-currency-number-format]
* Looking at the callstack while debugging [http://stackoverflow.com/questions/21071960/android-studio-where-can-i-see-callstack-while-debugging-an-android-app]
* Working with setError on an EditText [http://stackoverflow.com/questions/11640772/edittext-seterror-message-does-not-clear-after-input]
* using "getResources()" [http://stackoverflow.com/questions/8238588/how-to-call-getresources-from-a-class-which-has-no-context]
* Parsing CSV file [http://stackoverflow.com/questions/5360628/get-and-parse-csv-file-in-android]
* Scanner vs BufferedReader [http://stackoverflow.com/questions/2231369/scanner-vs-bufferedreader]
* Using Scanner 1 [http://stackoverflow.com/questions/11871520/how-can-i-read-input-from-the-console-using-the-scanner-class-in-java]
* Using Scanner 2 [http://www.javabeat.net/parsing-input-using-scanner/]
* Using Scanner 3 [http://stackoverflow.com/questions/14214206/splitting-up-data-file-in-java-scanner]

## Known Problems, Issues, And/Or Errors in the Program
* On rotate, error appears in detail view

