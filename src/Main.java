import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader reader1 = new BufferedReader(new FileReader("src/input1.txt"));
            BufferedReader reader2 = new BufferedReader(new FileReader("src/input2.txt"));
            BufferedWriter mergedWriter = new BufferedWriter(new FileWriter("src/merged.txt"));

            mergeFiles(reader1, reader2, mergedWriter);

            System.out.println("Merged successfully!");

            reader1.close();
            reader2.close();
            mergedWriter.close();

            findCommonIntegers();
        } catch (IOException e) {
            System.out.println("An error occurred during the file merging process: ");
        }
    }

    // Merge the numbers of the two input files, maintaining the original order of the integers,
    // and write the result to a new text file called "merged.txt".
    private static void mergeFiles(BufferedReader reader1, BufferedReader reader2, BufferedWriter writer) {
        try {
            String line;
            System.out.println("Integers from input1.txt:");
            while ((line = reader1.readLine()) != null) {
                int number = Integer.parseInt(line);
                writer.write(number + "\n");
                System.out.println(number);
            }

            System.out.println("Integers from input2.txt:");
            while ((line = reader2.readLine()) != null) {
                int number = Integer.parseInt(line);
                writer.write(number + "\n");
                System.out.println(number);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while merging files: ");
        }
    }

    // Identify the integers that are present in both input files
    // and write them to a new text file called "common.txt".
    private static void findCommonIntegers() {
        try {
            BufferedReader reader1 = new BufferedReader(new FileReader("src/input1.txt"));
            BufferedReader reader2 = new BufferedReader(new FileReader("src/input2.txt"));
            BufferedWriter commonWriter = new BufferedWriter(new FileWriter("src/common.txt"));

            Set<Integer> set = new HashSet<>();
            String line;

            while ((line = reader1.readLine()) != null) {
                int number = Integer.parseInt(line);
                set.add(number);
            }

            while ((line = reader2.readLine()) != null) {
                int number = Integer.parseInt(line);
                if (set.contains(number)) {
                    commonWriter.write(number + "\n");
                }
            }

            reader1.close();
            reader2.close();
            commonWriter.close();

            System.out.println("Common integers written to common.txt");
        } catch (IOException e) {
            System.out.println("An error occurred while finding common integers: ");
        }
    }
}
