package activities;

import java.util.*;
import java.util.Scanner;

public class EmergencyRoomProgram {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        ArrayList<Patient> room = new ArrayList<>();

        int total = numPatients(console);

        room = patientDetails(total, console, room);

        Collections.sort(room);

        printPriority(room);

    }

    public static int numPatients(Scanner console) {
        System.out.print("How many patients? ");
        int n = console.nextInt();
        System.out.println();
        return n;
    }

    public static ArrayList<Patient> patientDetails(int total, Scanner console, ArrayList<Patient> room) {
        for (int i = 1; i <= total; i++){
            System.out.println("Details of patient " + i);
            System.out.print("First Name: ");
            String firstName = console.next();
            System.out.print("Pain level: ");
            int painLevel = console.nextInt();

            room.add(new Patient(firstName, painLevel));
            System.out.println();
        }
        return room;
    }

    public static void printPriority(ArrayList<Patient> room) {
        System.out.println("Visitors to the Emergency Room:");
        for (int i = 0; i < room.size(); i++) {
            System.out.print((i + 1) + ". ");
            System.out.println(room.get(i));
        }
    }


    private static class Patient implements Comparable {
        String firstName;
        int painLevel;

        public Patient(String firstName, int painLevel) {
            this.firstName = firstName;
            this.painLevel = painLevel;
        }

        public int getPainLevel() {
            return painLevel;
        }

        @Override
        public int compareTo(Object o) {
            int comparePain = ((Patient)o).getPainLevel();
            return comparePain - this.painLevel;
        }

        public String toString() {
            return firstName + " (Pain Level: " + painLevel + ")";
        }
    }
}
