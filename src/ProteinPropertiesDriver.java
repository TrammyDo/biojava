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

