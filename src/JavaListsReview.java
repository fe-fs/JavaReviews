import java.util.ArrayList;
import java.util.Iterator;
import java.util.Arrays;
import java.util.Objects;

public class JavaListsReview {
    public static void main(String[] args) {
        System.out.println("\nReview of Collections class ArrayLists - Dynamic resizable Arrays");

        ArrayList arrayListOne;

        arrayListOne = new ArrayList();

        ArrayList arrayListTwo = new ArrayList();

        //to make it only accept Strings
        ArrayList<String> names = new ArrayList<String>();
        names.add("A B");
        names.add("C D");
        names.add("E F");
        names.add("G H");
        names.add("I J");
        names.add("K L");
        names.add("M N");
        names.add("O P");
        names.add("Q R");
        names.add("S T");

        names.add(2, "JACK");//will come to index to and the other one will be index 3

        System.out.println("Print all arrayList at once:");
        System.out.println(names);
        System.out.println("\n-----------------------------");

        System.out.println("Get only value of index 3");
        System.out.println(names.get(3));
        System.out.println("\n-----------------------------");

        System.out.println("Interact list with loop arrayListName.get(i) ");
        for(int i=0;i< names.size();i++){
            System.out.println(names.get(i));
        }
        System.out.println("\n-----------------------------");

        System.out.println("replace value of index using arrayListName.set()");
        names.set(0, "Hello World");
        System.out.println(names);

        System.out.println("\n-----------------------------");

        System.out.println("remove values using .remove(i)");
        names.remove(3);
        System.out.println(names);

        System.out.println("remove values 1-5 using subList(fromI, toI).clear()");
        names.subList(1, 5).clear();
        System.out.println(names);

        System.out.println("\n-----------------------------");

        System.out.println("Printing ArrayList with enhanced for loop:");
        for(String i:names){
            System.out.println(i);
        }

        System.out.println("\n-----------------------------");
        System.out.println("before it has the enhanced for loop it used the \ninteractor library and the interactor object\n");
        //create the obj
        Iterator indivItems = names.iterator();

        while(indivItems.hasNext()){ //this verifies if there is a next item from the arraylist
            System.out.println(indivItems.next()); //this prints the next from the list
        }

        System.out.println("\n-----------------------------");
        System.out.println("Copy from one ArrayList to a new one");

        //create new arraylist to store the copy
        ArrayList nameCopy = new ArrayList();
        nameCopy.addAll(names);

        //save a new name on this list
        System.out.println("Add Paul to names list");
        String save = "Paul";
        names.add(save);
        System.out.println(names + " \n\nprint copy of the array\n " + nameCopy);

        System.out.println("\n-----------------------------");
        System.out.println("Check if there is a specific name inside the list using .contains()");

        if(names.contains("Paul")){
            System.out.println("he is here");
        }
        System.out.println("\n-----------------------------");
        System.out.println("Check if all from one array is in other - using containAll()");

        if(names.containsAll(nameCopy)){
            System.out.println("all from nameCopy is in names");
        }

        if(nameCopy.containsAll(names)){ //this dont return because there is no Paul in nameCopy
            System.out.println("all from names is in nameCopy");
        }


        System.out.println("\n-----------------------------");
        System.out.println("clear names list and check if it is empty");

        names.clear();
        if (names.isEmpty()){
            System.out.println("names is empty");
        }

        System.out.println("\n-----------------------------");
        System.out.println("Send values from ArrayList to be stored into a generic datatype array: ");
//A generic object data type, often referred to as a “generic”, is a feature in programming languages
// that allows you to write classes, interfaces, or methods that can work with different types.


        Object[] moreNames = new Object[4];
        moreNames = nameCopy.toArray();

        System.out.println(Arrays.toString(moreNames));


    }
}
