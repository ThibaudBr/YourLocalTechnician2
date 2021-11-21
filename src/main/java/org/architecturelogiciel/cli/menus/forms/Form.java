package org.architecturelogiciel.cli.menus.forms;

import java.util.Scanner;
import java.util.regex.Pattern;

public abstract class Form {

    private static final Scanner SCANNER = new Scanner(System.in);

    protected Form() {
    }

    protected String stringField(String display) {
        String str = "";
        while (str.isBlank()) {
            System.out.println(display);
            str = SCANNER.nextLine();
        }
        return str;
    }

    protected String passwordField(String display) {
        String str = "";
        while (str.isBlank() && str.length() < 4) {
            System.out.println(display);
            str = SCANNER.nextLine();
        }
        return str;
    }

    protected int numberField(String display, int min, int max) {
        SCANNER.next();
        int number = -1;
        SCANNER.next();
        while(number < min || number > max) {
            System.out.println(display + "(between " + min + " and " + max + ")");
            while (!SCANNER.hasNextInt()) {
                System.out.println(display + "(between " + min + " and " + max + ")");
                SCANNER.next();
            }
            number = SCANNER.nextInt();
        }
        SCANNER.next();
        return number;
    }

    protected String emailField(String display) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";
        Pattern pat = Pattern.compile(emailRegex);
        String str = "";
        while (str.isBlank() || !pat.matcher(str).matches()) {
            System.out.println(display);
            str = SCANNER.nextLine();
        }
        return str;
    }

}
