// Sam Miller
// CSC 3380
// 3/3/2017
import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.Scanner;

public class arrayIncrementer {
    public static void main(String[] args) {
        try {
            ArrayList<Integer> input = new ArrayList<>();            // initializes the Array-List
            File inFile = new File(args[0]);                         // defines the file object
            Scanner in = new Scanner(inFile);                        // defines a scanner for the file
            while (in.hasNext()) {input.add(in.nextInt());}          // reads in the file into an Array-list
            in.close();                                              // closes the scanner
            for(int child:input){ if(child>=10||child<0){throw new InputMismatchException();}} // iterates through the arraylist and verifies that all inputs are valid.
            System.out.printf("Input  : %s \n", input.toString());    // Prints the original array
            findSuccessor(input, input.size() - 1);          // calls the findSuccessor method
            System.out.printf("Output : %s \n", input.toString());   // prints the successor of the original array
        } catch (FileNotFoundException e) {                          // caches if the file was not found
            e.printStackTrace();                                     // prints the stack trace
            System.out.printf("The file specified was not found \n");// Tells the user explicitly what happened
        } catch(InputMismatchException a){
          System.out.printf("The program cannot understand your input, please verify that the input is in the form of a space seperated list of integers 0-9 \n");
        }
    }
    private static void findSuccessor(ArrayList<Integer> a, int count) {
        try {
            if (a.size() == 1) {                                    // if the size of the array list is one
                if (a.get(0) == 9) {                                // if the only element is 9
                    a.set(0, 0);                                    // then set it to 0
                    a.add(0, 1);                                    // add 1 at position 0
                } else {a.set(0, a.get(0) + 1);}                    // if the only element is not 9 increment by 1
            }else if (a.size() - 1 == count) {                            // if the array list size -1 is equal to the count (first iteration possibility only)
                a.set(count, a.get(count) + 1);                     // then increment by one
                findSuccessorRec(a, count - 1);                     // call the recursive
            } else if (count > 0) {findSuccessorRec(a, count);}     // if the count is greater than 0 then call the recursive
        } catch (StackOverflowError e) {                            // catches a StackOverflow
            e.printStackTrace();                                    // prints the stacktrace
        }
    }
    private static void findSuccessorRec(ArrayList<Integer> a, int count) {
        try {
            if (a.get(count + 1) > 9) {                             // if the previous term is greater than 9
                a.set(count + 1, 0);                                // then set previous term to 0
                a.set(count, a.get(count) + 1);                     // increment current term by one
                if (count == 1) {                                   // if the count is equal to one
                    a.set(count - 1, 0);                            // set the next term to 0
                    a.add(0, 1);                                    // add 1 at index 0
                }
            }
            if (a.get(count) > 9) {                                 // if the current term is greater than 9
                a.set(count, 0);                                    // then set current term to 0
                a.set(count - 1, a.get(count - 1) + 1);             // set next term to be incremented by 1
                if (count == 1) {                                   // if the count is equal to one
                    a.set(count - 1, 0);                            // set the next term to 0
                    a.add(0, 1);                                    // add 1 at index 0
                }
            }
            findSuccessor(a, count - 1);                            // return control to base case
        } catch (StackOverflowError e) {
            e.printStackTrace();
        }
    }
}
