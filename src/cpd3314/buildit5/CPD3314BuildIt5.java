/*
 * Copyright 2015 Mark Russell <mark.russell@lambtoncollege.ca>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cpd3314.buildit5;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Mark Russell <mark.russell@lambtoncollege.ca>
 */
public class CPD3314BuildIt5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Initialize Input Variables
        Scanner kb = new Scanner(System.in);
        int choice = 0;

        // Begin Loop for Main Menu
        do {
            // Output Sample Descriptions
            String[] samples = {
                "void outputRecord() { ... }",
                "void mashup(String a, String b) { ... }",
                "double sphereArea(double r) { ... }",
                "double cylinderArea(double r, double h) { ... }"
            };
            int i = 1;
            System.out.println("====================");
            for (String sample : samples) {
                System.out.println(i++ + ". " + sample);
            }

            // Perform Input and Validation
            do {
                try {
                    System.out.println("Which sample would you like to run (0 to quit)?");
                    choice = kb.nextInt();
                } catch (InputMismatchException ex) {
                    System.out.println("That is not a valid choice.");
                }
            } while (choice < 0 || choice > samples.length);

            // Switch Off to Subroutines
            switch (choice) {
                case 1:
                    outputRecord();
                    break;
                case 2:
                    doExercise2();
                    break;
                case 3:
                    doExercise3();
                    break;
                case 4:
                    doExercise4();
                    break;
                case 0:
                    System.out.println("Goodbye.");
                    break;
                default:
                    System.out.println("That is not a valid choice.");
                    break;
            }
        } while (choice != 0);
    }

    /**
     * Outputs a single static student record.
     */
    public static void outputRecord() {
        System.out.println("First Name:\tMark");
        System.out.println("Last Name:\tRussell");
        System.out.println("College:\tLambton College");
    }

    /**
     * Outputs two strings in an ABAB mashup pattern.
     *
     * @param a - The first input string.
     * @param b - The second input string.
     */
    public static void mashup(String a, String b) {
        System.out.println(a + b + a + b);
    }

    /**
     * A wrapper that runs the method called "mashup" with user input.
     */
    public static void doExercise2() {
        Scanner kb = new Scanner(System.in);
        System.out.print("Enter some text: ");
        String str1 = kb.nextLine();
        System.out.print("Enter some more text: ");
        String str2 = kb.nextLine();
        mashup(str1, str2);
    }

    /**
     * Calculates the surface area of a sphere based on the radius.
     *
     * @param r - The radius of the sphere.
     * @return - The surface area of the sphere.
     */
    public static double sphereArea(double r) {
        return 4 * Math.PI * r * r;
    }

    /**
     * A wrapper that runs the method called "sphereArea" with user input.
     */
    public static void doExercise3() {
        Scanner kb = new Scanner(System.in);
        System.out.print("Enter the radius of the sphere: ");
        double r = kb.nextDouble();
        System.out.println("Surface Area is: " + sphereArea(r));
    }

    /**
     * Calculates the surface area of a cylinder based on the radius and height.
     *
     * @param r - The radius of the cylinder.
     * @param h - The height of the cylinder.
     * @return - The surface area of the cylinder.
     */
    public static double cylinderArea(double r, double h) {
        double endArea = Math.PI * r * r;
        double wallArea = 2 * r * Math.PI;
        return wallArea + 2 * endArea;
    }

    /**
     * A wrapper that runs the method called "cylinderArea" with user input.
     */
    public static void doExercise4() {
        Scanner kb = new Scanner(System.in);
        System.out.print("Enter the radius of the cylinder: ");
        double r = kb.nextDouble();
        System.out.print("Enter the height of the cylinder: ");
        double h = kb.nextDouble();
        System.out.println("Surface Area is: " + cylinderArea(r, h));
    }
}
