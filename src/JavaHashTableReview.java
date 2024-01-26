/* What is a Hash Table? Data Structure (can think it is a little like an array)
    >Offers fast insertion and searching
    >They are limited in size because they are based on arrays
    >Can be resized, but it should be avoided - Because it’s a relatively expensive operation and should be done judiciously.
                                                The strategy for when and how to resize a hash table can greatly affect the
                                                performance of hash table operations.
    >They are hard to order

    How Hash Table and Hash Functions work together?
    >Key values are assigned to elements in a Hash table using hash function
    >a Hash function helps claculate the best index an item should go in
    >Index must be small enough for the arrays size
    >Don't overwrite other data in the hash table

    Hash Functions:
    >A hash function job is to store values in an array with a limited size
    >It does it in a way that the array doesn't need to be searched through to find it
    >Enter values in any order
    >Be able to find them using a calculation instead of searching through the array


    * */

import java.util.Arrays;
public class JavaHashTableReview {

    String[] theArray;
    int arraySize;
    int itemsInArray = 0;

    public static void main(String[] args) {

        JavaHashTableReview theFunc = new JavaHashTableReview(30); //this is a hashFunction Object
        String[] elementsToAdd = {"1","5","17","21","26"};
        theFunc.hashFunction1(elementsToAdd, theFunc.theArray);
        theFunc.displayTheStack();

    }

    public void hashFunction1(String[] stringsForArray, String[] theArray){

        for(int n=0; n< stringsForArray.length; n++){
            String newElementVal = stringsForArray[n];
            theArray[Integer.parseInt(newElementVal)] = newElementVal;
        }

    }

    JavaHashTableReview(int size){ //constructor for the hashfunction
        arraySize = size;
        theArray = new String[size];
        Arrays.fill(theArray, "-1");
    }

    public void displayTheStack() {
        int increment = 0;
        for (int m = 0; m < 3; m++) {
            increment += 10;

            for (int n = 0; n < 71; n++)
                System.out.print("-");

            System.out.println();

            for (int n = increment - 10; n < increment; n++) {
                System.out.format("| %3s " + " ", n);
            }

            System.out.println("|");

            for (int n = 0; n < 71; n++)
                System.out.print("-");

            System.out.println();

            for (int n = increment - 10; n < increment; n++) {
                if (theArray[n].equals("-1"))
                    System.out.print("|      ");
                else
                    System.out
                            .print(String.format("| %3s " + " ", theArray[n]));

            }

            System.out.println("|");

            for (int n = 0; n < 71; n++)
                System.out.print("-");

            System.out.println();

        }

    }

    }
