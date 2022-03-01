package io.muzoo.ssc.zork;

import java.util.Scanner;

public class Game {
    public void start() {
        System.out.println("Game started");
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String rawInput = scanner.nextLine();
            System.out.println(rawInput);

            if ("exit".equalsIgnoreCase(rawInput)) break;
        }
        scanner.close();
    }
}
