package com.demo1.abovebelow;

import java.util.*;

public class stringRotation {

    static String leftrotate(String string0, int howMany) {

        String answer = string0.substring(howMany) + string0.substring(0, howMany);
        return answer;
    }

    static String rightrotate(String string0, int howMany) {
        return leftrotate(string0, string0.length() - howMany);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String string1;
        System.out.println("Enter string:\n");
        string1 = scanner.next();

        int howMany;
        System.out.println("Enter how many times:\n");
        howMany = scanner.nextInt();
        System.out.println(rightrotate(string1, howMany));
        scanner.close();
    }
}
