package activities;
import java.io.*;

public class AlgoProgram {

    public static void main(String[] args) throws FileNotFoundException {
        PrintStream output = new PrintStream(new File("scandal.txt"));

        Person[] gladiators = {
                new Person(35, "Olivia", "Pope"),
                new Person(33, "Abby", "Whelan"),
                new Person(34, "Diego", "Munoz"),
                new Person(28, "Quinn", "Perkins"),
                new Person(29, "Harrison", "Wright"),
                new Person(55, "Cyrus", "Beane")
        };

        quickSort(gladiators);

        for (Person p : gladiators) {
            output.print(p.years2Retire + " (years to retirement) - ");
            output.println(p.firstName + " " + p.lastName + " [" + p.age + "]");
        }
    }

    private static int partition(Person[] list, int low, int high) {
        Person pivot = list[high];
        int pivotIndex = low - 1;

        for (int i = low; i < high; i++) {
            if (list[i].years2Retire < pivot.years2Retire) {
                pivotIndex++;
                swap(list, pivotIndex, i);
            }
        }
        swap(list, pivotIndex + 1, high);

        return pivotIndex + 1;
    }

    public static void quickSort(Person[] list) {
        quickSort(list, 0, list.length - 1);
    }

    private static void quickSort(Person[] list, int low, int high) {
        if (low < high) {
            int pivotPoint = partition(list, low, high);

            quickSort(list, low, pivotPoint - 1);

            quickSort(list, pivotPoint + 1, high);
        }
    }

    public static void swap(Person[] list, int a, int b) {
        Person temp = list[a];
        list[a] = list[b];
        list[b] = temp;
    }



    private static class Person {
        int years2Retire;
        int age;
        String firstName;
        String lastName;

        public Person(int age, String firstName, String lastName) {
            this.age = age;
            this.firstName = firstName;
            this.lastName = lastName;
            years2Retire = 65 - age;
        }
    }
}
