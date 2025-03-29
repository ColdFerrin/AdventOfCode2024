package day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3Part1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("/Users/ferrinkatz/IdeaProjects/AdventOfCode24/src/day3/day3.txt"));

        StringBuilder stringBuilder = new StringBuilder();

        while (scanner.hasNextLine()) {
            stringBuilder.append(scanner.nextLine());
        }

        String input = stringBuilder.toString();

        System.out.println(input);

        Matcher matcher = Pattern.compile("(\\d+)").matcher(input);
    }
}
