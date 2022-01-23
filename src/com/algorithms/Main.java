package com.algorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner readIn = new Scanner(new File("Strings.txt"));
        List<String> slops = new ArrayList<>();
        List<String> slaps = new ArrayList<>();
        List<String> slips = new ArrayList<>();

        readIn.next();
        while (readIn.hasNext()){
            String word = readIn.next();
            if(isSlip(word))
                slips.add("Yes");
            else
                slips.add("No");
            if(isSlap(word))
                slaps.add("Yes");
            else
                slaps.add("No");
            if(isSlop(word))
                slops.add("Yes");
            else
                slops.add("No");
        }

        System.out.println("Slips Output:");
        printOutput(slips);
        System.out.println("End of Output\n\n");
        System.out.println("Slaps Output:");
        printOutput(slaps);
        System.out.println("End of Output\n\n");
        System.out.println("Slops Output:");
        printOutput(slops);
        System.out.println("End of Output\n\n");

    }

    /**
     * @param list
     * Helper function to print out the lists of answers
     */

    private static void printOutput(List<String > list) {
        for (var answer:
                list) {
            System.out.println(answer);

        }
    }

    /**
     *
     * @param word
     * takes in a string that is read from the file.
     * @return
     * determines whether the string is a slop using recursion.
     *
     * Constraints:
     * •Starts with a slap
     * •Ends with a slip.
     */

    private static boolean isSlop(String word) {
        int counter = 1;

        while (counter < word.length()){
            if(isSlap(word.substring(0,counter + 1)))
                return isSlip(word.substring(counter + 1));
            else {
                counter++;
            }
        }
        return false;
    }

    /**
     *
     * @param word
     * takes in a string that is read from the file.
     * @return
     * determines whether the string is a slap using recursion.
     *
     * Constraints:
     * •Its first character is an 'A'
     * •If it is a two-character Slap then its second and last character is an 'H'
     * •If it is not a two-character Slap, then it is in one of these two forms:o'A'
     *      followed by 'B' followed by a Slap, followed by a 'C'o'A' followed by a Slip (see above) followed by a 'C'
     *  •Nothing else is a Slap
     *
     */

    private static boolean isSlap(String word) {
        if(word.length() < 2)
            return false;
        else if(word.length() == 2 && word.charAt(0) == 'A' && word.charAt(1) == 'H')
            return true;
        else if (word.equals("ABC"))
            return true;
        else if (word.charAt(0) == 'A' && word.charAt(1) == 'B' &&
                word.charAt(word.length() - 1) == 'C'){
            return isSlap(word.substring(2, word.length() - 1));
        }
        else return word.charAt(0) == 'A' && isSlip(word.substring(1, word.length() - 1)) &&
                    word.charAt(word.length() - 1) == 'C';
    }

    /**
     *
     * @param word
     * takes in a string that is read from the file.
     * @return
     * determines whether the string is a slip using recursion.
     *
     * Constraints:
     * Its first character is either a 'D' or an 'E'
     * •The first character is followed by a string of one or more 'F's
     * •The string of one or more 'F's is followed by either a Slip or a 'G'
     * •The Slip or 'G' that follows the F's ends the Slip. For example,
     *      DFFEFFFG is a Slip since it has a 'D' for its first character,
     *      followed by a string of two F's, and ended by the Slip 'EFFFG'
     * •Nothing else is a Slip
     */
    private static boolean isSlip(String word) {
        if(word.length() == 0)
            return false;
        else if(word.charAt(0) == 'G' && word.length() == 1){
            return true;
        }
        else if (word.charAt(0) == 'F' || word.charAt(0) == 'D' || word.charAt(0) == 'E' ){
            return isSlip(word.substring(1));
        }
        else{
            if(word.charAt(0) != 'F' || word.charAt(0) != 'D' || word.charAt(0) != 'E' ){
                return false;
            }
        }
        return isSlip(word.substring(1));
    }
}
