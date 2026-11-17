/**
 * DNAProcessor - STUDENT FILE
 *
 * Complete every method marked TODO.
 *
 * RULES
 *  - You may ONLY use these String methods:
 *        length()   substring(from)   substring(from, to)
 *        indexOf(String)   equals(String)   compareTo(String)
 *  - You may use + to concatenate Strings.
 *  - NO StringBuilder, NO charAt, NO toCharArray, NO split, NO replace.
 *  - To look at one letter, use substring(i, i + 1).
 *
 * A DNA strand is a String made only of the bases "A", "C", "G", "T".
 * Test as you go: run DNATester after finishing each method.
 */
public class DNAProcessor {

    // =====================================================================
    // LEVEL 1 - Warm-up (length, substring, equals, indexOf)
    // =====================================================================

    /**
     * Returns true if dna is not empty and every letter is A, C, G, or T
     * (uppercase only). Otherwise returns false.
     * HINT: "ACGT".indexOf(oneLetter) is -1 when oneLetter is not a valid base.
     */
    public static boolean isValidDNA(String dna) {
        // TODO
        return false;
    }

    /**
     * Returns how many times the single-letter String base appears in dna.
     * Example: countBase("GATTACA", "A") returns 3
     */
    public static int countBase(String dna, String base) {
        // TODO
        return -1;
    }

    /**
     * Returns the GC-content of dna as a percentage from 0.0 to 100.0:
     * (number of G's + number of C's) / length * 100.
     * Returns 0.0 for an empty strand. Reuse countBase!
     * Example: gcContent("GCAT") returns 50.0
     */
    public static double gcContent(String dna) {
        // TODO
        return -1.0;
    }

    // =====================================================================
    // LEVEL 2 - Building new Strings (loops + concatenation)
    // =====================================================================

    /**
     * Returns the complement of ONE base: A<->T and C<->G.
     * Returns "?" if base is not a valid base. (Use equals.)
     */
    public static String complementBase(String base) {
        // TODO
        return "";
    }

    /**
     * Returns the complement of the whole strand (each base swapped).
     * Example: complement("GATTACA") returns "CTAATGT"
     */
    public static String complement(String dna) {
        // TODO
        return "";
    }

    /**
     * Returns dna written backwards.
     * Example: reverse("GATTACA") returns "ACATTAG"
     */
    public static String reverse(String dna) {
        // TODO
        return "";
    }

    /**
     * Returns the reverse complement (the opposite strand, read 5' to 3').
     * Example: reverseComplement("GATTACA") returns "TGTAATC"
     */
    public static String reverseComplement(String dna) {
        // TODO
        return "";
    }

    /**
     * Returns the RNA version of dna: every T becomes U.
     * Example: transcribe("GATTACA") returns "GAUUACA"
     */
    public static String transcribe(String dna) {
        // TODO
        return "";
    }

    // =====================================================================
    // LEVEL 3 - Searching (indexOf + substring(from))
    // =====================================================================

    /**
     * Returns how many times pattern appears in dna. Overlaps COUNT.
     * Assume pattern has at least one letter.
     * Example: countOccurrences("ATATATA", "ATA") returns 3
     * HINT: use dna.substring(start).indexOf(pattern), then move start
     *       forward to just past where you found it.
     */
    public static int countOccurrences(String dna, String pattern) {
        // TODO
        return -1;
    }

    /**
     * Returns dna with the FIRST occurrence of target replaced by replacement.
     * If target is not found, returns dna unchanged.
     * Example: replaceFirst("GATTACA", "TT", "CC") returns "GACCACA"
     */
    public static String replaceFirst(String dna, String target, String replacement) {
        // TODO
        return "";
    }

    /**
     * Finds the first gene in dna and returns it (including the start and
     * stop codons).
     *   - A gene begins at the first "ATG".
     *   - From there, read the strand 3 letters (one codon) at a time.
     *   - The gene ends at the first codon that is "TAA", "TAG", or "TGA".
     *     Only codons that line up in the reading frame count!
     * Returns "" if there is no "ATG", or no in-frame stop codon.
     * Example: findGene("CCATGAAATTTGGGTAGCC") returns "ATGAAATTTGGGTAG"
     */
    public static String findGene(String dna) {
        // TODO
        return "";
    }

    // =====================================================================
    // LEVEL 4 - Comparing strands (equals + compareTo)
    // =====================================================================

    /**
     * Returns the number of positions where a and b have different letters.
     * Returns -1 if the strands are different lengths.
     * Example: hammingDistance("GATTACA", "GACTATA") returns 2
     */
    public static int hammingDistance(String a, String b) {
        // TODO
        return -2;
    }

    /**
     * Returns the longest beginning part that a and b share ("" if none).
     * Example: commonPrefix("GATTACA", "GATCCC") returns "GAT"
     */
    public static String commonPrefix(String a, String b) {
        // TODO
        return "?";
    }

    /**
     * Returns whichever strand comes first alphabetically (use compareTo).
     * If they are equal, return a.
     * Example: alphabeticallyFirst("GATTACA", "GATC") returns "GATC"
     */
    public static String alphabeticallyFirst(String a, String b) {
        // TODO
        return "?";
    }

    /**
     * Returns true if dna is identical to its own reverse complement.
     * (Restriction enzymes cut at sites like this!)
     * Example: isReverseComplementPalindrome("GAATTC") returns true
     */
    public static boolean isReverseComplementPalindrome(String dna) {
        // TODO
        return false;
    }
}
