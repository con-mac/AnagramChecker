import java.io.*;
import java.util.*;
//import text file libraries


public class Anagram {

    static ArrayList<String> ar = new ArrayList<String>();

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
            //Changing the case of characters of both copyOfs1 and copyOfs2 and converting them to char array

            char[] s1Array = copyOfs1.toLowerCase().toCharArray();

            char[] s2Array = copyOfs2.toLowerCase().toCharArray();

            //Sorting both s1Array and s2Array

            Arrays.sort(s1Array);

            Arrays.sort(s2Array);

            //Checking whether s1Array and s2Array are equal

            status = Arrays.equals(s1Array, s2Array);
        }

        //Output

        if (status) {
            System.out.println("\n" + s1 + " and " + s2 + " are anagrams");
        } else {
            System.out.println(s1 + " and " + s2 + " are not anagrams");
        }

    }


    public static void main(String[] args) throws IOException {
        boolean validUsername = true;
        String regexForNumbers = "^[^<>',\"/;`%]*$";

        String username, word1, word2;
        Scanner s = new Scanner(System.in);


//        try (FileReader f = new FileReader("C:\\Users\\conor\\OneDrive\\Ulster University\\Graduate Prep\\CME\\AnagramChecker\\src\\Anagrams.txt")) {
//            StringBuffer sb = new StringBuffer();
//            while (f.ready()) {
//                char c = (char) f.read();
//                if (c == '\n') {
//                    ar.add(sb.toString());
//                    sb = new StringBuffer();
//                } else {
//                    sb.append(c);
//                }
//            }
//            if (sb.length() > 0) {
//                ar.add(sb.toString());
//            }
//        }


//        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\conor\\OneDrive\\Ulster University\\Graduate Prep\\CME\\AnagramChecker\\src\\Anagrams.txt"))) {
//            while (br.ready()) {
//                ar.add(br.readLine());
//            }
//        }


        while (validUsername) {

            System.out.print("Enter username:");
            username = s.nextLine();

            ar.add(username);

            Set<String> store = new HashSet<>();

            for (String name : ar) {
                if (!store.add(name)) {
                    System.err.println("found a duplicate username in system, : "
                            + name + " please try again...");

                }
            }


            if (!username.matches("\\D+") || !username.matches(regexForNumbers)) {
                System.err.println("Invalid user name supplied (" + username + ")!.\n"
                        + "Numerical digits, Special Characters, or Spaces are not permitted! Try again...");
                validUsername = false;
            } else {

                System.out.print("Enter first word:");
                word1 = s.nextLine();

                ar.add(word1);

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


                    System.out.print("Enter second word:");
                    word2 = s.nextLine();

                    ar.add(word2);

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

                    isAnagram(word1, word2);


                    System.out.println("\nUser " + username + "'s Anagram:\n" + word1 + "\n" + word2);


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
