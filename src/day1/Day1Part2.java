package day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Day1Part2 {
    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<Integer> firstNumbers = new ArrayList<>();
        HashMap<Integer, Integer> secondNumbers = new HashMap<>();

        Scanner input = new Scanner(new File("/Users/ferrinkatz/IdeaProjects/AdventOfCode24/src/day1/day1.txt"));
        while (input.hasNext()) {
            String line = input.nextLine();
            String[] numbers = line.split(" +");
            firstNumbers.add(Integer.parseInt(numbers[0]));
            int secondNumber = Integer.parseInt(numbers[1]);

            if (!secondNumbers.containsKey(secondNumber)) {
                secondNumbers.put(secondNumber, 1);
            } else {
                secondNumbers.put(secondNumber, secondNumbers.get(secondNumber) + 1);
            }
        }

        int sumDiff = 0;
        for (int i = 0; i < firstNumbers.size(); i++) {
            int firstNumber = firstNumbers.get(i);

            if (secondNumbers.containsKey(firstNumber)) {
                sumDiff += secondNumbers.get(firstNumber) * firstNumber;
            }
        }

        System.out.printf("Part 2: %d%n", sumDiff);
    }
}
