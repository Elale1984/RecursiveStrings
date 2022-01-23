package com.algorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner readIn = new Scanner(new File("Strings.txt"));
        List<Boolean> slops = new ArrayList<>();
        List<Boolean> slaps = new ArrayList<>();
        List<Boolean> slips = new ArrayList<>();

        while (readIn.hasNext()){
            String word = readIn.next();
            if(isSlip(word))
                slips.add(true);
            else
                slips.add(false);
            if(isSlap(word))
                slaps.add(true);
            else
                slaps.add(false);
            if(isSlop(word))
                slops.add(true);
            else
                slops.add(false);
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

    private static void printOutput(List<Boolean> list) {
        for (var answer:
                list) {
            if(answer)
                System.out.println("Yes");
            else
                System.out.println("No");

        }
    }

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

    private static boolean isSlap(String word) {
        if(word.length() < 2)
            return false;
        else if(word.length() == 2 && word.charAt(0) == 'A' && word.charAt(1) == 'H')
            return true;
        else if (word.equals("ABC"))
            return true;
        else if (word.charAt(0) == 'A' && word.charAt(1) == 'B' && word.charAt(word.length() - 1) == 'C'){
            return isSlap(word.substring(2, word.length() - 1));
        }
        else return word.charAt(0) == 'A' && isSlip(word.substring(1, word.length() - 1)) && word.charAt(word.length() - 1) == 'C';
    }

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
