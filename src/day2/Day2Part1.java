package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.lang.Math.abs;

public class Day2Part1 {
    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<String> lines = new ArrayList<>();

        Scanner input = new Scanner(new File("/Users/ferrinkatz/IdeaProjects/AdventOfCode24/src/day2/day2.txt"));
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

            int max = Collections.max(diffs);
            int min = Collections.min(diffs);

            if (diffs.getFirst() > 0 && max <= 3 && min >= 1) {
                safeCount++;
            } else if (diffs.getFirst() < 0 && max <= -1 && min >= -3) {
                safeCount++;
            }

            System.out.printf("max: %d, min: %d, safeCount: %d%n", max, min, safeCount);
        }

        System.out.println(safeCount);
    }
}
