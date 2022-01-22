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
//            if(isSlip(word))
//                slips.add("Yes");
//            else
//                slips.add("No");
        }

        System.out.println("Slips Output:");
        printOutput(slips);
        System.out.println("End of Output\n\n");
        System.out.println("Slaps Output:");
        printOutput(slaps);
        System.out.println("End of Output\n\n");
//        System.out.println("Slips Output:");
//        printOutput(slips);
//        System.out.println("End of Output\n\n");

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

//    private static boolean isSlop(String word) {
//
//    }

    private static boolean isSlap(String word) {
        if(word.length() == 0)
            return false;
        else if(word.length() == 2 && word.charAt(0) == 'A')
            return true;
        else if (word.charAt(0) == 'A' && word.length() > 2){
            if (isSlip(word.substring(1, word.length() - 2)) && word.charAt(word.length() - 1) == 'C'){
                return true;
            }
        }
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
