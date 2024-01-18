import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class JavaArrayReview {

    public static void main(String[] args) {
        int[] randomArray;
        int[] numberArray = new int[10];

        randomArray = new int[20]; //array with have 20 spaces
        randomArray[1] = 2; //assign space 1 from array to be value 2

        String[] stringArray = {"that", "is", "an", "array", "of words"}; //that array will forever have 5 elements with words as values

        //add values to the array using loop
        for (int i = 0; i < numberArray.length; i++) {
            numberArray[i] = i;

        }
        //to print dash lines
        int k = 1;
        while (k <= 41) {
            System.out.print('-');
            k++;
        }
        System.out.println("\nArray");
        System.out.println();


        //other way to add values to array
        //this is how a numberArray of 10 itens looks like

        for (int j = 0; j < numberArray.length; j++) {
            System.out.print("| " + j + " ");
        }
        System.out.println("|");

        //multidimensional array 10x10 looks like this
        String[][] multiArray = new String[10][10];

        for (int i = 0; i < multiArray.length; i++) {

            for (int j = 0; j < multiArray[i].length; j++) {
                multiArray[i][j] = i + " " + j;
            }
        }

        //to print dash lines
        k = 1;
        while (k <= 61) {
            System.out.print('-');
            k++;
        }
        System.out.println("\nMultidimensional Array - what is each index for i and j");
        System.out.println();


        //call the same loop to print box for multidimensional array 10x10 looks like this

        for (int i = 0; i < multiArray.length; i++) {

            for (int j = 0; j < multiArray[i].length; j++) {
                System.out.print("| " + multiArray[i][j] + " |");
            }

            System.out.println("|");

        }

        //to print dash lines
        k = 1;
        while (k <= 61) {
            System.out.print('-');
            k++;
        }
        System.out.println();
        System.out.println("enhanced For Loop to print array values");

        //enhanced For Loop to print array values
        //“for each int (integer) row in numberArray do: print each item value of the numberArray
        for (int row : numberArray) {
            System.out.print(row);
        }
        System.out.println("\n");

        //to print dash lines
        k = 1;
        while (k <= 61) {
            System.out.print('-');
            k++;
        }
        System.out.println();
        System.out.println("enhanced For Loop with multidimensional loop:");

        //understand that for(dataType[]multidimensional varForRow : oftheArrayName)
        for(String[] row: multiArray){
            //understand that for(dataType varForcolumn : oftheArrayName)
            for(String column : row){
                System.out.print("| " + column + " ");
            }
            System.out.println("|");
        }


        //to print dash lines
        k = 1;
        while (k <= 61) {
            System.out.print('-');
            k++;
        }
        System.out.println();
        System.out.println("Coping Arrays: ");
        System.out.println("Arrays.copyOf method");
        //Coping an Array 01 - method Arrays.copyOf( arrayName, howManyItemsFromIt)
        int[] numberCopy = Arrays.copyOf(numberArray, 5);
        for(int row: numberCopy){
            System.out.print(row+" ");
        }
        System.out.println("\n");

        System.out.println("Arrays.copyOfRange method from 3-6 value:");
//Coping an Array 02 - method Arrays.copyOfRange( arrayName, from, to)
        //note: int holds a single integer value, while int[] can hold multiple integer values
        int[] numberCopy2= Arrays.copyOfRange(numberArray,3,6);
        for(int row: numberCopy2){
            System.out.print(row+" ");
        }
        System.out.println("\n");
        System.out.println("Printing the entire array at once: Use Arrays.toString(arrayName) ");

        System.out.println(Arrays.toString(numberArray));

        //to print dash lines
        k = 1;
        while (k <= 61) {
            System.out.print('-');
            k++;
        }
        System.out.println();
        System.out.println("Fill all values of the array with the same value - use Arrays.fill(arrayName, value");

//fill all values of the array with the same value
        int[] moreNumbers = new int[100];
        Arrays.fill(moreNumbers, 2);
        System.out.println(Arrays.toString(moreNumbers));

        System.out.println("\n\n---------------");
        System.out.println("create a multidimensional array with random chars\n"+
                "you can’t use the enhanced for loop (for-each loop) in this way to fill the array with\n" +
                " different random characters. The reason is that the enhanced for loop doesn’t provide\n" +
                " access to the indices of the array, only the elements themselves.\n");

        // Create a multidimensional array
        char[][] boardGame = new char[10][10];

// Create a Random object
        Random rand = new Random();

// Create a temporary array to hold the current row
        char[] tempRow;

// Iterate over each row
        for(int i = 0; i < boardGame.length; i++) {
            tempRow = new char[boardGame[i].length];
            // Iterate over each cell in the row
            for(int j = 0; j < tempRow.length; j++) {
                // Generate a random character between 'a' and 'z'
                char randomChar = (char) ('a' + rand.nextInt(26));
                // Fill the cell with the random character
                tempRow[j] = randomChar;
            }
            boardGame[i] = tempRow;
        }

// Print the array
        for(char[] row : boardGame) {
            for(char column : row) {
                System.out.print("| " + column + " ");
            }
            System.out.println("|");
        }

        System.out.println("\n\n------------");
        System.out.println("Create an array with random numbers and sort it using Math.ramdom()");
        //create an array with random numbers and sort it
        int[] numsToSort = new int[10];
        for( int i=0;i<10;i++){
            numsToSort[i]=(int) (Math.random()*100);
        }
        Arrays.sort(numsToSort); //sort so the numbers appear in crescent order
        System.out.println(Arrays.toString(numsToSort));

        //using binarySearch to find an specific value if is there inside an array
        System.out.println("\n\n------------");
        System.out.println("Using binarySearch to find an specific value if is there inside an array - use Arrays.binarySearch()");
        System.out.println("looking for 5");
        int whereIs5 = Arrays.binarySearch(numberArray,5);
        System.out.println(whereIs5 + "\n");

        System.out.println("looking for 50 in the random sort array");
        int whereIs50 = Arrays.binarySearch(numsToSort,50);
        System.out.println(whereIs50);

    }
}

