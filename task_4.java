// Ввод: 2? + ?5 = 69
// Вывод: 24 + 45 = 69

import java.util.Scanner;

public class Task_04 {
    static boolean isRightEquation(String q, String w, String e) {
        int a = Integer.parseInt(q);
        int b = Integer.parseInt(w);
        int c = Integer.parseInt(e);
        if (a + b == c) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.printf("Enter equition as (q + w = e): ");
        String equation = scn.nextLine();
        equation = equation.replace(" ", "");
        String[] numbersArray = equation.split("[+=]");
        boolean isCorrectInput = true;

        for (String element : numbersArray) {
            element = element.replace("?", "0");
            int number = Integer.parseInt(element);
            if (number < 0) {
                isCorrectInput = false;
                break;
            }           
        }

        if (!isCorrectInput || numbersArray.length != 3) {
            System.out.println("You enter wrong equation!!!");
        } else {
            boolean isSolution = false;
            for (int x = 0; x < 10; x++) {
                String[] tempArray = numbersArray.clone();
                for (int i = 0; i < 3; i++) {
                    String c = Integer.toString(x);
                    tempArray[i] = tempArray[i].replace("?", c);
                }

                if (isRightEquation(tempArray[0], tempArray[1], tempArray[2])) {
                    System.out.printf("%s + %s = %s", tempArray[0], tempArray[1], tempArray[2]);
                    isSolution = true;
                    break;
                }                
            }
            if (! isSolution) {
               System.out.println("Solution of equation is absent!!!"); 
            } 
        }
        scn.close();
    }
}