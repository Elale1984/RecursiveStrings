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

        while (readIn.hasNext()){
            String word = readIn.next();
            if(isSlop(word))
                slops.add("Yes");
            else
                slops.add("No");
            if(isSlap(word))
                slaps.add("Yes");
            else
                slaps.add("No");
            if(isSlip(word))
                slips.add("Yes");
            else
                slips.add("No");
        }

        System.out.println("Slops Output:");
        printOutput(slops);
        System.out.println("End of Output\n\n");
        System.out.println("Slaps Output:");
        printOutput(slaps);
        System.out.println("End of Output\n\n");
        System.out.println("Slips Output:");
        printOutput(slips);
        System.out.println("End of Output\n\n");

    }

    private static void printOutput(List<String> list) {
        for (String answer:
                list) {
            System.out.println(answer);
        }
    }

    private static boolean isSlop(String word) {
        boolean answer = false;
        return answer;
    }

    private static boolean isSlap(String word) {
        boolean answer = false;
        return answer;
    }

    private static boolean isSlip(String word) {
        boolean answer = false;
        return answer;

    }
}
