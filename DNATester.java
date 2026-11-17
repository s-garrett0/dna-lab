/**
 * DNATester - PROVIDED. Run this to check your DNAProcessor methods.
 * Each line shows PASS or FAIL with what was expected and what you got.
 */
public class DNATester {
    private static int passed = 0;
    private static int total = 0;

    private static void check(String name, Object actual, Object expected) {
        total++;
        if (actual.equals(expected)) {
            passed++;
            System.out.println("PASS  " + name);
        } else {
            System.out.println("FAIL  " + name + "  expected: " + expected + "  got: " + actual);
        }
    }

    private static void checkDouble(String name, double actual, double expected) {
        total++;
        if (Math.abs(actual - expected) < 0.01) {
            passed++;
            System.out.println("PASS  " + name);
        } else {
            System.out.println("FAIL  " + name + "  expected: " + expected + "  got: " + actual);
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Level 1 ---");
        check("isValidDNA(ACGT)", DNAProcessor.isValidDNA("ACGT"), true);
        check("isValidDNA(ACGX)", DNAProcessor.isValidDNA("ACGX"), false);
        check("isValidDNA(acgt)", DNAProcessor.isValidDNA("acgt"), false);
        check("isValidDNA(empty)", DNAProcessor.isValidDNA(""), false);
        check("countBase(GATTACA, A)", DNAProcessor.countBase("GATTACA", "A"), 3);
        check("countBase(GATTACA, T)", DNAProcessor.countBase("GATTACA", "T"), 2);
        check("countBase(GATTACA, C)", DNAProcessor.countBase("GATTACA", "C"), 1);
        checkDouble("gcContent(GCAT)", DNAProcessor.gcContent("GCAT"), 50.0);
        checkDouble("gcContent(GATTACA)", DNAProcessor.gcContent("GATTACA"), 28.57);
        checkDouble("gcContent(ATAT)", DNAProcessor.gcContent("ATAT"), 0.0);
        checkDouble("gcContent(empty)", DNAProcessor.gcContent(""), 0.0);

        System.out.println("--- Level 2 ---");
        check("complementBase(A)", DNAProcessor.complementBase("A"), "T");
        check("complementBase(G)", DNAProcessor.complementBase("G"), "C");
        check("complementBase(X)", DNAProcessor.complementBase("X"), "?");
        check("complement(GATTACA)", DNAProcessor.complement("GATTACA"), "CTAATGT");
        check("reverse(GATTACA)", DNAProcessor.reverse("GATTACA"), "ACATTAG");
        check("reverse(empty)", DNAProcessor.reverse(""), "");
        check("reverseComplement(GATTACA)", DNAProcessor.reverseComplement("GATTACA"), "TGTAATC");
        check("transcribe(GATTACA)", DNAProcessor.transcribe("GATTACA"), "GAUUACA");

        System.out.println("--- Level 3 ---");
        check("countOccurrences(ATATATA, ATA)", DNAProcessor.countOccurrences("ATATATA", "ATA"), 3);
        check("countOccurrences(AAAA, AA)", DNAProcessor.countOccurrences("AAAA", "AA"), 3);
        check("countOccurrences(GATTACA, TT)", DNAProcessor.countOccurrences("GATTACA", "TT"), 1);
        check("countOccurrences(GATTACA, GG)", DNAProcessor.countOccurrences("GATTACA", "GG"), 0);
        check("replaceFirst(GATTACA, TT, CC)", DNAProcessor.replaceFirst("GATTACA", "TT", "CC"), "GACCACA");
        check("replaceFirst(no match)", DNAProcessor.replaceFirst("GATTACA", "GG", "CC"), "GATTACA");
        check("replaceFirst(only first)", DNAProcessor.replaceFirst("ATAT", "AT", "G"), "GAT");
        check("findGene(basic)", DNAProcessor.findGene("CCATGAAATTTGGGTAGCC"), "ATGAAATTTGGGTAG");
        check("findGene(no start)", DNAProcessor.findGene("CCCCCC"), "");
        check("findGene(no stop)", DNAProcessor.findGene("ATGAAACCC"), "");
        check("findGene(out-of-frame stops)", DNAProcessor.findGene("ATGCTAGAAATAA"), "");
        check("findGene(stop right away)", DNAProcessor.findGene("ATGTGA"), "ATGTGA");

        System.out.println("--- Level 4 ---");
        check("hammingDistance(GATTACA, GACTATA)", DNAProcessor.hammingDistance("GATTACA", "GACTATA"), 2);
        check("hammingDistance(same)", DNAProcessor.hammingDistance("ACGT", "ACGT"), 0);
        check("hammingDistance(diff length)", DNAProcessor.hammingDistance("ACGT", "ACG"), -1);
        check("commonPrefix(GATTACA, GATCCC)", DNAProcessor.commonPrefix("GATTACA", "GATCCC"), "GAT");
        check("commonPrefix(ACGT, TGCA)", DNAProcessor.commonPrefix("ACGT", "TGCA"), "");
        check("commonPrefix(one is prefix)", DNAProcessor.commonPrefix("GAT", "GATTACA"), "GAT");
        check("alphabeticallyFirst(GATTACA, GATC)", DNAProcessor.alphabeticallyFirst("GATTACA", "GATC"), "GATC");
        check("alphabeticallyFirst(prefix)", DNAProcessor.alphabeticallyFirst("GATTACA", "GAT"), "GAT");
        check("alphabeticallyFirst(equal)", DNAProcessor.alphabeticallyFirst("ACGT", "ACGT"), "ACGT");
        check("isRCPalindrome(GAATTC)", DNAProcessor.isReverseComplementPalindrome("GAATTC"), true);
        check("isRCPalindrome(GATTACA)", DNAProcessor.isReverseComplementPalindrome("GATTACA"), false);

        System.out.println();
        System.out.println("Passed " + passed + " of " + total + " tests.");
    }
}
