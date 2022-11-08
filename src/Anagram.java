import java.util.*;
//import text file libraries
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Anagram {

    //File writer variables set to null
    FileWriter fw = null;
    BufferedWriter bw = null;
    PrintWriter pw = null;

    static void isAnagram(String s1, String s2) {
        String copyOfs1 = s1;
        String copyOfs2 = s2;

        boolean status = true;

        if (copyOfs1.length() != copyOfs2.length()) {


            status = false;
        } else {
            
            //Sorting both s1Array and s2Array

            Arrays.sort(s1Array);

            Arrays.sort(s2Array);

            //Checking whether s1Array and s2Array are equal

            status = Arrays.equals(s1Array, s2Array);
        }

        //Output

        if (status) {
            System.out.println(s1 + " and " + s2 + " are anagrams");
        } else {
            System.out.println(s1 + " and " + s2 + " are not anagrams");
        }

    }


    public static void main(String[] args) {
        boolean validUsername = true;
        String regexForNumbers = "^[^<>',\"/;`%]*$";

        String username, word1, word2;
        Scanner s = new Scanner(System.in);

        while (validUsername) {

            System.out.print("Enter username:");
            username = s.nextLine();


            if (!username.matches("\\D+") || !username.matches(regexForNumbers)) {
                System.err.println("Invalid user name supplied (" + username + ")!.\n"
                        + "Numerical digits, Special Characters, or Spaces are not permitted! Try again...");
                validUsername = false;
            } else {
                System.out.print("Enter first word:");
                word1 = s.nextLine();

                if (!word1.matches("\\D+") || !word1.matches(regexForNumbers)) {
                    System.err.println("Invalid word supplied (" + word1 + ")!.\n"
                            + "Numerical digits, Special Characters, or Spaces are not permitted! Try again...");
                    validUsername = false;
                } else {

                    System.out.print("Enter second word:");
                    word2 = s.nextLine();

                    if (!word2.matches("\\D+") || !word2.matches(regexForNumbers)) {
                        System.err.println("Invalid word supplied (" + word2 + ")!.\n"
                                + "Numerical digits, Special Characters, or Spaces are not permitted! Try again...");
                        validUsername = false;
                    }

                    isAnagram(word1, word2);

                }

            }
        }
    }
}
