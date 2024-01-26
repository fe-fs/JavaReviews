/*What is Singleton Pattern?
>>It is used when you want to eliminate the option of instatiating more than one object


REVIEW: Demonstrate it using a class that holds all the potential Scrabble letters and spits out new one upon request
>>Each player will share the same potential letter list
>>Each player has their own set of letters


 */
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;


public class JavaSingletonDesignPatternReview {

        private static JavaSingletonDesignPatternReview firstInstance = null; //this is the only access point here

        //Hold all my scrabble letters in an array
        String[] scrabbleLetters = {
                "a", "a", "a", "a", "a", "a", "a", "a", "a",
                "b", "b",
                "c", "c",
                "d", "d", "d", "d",
                "e", "e", "e", "e", "e", "e", "e", "e", "e", "e", "e", "e",
                "f", "f",
                "g", "g", "g",
                "h", "h",
                "i", "i", "i", "i", "i", "i", "i", "i", "i",
                "j",
                "k",
                "l", "l", "l", "l",
                "m", "m",
                "n", "n", "n", "n", "n", "n",
                "o", "o", "o", "o", "o", "o", "o", "o",
                "p", "p",
                "q",
                "r", "r", "r", "r", "r", "r",
                "s", "s", "s", "s",
                "t", "t", "t", "t", "t", "t",
                "u", "u", "u", "u",
                "v", "v",
                "w", "w",
                "x",
                "y", "y",
                "z"
        };

        //get array of letters inside the linked list
        private LinkedList<String> letterList = new LinkedList<String>(Arrays.asList(scrabbleLetters));

        static boolean firstThread = true;

        private JavaSingletonDesignPatternReview(){}

        //get instance method is very used for singleton
    //make it synchronized - it is gonna force every threat to wait it's turn, so 1 threat will be able to
    //access this method at the time - BUT NOT GOOD TO USE BECAUSE SLOWS THINGS
        public static /*synchronized*/ JavaSingletonDesignPatternReview getInstance(){

            //the only way to come here and create a new singleton is if there is nothing created already
            if(firstInstance == null){

                if(firstThread){
                    firstThread = false;
                    Thread.currentThread();
                    try {
                        Thread.sleep(2000); //first thread sleeping
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                //BETTER WAY TO USE SYNCHRONIZED
                //it will going to force it to be a synchronized method until the first object is created
                //thereafter it will no longer be considered synchronized

                synchronized (JavaSingletonDesignPatternReview.class) {

                    //the only way to come here and create a new singleton is if there is nothing created already
                    if(firstInstance == null) {

                        firstInstance = new JavaSingletonDesignPatternReview(); //lazy intantiation -> if it is no needed it will never be used

                        //shuffle the letters to be more interesting the game (random)
                        Collections.shuffle(firstInstance.letterList);
                    }
                }
            }

            return firstInstance;
        }

        public LinkedList<String> getLetterList(){
            return firstInstance.letterList;
        }

        public LinkedList<String> getTiles(int howManyTiles){
            LinkedList<String>tilesToSend = new LinkedList<String>();

            for(int i=0; i<= howManyTiles; i++){
                tilesToSend.add(firstInstance.letterList.remove(0));

            }
            return tilesToSend;
        }

    }

    class ScrabbleTest{

        public static void main(String[] args){
            JavaSingletonDesignPatternReview newInstance = JavaSingletonDesignPatternReview.getInstance();

            //print a unique id for all our instances to help track if you are dealing with the same objs or new ones
            System.out.println("\nInstance 1 ID: " + System.identityHashCode(newInstance));

            System.out.println(newInstance.getLetterList());

            LinkedList<String> playerOneTiles = newInstance.getTiles(7);

            System.out.println("\nPlayer 1: " + playerOneTiles);

            //to see how it changed after give letter to player 1
            System.out.println("\nWhat is left in game: " + newInstance.getLetterList());

            JavaSingletonDesignPatternReview newInstanceTwo = JavaSingletonDesignPatternReview.getInstance();

            //print a unique id for all our instances to help track if you are dealing with the same objs or new ones
            System.out.println("\nInstance 2 ID: " + System.identityHashCode(newInstance));

            System.out.println(newInstance.getLetterList());

            LinkedList<String> playerTwoTiles = newInstance.getTiles(7);

            System.out.println("\nPlayer 2: " + playerTwoTiles);

            //to see how it changed after give letter to player 2
            System.out.println("\nWhat is left in game: " + newInstance.getLetterList());

        }
    }

    //implement the different players as threats
    //little review about threats
    class ScrabbleTestThreats{
        public static void main(String[] args){

            //create a new threat using the runnable interface
            Runnable getTiles = new GetTheTiles();
            Runnable getTilesAgain = new GetTheTiles();

            new Thread(getTiles).start();
            new Thread(getTilesAgain).start();


        }

    }

    class GetTheTiles implements Runnable{

    public void run(){
        JavaSingletonDesignPatternReview newInstance = JavaSingletonDesignPatternReview.getInstance();

        //print a unique id for all our instances to help track if you are dealing with the same objs or new ones
        System.out.println("\n----------Instance ID: \n" + System.identityHashCode(newInstance));

        System.out.println(newInstance.getLetterList());

        LinkedList<String> playerOneTiles = newInstance.getTiles(7);

        System.out.println("Player: " + playerOneTiles);
        System.out.println("GotTiles");

        //to see how it changed after give letter to player 1
        System.out.println("\nWhat is left in game: \n" + newInstance.getLetterList());

        //now you can test this using the threads...
    }
    }


