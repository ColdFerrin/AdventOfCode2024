package day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day1Part1 {
    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<Integer> firstNumbers = new ArrayList<>();
        ArrayList<Integer> secondNumbers = new ArrayList<>();

        Scanner input = new Scanner(new File("/Users/ferrinkatz/IdeaProjects/AdventOfCode24/src/day1/day1.txt"));
        while (input.hasNext()) {
            String line = input.nextLine();
            String[] numbers = line.split(" +");
            firstNumbers.add(Integer.parseInt(numbers[0]));
            secondNumbers.add(Integer.parseInt(numbers[1]));
        }

        firstNumbers.sort(Integer::compareTo);
        secondNumbers.sort(Integer::compareTo);

        int sumDiff = 0;
        for (int i = 0; i < firstNumbers.size(); i++) {
            int firstNumber = firstNumbers.get(i);
            int secondNumber = secondNumbers.get(i);
            sumDiff += Math.abs(firstNumber - secondNumber);
        }

        System.out.printf("Part 1: %d%n", sumDiff);
    }
}
