/*
Filename:   ProteinDriver.java
Author:     Tram Do
Course:     BINF 395
Assignment: Protein
Purpose:    Create a program to read in a DNA strand and translate it into a protein.
Hours:      15
 */

package src;
import java.util.Scanner;

public class ProteinPropertiesDriver {

  /**
   * Main driver to get a protein sequence from UniProt and displays the proteins theoretical properties
   */

  public static void main(String[] args) throws Exception {
    ObtainProtein translate;
    Scanner scanner = new Scanner(System.in);
    String uniProtId, protein;
    ProteinTheoProps getProperties;

    System.out.println ("Enter a UniProt ID: ");
    uniProtId = scanner.nextLine();
    scanner.close();

    translate = new ObtainProtein(uniProtId);

    System.out.println("Sequence:" + translate.getProtein() + "\n");

    protein = translate.getProtein().toString();
    System.out.println ("Length: " + protein.length() + "\n");
    getProperties = new ProteinTheoProps(protein);
    System.out.println("Molecular Weight: " + getProperties.getMolecularWeight() + " Da\n");
  }
}

