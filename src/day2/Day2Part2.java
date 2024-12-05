package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Day2Part2 {
    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<String> lines = new ArrayList<>();

        Scanner input = new Scanner(new File("/Users/ferrinkatz/IdeaProjects/AdventOfCode24/src/day2/sample.txt"));
        while (input.hasNext()) {
            String line = input.nextLine();
            lines.add(line);
        }

        int safeCount = 0;

        for (String line : lines) {
            System.out.println(line);
            ArrayList<Integer> integers = Arrays.stream(line.split(" +")).map(String::trim).map(Integer::parseInt).collect(Collectors.toCollection(ArrayList::new));
            ArrayList<Integer> diffs = new ArrayList<>();

            for (int i = 0; i < integers.size() - 1; i++) {
                diffs.add(integers.get(i+1) - integers.get(i));
            }

            int lineErrors = 0;
            boolean isIncreasing = diffs.getFirst() > 0;

            for (int i = 0; i < diffs.size(); i++) {
                if (isIncreasing && (diffs.get(i) > 3 || diffs.get(i) < 1)){
                    lineErrors++;
                } else if (!isIncreasing && (diffs.get(i) > -1 || diffs.get(i) < -3)){
                    lineErrors++;
                }
            }

            if (lineErrors < 2){
                safeCount++;
            }

            System.out.printf("lineErrors: %d, safeCount: %d%n", lineErrors, safeCount);
        }

        System.out.println(safeCount);
    }
}
