package src;
import java.util.Scanner;

public class geneAnnotationDriver {
  public static void main(String[] args) throws Exception {
    translateToProtein translate;
    Scanner scanner = new Scanner(System.in);
    String uniProtId;

    System.out.println ("Enter a UniProt ID: ");
    uniProtId = scanner.nextLine();
    scanner.close();

    translate = new translateToProtein(uniProtId);

    System.out.println(translate.getProtein());
  }
}

