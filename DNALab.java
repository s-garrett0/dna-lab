import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * DNALab - PROVIDED DRIVER (students do not need to edit this file).
 *
 * Lets the user load DNA strands from the keyboard (Scanner on System.in)
 * or from a text file (Scanner on a File), analyze them with DNAProcessor,
 * and save the results to an output file (PrintWriter).
 *
 * Input file format: one strand per line. Blank lines are ignored.
 */
public class DNALab {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        ArrayList<String> strands = new ArrayList<String>();
        boolean running = true;

        while (running) {
            System.out.println();
            System.out.println("=== DNA LAB ===   (" + strands.size() + " strand(s) loaded)");
            System.out.println("1. Type in a strand");
            System.out.println("2. Load strands from a file");
            System.out.println("3. Show analysis of all strands");
            System.out.println("4. Save analysis to a file");
            System.out.println("5. Find the alphabetically first strand");
            System.out.println("0. Quit");
            System.out.print("Choice: ");
            String choice = console.nextLine().trim();

            if (choice.equals("1")) {
                System.out.print("Enter a DNA strand: ");
                addStrand(strands, console.nextLine());
            } else if (choice.equals("2")) {
                System.out.print("Input file name: ");
                loadFromFile(strands, console.nextLine().trim());
            } else if (choice.equals("3")) {
                System.out.print(buildFullReport(strands));
            } else if (choice.equals("4")) {
                System.out.print("Output file name: ");
                saveReport(strands, console.nextLine().trim());
            } else if (choice.equals("5")) {
                showAlphabeticallyFirst(strands);
            } else if (choice.equals("0")) {
                running = false;
            } else {
                System.out.println("Please choose 0-5.");
            }
        }
        System.out.println("Goodbye!");
        console.close();
    }

    /** Cleans up the text, checks it, and adds it to the list if valid. */
    private static void addStrand(ArrayList<String> strands, String text) {
        String dna = text.trim().toUpperCase();
        if (dna.length() == 0) {
            return; // skip blank lines silently
        }
        if (DNAProcessor.isValidDNA(dna)) {
            strands.add(dna);
            System.out.println("Added: " + dna);
        } else {
            System.out.println("Skipped (not valid DNA): " + dna);
        }
    }

    /** Reads every line of the file and tries to add it as a strand. */
    private static void loadFromFile(ArrayList<String> strands, String fileName) {
        try {
            Scanner fileScanner = new Scanner(new File(fileName));
            while (fileScanner.hasNextLine()) {
                addStrand(strands, fileScanner.nextLine());
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Could not find file: " + fileName);
        }
    }

    /** Analysis of one strand, as a multi-line String. */
    public static String analyze(String dna) {
        String report = "Strand:              " + dna + "\n";
        report += "Length:              " + dna.length() + "\n";
        report += "Count A/C/G/T:       " + DNAProcessor.countBase(dna, "A") + " / "
                + DNAProcessor.countBase(dna, "C") + " / "
                + DNAProcessor.countBase(dna, "G") + " / "
                + DNAProcessor.countBase(dna, "T") + "\n";
        report += "GC content:          " + String.format("%.2f", DNAProcessor.gcContent(dna)) + "%\n";
        report += "Complement:          " + DNAProcessor.complement(dna) + "\n";
        report += "Reverse:             " + DNAProcessor.reverse(dna) + "\n";
        report += "Reverse complement:  " + DNAProcessor.reverseComplement(dna) + "\n";
        report += "RNA (transcribed):   " + DNAProcessor.transcribe(dna) + "\n";
        report += "Times \"ATA\" appears: " + DNAProcessor.countOccurrences(dna, "ATA") + "\n";

        String gene = DNAProcessor.findGene(dna);
        if (gene.length() == 0) {
            report += "First gene:          (none found)\n";
        } else {
            report += "First gene:          " + gene + "\n";
        }

        if (DNAProcessor.isReverseComplementPalindrome(dna)) {
            report += "Palindromic site:    YES\n";
        } else {
            report += "Palindromic site:    no\n";
        }
        return report;
    }

    /** Analysis of every strand, plus a comparison of neighbors. */
    private static String buildFullReport(ArrayList<String> strands) {
        if (strands.size() == 0) {
            return "No strands loaded yet.\n";
        }
        String report = "";
        for (int i = 0; i < strands.size(); i++) {
            report += "----- Strand #" + (i + 1) + " -----\n";
            report += analyze(strands.get(i)) + "\n";
        }
        if (strands.size() >= 2) {
            report += "===== Comparing strand #1 to the others =====\n";
            String first = strands.get(0);
            for (int i = 1; i < strands.size(); i++) {
                String other = strands.get(i);
                report += "#1 vs #" + (i + 1) + ": common prefix = \""
                        + DNAProcessor.commonPrefix(first, other) + "\", "
                        + "differences = " + DNAProcessor.hammingDistance(first, other)
                        + " (-1 means different lengths)\n";
            }
        }
        return report;
    }

    /** Writes the full report to a file. */
    private static void saveReport(ArrayList<String> strands, String fileName) {
        try {
            PrintWriter out = new PrintWriter(new File(fileName));
            out.print(buildFullReport(strands));
            out.close();
            System.out.println("Saved results to " + fileName);
        } catch (FileNotFoundException e) {
            System.out.println("Could not write to file: " + fileName);
        }
    }

    /** Uses alphabeticallyFirst to scan the whole list. */
    private static void showAlphabeticallyFirst(ArrayList<String> strands) {
        if (strands.size() == 0) {
            System.out.println("No strands loaded yet.");
            return;
        }
        String best = strands.get(0);
        for (int i = 1; i < strands.size(); i++) {
            best = DNAProcessor.alphabeticallyFirst(best, strands.get(i));
        }
        System.out.println("Alphabetically first strand: " + best);
    }
}
