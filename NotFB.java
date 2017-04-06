// Sam Miller
// 4/7/17
// Making LSUBook A terminal based social network
// Please don't sue me Mark Zuckerberg

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class NotFB {
    public static void main(String[] args){
        Scanner  kb= new Scanner(System.in);

        String menuChoice;

        do{
            System.out.println("Select an Option: \n\n 1. Login \n 2. Create Account \n 3. Exit \n\n Enter a number (1-3):");
            menuChoice=kb.next();
            switch (menuChoice) {
                case "1":
                    Login();
                    break;
                case "2":
                    Register();
                    break;
                case "3":
                    System.exit(0);
                    break;
                default :
                    System.out.println("Invalid Selection");
            }}while(!menuChoice.equals("3"));



    }
    static  void Login(){
        Scanner  kb= new Scanner(System.in);
        System.out.println("You can press CTRL + C at any time to exit");
        System.out.println("Enter User Name: ");
        String uIn =kb.next();

        System.out.println("Enter Password: ");
        String pIn = kb.next();

        if(verify(uIn,pIn)){
            System.out.println("Logged In!");
        }
        else{
            System.out.println("Invalid Username or Password");
        }
    }

    static boolean verify(String u, String p){

        return true;

    }

    static void Register(){
        Scanner kb= new Scanner(System.in);

        boolean valid89=false;
        do{
            System.out.println("Enter 89 number: ");
            int in89=  kb.nextInt();
            if(in89<=890000000||in89>=899999999||doesExist("num", String.valueOf(in89))){
                System.out.println("Invalid 89 number");
            }
            else{
                valid89=true;
            }}while(!valid89);

        boolean uValid =false;
        do {
            System.out.println("Enter Desired Username: ");
            String userIn = kb.next();
            if (userIn == null || doesExist("u", userIn)) {
                System.out.println("Invalid Username or Username is already in use.");
            }else{
                System.out.println("Username: "+userIn+" is valid!");
                uValid=true;
            }}while(!uValid);

        boolean pValid=false;
        do {
            System.out.println("Enter Desired password: ");
            String passIn = kb.next();
            if (passIn == null ) {
                System.out.println("Can not have a blank password.");
            }
            else{
                System.out.println("Enter Desired password again: ");
                String passIn2 = kb.next();
                if(passIn.contentEquals(passIn2)){
                    pValid=true;
                }
                else{
                    System.out.println("Passwords do not match");
                }
            }
        }while(!pValid);
        boolean nValid=false;
        do{
          System.out.println("Enter First Name: ");
          String fName = kb.next();
        }

        try(FileWriter fw = new FileWriter("outfilename", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.println(in89+" "+userIn+" "+passIn+" "+);

        } catch (IOException e) {
          System.out.println("Something done messed up the FileWriter");
        }

    }

    static boolean doesExist(String s, String in){
        if(s.contentEquals("num")){
            return true;
        }
        else if (s.contentEquals("u")){
            return true;
        }

        return false;
    }
}
