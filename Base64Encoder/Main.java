package org.base64encoder;

import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

import java.util.Base64;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException, NoSuchElementException {

        Scanner scanner;
        String userInput;
        String base64EncodedUserInput;
        Clipboard clipboard;
        StringSelection stringSelection;

        System.out.println("\nBASE64 ENCODER");
        System.out.println("\nPlease enter the String you want to encode:");

        scanner = new Scanner(System.in);
        userInput = scanner.nextLine();

        base64EncodedUserInput = Base64.getEncoder().encodeToString(userInput.getBytes());
        System.out.println("\nYour Base64-encoded String:");
        System.out.println(base64EncodedUserInput);

        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        stringSelection = new StringSelection(base64EncodedUserInput);
        clipboard.setContents(stringSelection, null);
        System.out.println("\nYour encoded String has been copied to the Clipboard.");
        System.out.println("Please paste it somewhere now.");

        TimeUnit.SECONDS.sleep(5);
        System.out.println("\nFinished? Press Enter to clear the Clipboard and quit the program.");

        scanner.nextLine();
        scanner.close();

        stringSelection = new StringSelection("");
        clipboard.setContents(stringSelection, null);
    }
}