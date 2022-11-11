import java.io.*;
import java.util.*;
//import text file libraries


public class Anagram {

    static ArrayList<String> ar = new ArrayList<String>();


    //File writer variables set to null
    FileWriter fw = null;
    BufferedWriter bw = null;
    PrintWriter pw = null;


//Function to check words for anagram match
    static void isAnagram(String s1, String s2) {

        //Create copies to use for comparison
        String copy1 = s1;
        String copy2 = s2;



        //Set boolean for comparison break
        boolean status = true;

        if (copy1.length() != copy2.length()) {


            status = false;
        } else {
            //Allow for Capital letters by changing the case of characters of both copy1 and copy2 and converting them to char array

            char[] s1Array = copy1.toLowerCase().toCharArray();

            char[] s2Array = copy2.toLowerCase().toCharArray();

            //Sorting both s1Array and s2Array
            Arrays.sort(s1Array);

            Arrays.sort(s2Array);

            //Checking whether s1Array and s2Array are equal
            status = Arrays.equals(s1Array, s2Array);
        }

        //Output string

        if (status) {
            System.out.println("\n" + s1 + " and " + s2 + " are anagrams");
        } else {
            System.out.println(s1 + " and " + s2 + " are not anagrams");
        }

    }

//Main method
    public static void main(String[] args) throws IOException {


        //One of a number of methods used to try and read in text file and add to array list for comparison. Would appreciate feedback on solution
//        try (Scanner s = new Scanner(new FileReader("C:\\Users\\conor\\OneDrive\\Ulster University\\Graduate Prep\\CME\\AnagramChecker\\src\\Anagrams.txt"))) {
//            while (s.hasNext()) {
//                ar.add(s.nextLine());
//            }
//        }

        //Initiate boolean
        boolean validUsername = true;

        //Validate against special characters
        String regexForNumbers = "^[^<>',\"/;`%]*$";

        //pass in user input
        String username, word1, word2;
        Scanner s = new Scanner(System.in);


        //While loop for user input break
        while (validUsername) {

            System.out.print("Enter username:");
            username = s.nextLine();

            //add username to array list cache to check for previous entries
            ar.add(username);

            //HashSet for Cache validation on username
            Set<String> store = new HashSet<>();

            for (String name : ar) {
                if (!store.add(name)) {
                    System.err.println("found a duplicate username in system, : "
                            + name + " please try again...");

                }
            }

            //Validate correct input (letters only, no spaces) using regex
            if (!username.matches("\\D+") || !username.matches(regexForNumbers)) {
                System.err.println("Invalid user name supplied (" + username + ")!.\n"
                        + "Numerical digits, Special Characters, or Spaces are not permitted! Try again...");
                validUsername = false;
            } else {


                //First word input
                System.out.print("Enter first word:");
                word1 = s.nextLine();

                //add first word to array list cache to check for previous entries
                ar.add(word1);

                //Validate entry
                Set<String> store2 = new HashSet<>();

                for (String name : ar) {
                    if (!store2.add(name)) {
                        System.err.println("found a duplicate word found in cache, : "
                                + word1 + " please try again...");
                        validUsername = false;
                    }
                }

                if (!word1.matches("\\D+") || !word1.matches(regexForNumbers)) {
                    System.err.println("Invalid word supplied (" + word1 + ")!.\n"
                            + "Numerical digits, Special Characters, or Spaces are not permitted! Try again...");
                    validUsername = false;
                } else {


                    //Second word input
                    System.out.print("Enter second word:");
                    word2 = s.nextLine();

                    //Add to cache
                    ar.add(word2);

                    //Validate
                    Set<String> store3 = new HashSet<>();

                    for (String name : ar) {
                        if (!store3.add(name)) {
                            System.err.println("found a duplicate word found in cache, : "
                                    + word2 + " please try again...");
                            validUsername = false;
                        }
                    }

                    if (!word2.matches("\\D+") || !word2.matches(regexForNumbers)) {
                        System.err.println("Invalid word supplied (" + word2 + ")!.\n"
                                + "Numerical digits, Special Characters, or Spaces are not permitted! Try again...");
                        validUsername = false;
                    }

                    //Call anagram method and compare
                    isAnagram(word1, word2);


                    //Print anagram output
                    System.out.println("\nUser " + username + "'s Anagram:\n" + word1 + "\n" + word2);


                    //Append username and anagram to text file
                    try (FileWriter f = new FileWriter("C:\\Users\\conor\\OneDrive\\Ulster University\\Graduate Prep\\CME\\AnagramChecker\\src\\Anagrams.txt", true);
                         BufferedWriter b = new BufferedWriter(f);
                         PrintWriter p = new PrintWriter(b);) {

                        p.println("\n\n" + username + ":");
                        p.println(word1);
                        p.println(word2);
                        p.println("\n");


                    } catch (IOException i) {
                        i.printStackTrace();
                    }



                }

            }
        }
    }
}
