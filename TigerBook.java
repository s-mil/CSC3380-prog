// Sam Miller
// 4/7/17
// Making TigerBook A terminal based social network


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
class TigerBook {
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

    private static  void Login(){
        Scanner  kb= new Scanner(System.in);
        System.out.println("You can press CTRL + C at any time to exit");
        System.out.println("Enter User Name: ");
        String uIn =kb.next();

        System.out.println("Enter Password: ");
        String pIn = kb.next();

        if(verify(uIn,pIn)){

            System.out.println("Logged In!");
            loggedIn(uIn);
        }
        else{
            System.out.println("Invalid Username or Password");
        }
    }

    private static boolean verify(String u, String p){
        ArrayList<String> user=load("user");
        ArrayList<String> pass=load("pass");
        int index=-1;
        int count=0;
        boolean uv=false;
        boolean valid=false;
        assert user != null;
        for(String child:user){
                if(child.equals(u)){
                    index=count;
                    uv=true;
                }
                count++;
            }
            if(uv){
                assert pass != null;
                if(pass.get(index).equals(p))
                valid = true;
            }



        return valid;

    }

    private static void Register(){
        Scanner kb= new Scanner(System.in);
        int in89;
        String userIn, passIn,fName,lName;
        boolean valid89=false;
        do{
            System.out.println("Enter 89 number: ");
            in89=  kb.nextInt();
            if(in89<890000000||in89>899999999||doesExist("num", String.valueOf(in89))){
                System.out.println("Invalid 89 number or already in use by another user");
            }
            else{
                valid89=true;
            }}while(!valid89);

        boolean uValid =false;
        do {
            System.out.println("Enter Desired Username: ");
            userIn = kb.next();
            if (userIn == null || doesExist("u", userIn)) {
                System.out.println("Invalid Username or Username is already in use.");
            }else{
                System.out.println("Username: "+userIn+" is valid!");
                uValid=true;
            }}while(!uValid);

        boolean pValid=false;
        do {
            System.out.println("Enter Desired password: ");

            passIn = kb.next();
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

        boolean fNValid=false;
        do{
            System.out.println("Enter First Name: ");
            fName = kb.next();
            if(fName==null){
                System.out.println("Invalid Name input, can not be blank");
            }
            else{
                fNValid=true;
            }}while(!fNValid);

        boolean lNValid=false;
        do{
            System.out.println("Enter Last Name: ");
            lName = kb.next();
            if(lName==null){
                System.out.println("Invalid Name input, can not be blank");
            }
            else{
                lNValid=true;
            }}while(!lNValid);

        try(FileWriter fw = new FileWriter("userList.dat", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.println(in89+" "+userIn+" "+passIn+" "+fName+" "+lName+" " );

        } catch (IOException e) {
            System.out.println("Something done messed up the FileWriter");
        }

    }

    private static boolean doesExist(String s, String in) {

        ArrayList<String> userName = load("user");
        ArrayList<String> num89 = load("num89");
        boolean found = false;
        if (s.contentEquals("num")) {
            assert num89 != null;
            for(String child:num89){
                if(child.equals(in)){
                    found = true;
                }
            }
            return found;
        } else if (s.contentEquals("u")) {
            assert userName != null;
            for(String child:userName){
                if(child.equals(in)){
                    found = true;
                }
            }
            return found;
        }
        System.out.println("Possible edge case [doesExist]");
        return false;
    }

    private static ArrayList<String> load(String choice){
        File inFile = new File("userList.dat");
        Scanner in = null;
        ArrayList<String> send = new ArrayList<>();
        try {
            in = new Scanner(inFile);
        } catch (FileNotFoundException e) {
            System.out.println("Scanner for [load] failed!");
            e.printStackTrace();
        }

        switch (choice) {
            case "num89":
                assert in != null;
                while (in.hasNextLine()) {
                    String[] currentLine = in.nextLine().trim().split("\\s+");
                    send.add(currentLine[0]);
                }
                return send;
            case "user":
                assert in != null;
                while (in.hasNextLine()) {
                    String[] currentLine = in.nextLine().trim().split("\\s+");
                    send.add(currentLine[1]);
                }
                return send;
            case "pass":
                assert in != null;
                while (in.hasNextLine()) {
                    String[] currentLine = in.nextLine().trim().split("\\s+");
                    send.add(currentLine[2]);
                }
                return send;
            default:
                System.out.println("Load = Null");
                return null;
        }
    }

    private static void loggedIn(String user){
        Scanner  kb= new Scanner(System.in);
       //ensures files exist
        try {
            new FileOutputStream(user+"friendList.dat", true).close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            new FileOutputStream(user+"RequestList.dat", true).close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String menuChoice;
        do{
            System.out.println("Select an Option: \n\n 1. view and modify friends list \n 2. search for people and add friends \n 3. View friend requests \n 4. logout \n\n Enter a number (1-3):");
            menuChoice=kb.next();
            switch (menuChoice) {
                case "1":
                    friendsList(user);
                    break;
                case "2":
                    search();
                    break;
                case"3":
                    requests(user);
                    break;
                case "4":
                    break;
                default :
                    System.out.println("Invalid Selection");
            }}while(!menuChoice.equals("4"));
    }

    private static void friendsList(String userName) {
        ArrayList<String> friendsList = loadFriends(userName);

        int index = 0;
        for (String child : friendsList) {
            System.out.println(index + " " + child);
            index++;
        }

        String menuChoice;
        Scanner kb = new Scanner(System.in);
        do {
            System.out.println("Select an Option\n\n:1. Go Back\n2.Remove a Friend\n\n");
            menuChoice = kb.next();
            switch (menuChoice) {
                case "1":
                    break;
                case "2":
                    rmFriend(friendsList);
                    break;
                default:
                    System.out.println("Invalid Selection");
            }
        } while (!menuChoice.equals("1"));
    }

    private static void rmFriend(ArrayList<String> fList) {
        String menuChoice;
        Scanner kb = new Scanner(System.in);
        do{
            System.out.println("Select an Option\n\n:1. Go Back\n2.Remove a Friend\n\n");
            menuChoice = kb.next();
            switch (menuChoice) {
                case "1":
                    break;
                case "2":
                    System.out.println(" Enter the number next to the friend you wold like to remove:");
                    int rm = kb.nextInt();
                    System.out.println("Are you sure you wish to remove "+ fList.get(rm)+ " (y/n)");
                   String choice = kb.next();
                    if(choice.toLowerCase().equals("y")){
                        fList.remove(rm);
                        System.out.println("Friend Removed");
                        int index=0;
                        for(String child: fList){
                            System.out.println(index+" "+child);
                        }
                        try(FileWriter fw = new FileWriter("userList.dat", true);
                            BufferedWriter bw = new BufferedWriter(fw);
                            PrintWriter out = new PrintWriter(bw))
                        {
                            for(String child: fList)
                            out.println(child);

                        } catch (IOException e) {
                            System.out.println("Something done messed up the FileWriter");
                        }
                    }
                    else
                        System.out.println("Not removed");
                    break;
                default:
                    System.out.println("Invalid Selection");
            }
        } while (!menuChoice.equals("1"));

        }

    private static void requests(String userName) {
        String menuChoice;
        Scanner kb = new Scanner(System.in);
        ArrayList<String> requestList = loadFriends(userName);
        ArrayList<String> fList = loadRequests(userName);


        int index=0;
        for (String child : requestList) {
            System.out.println(index + " " + child);
           index++;
        }

        do {

            System.out.println("Select an Option\n\n:1. Go Back\n2.Accept a Friend Request\n\n");
            menuChoice = kb.next();
            switch (menuChoice) {
                case "1":
                    break;
                case "2":
                    System.out.println(" Enter the number next to the friend you wold like to Accept:");
                    int rm = kb.nextInt();
                    System.out.println("Are you sure you wish to add " + requestList.get(rm) + " (y/n)");
                    String choice = kb.next();
                    if (choice.toLowerCase().equals("y")) {

                        System.out.println("Friend added");
                        fList.add(requestList.get(rm));
                        requestList.remove(rm);
                        try (FileWriter fw = new FileWriter(userName+"friendList.dat");
                             BufferedWriter bw = new BufferedWriter(fw);
                             PrintWriter out = new PrintWriter(bw)) {
                            for (String child : fList)
                                out.println(child);
                        } catch (IOException e) {
                            System.out.println("Something done messed up the FileWriter");
                        }
                        try (FileWriter fw = new FileWriter(userName+"RequestList.dat");
                             BufferedWriter bw = new BufferedWriter(fw);
                             PrintWriter out = new PrintWriter(bw)) {
                            for (String child : fList)
                                out.println(child);
                        } catch (IOException e) {
                            System.out.println("Something done messed up the FileWriter");
                        }

                    }
                    else
                        System.out.println("Friend not added");
                    break;
                default:
                    System.out.println("Invalid Selection");
            }
        } while (!menuChoice.equals("1"));
    }

    private static void search(){

    }

    private static ArrayList<String> loadFriends(String userName){
        ArrayList<String> fL = new ArrayList<>();
        try {
            FileReader fr = new FileReader(userName + "FriendList.dat");
            Scanner fileIn = new Scanner(fr);
            while (fileIn.hasNext()) {
                fL.add(fileIn.nextLine());
            }
            return  fL;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return fL;
    }

    private static ArrayList<String> loadRequests(String userName){
        ArrayList<String> rL = new ArrayList<>();
        try {
            FileReader fr = new FileReader(userName + "RequestList.dat");
            Scanner fileIn = new Scanner(fr);
            while (fileIn.hasNext()) {
                rL.add(fileIn.nextLine());
            }
            return  rL;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return rL;
    }


}
