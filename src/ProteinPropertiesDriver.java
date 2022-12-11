/*
Filename:   ProteinDriver.java
Author:     Tram Do
Course:     BINF 395
Assignment: Protein
Purpose:    Create a program to read in a DNA strand and translate it into a protein.
Hours:      15
 */

package src;
import org.biojava.nbio.core.sequence.ProteinSequence;

import java.text.DecimalFormat;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class ProteinPropertiesDriver {

  /**
   * Main driver to get a protein sequence from UniProt and displays the proteins theoretical properties
   */

  public static void main(String[] args) throws Exception {
    UniProtProtein uniProtProtein;
    Scanner scanner = new Scanner(System.in);
    String uniProtId, protein;
    ProteinTheoProps getProperties;
    DecimalFormat df = new DecimalFormat("##.##");
    ProteinSequence proteinSequence;

//    String uniProt = JOptionPane.showInputDialog("Enter a UniProt ID");

//    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    frame.setSize(1000,1000);
//    JButton button = new JButton("Calculate!");
//    frame.getContentPane().add(button);
//    frame.setVisible(true);

    System.out.println("Enter a UniProt ID: ");
    uniProtId = scanner.nextLine();
    scanner.close();

    uniProtProtein = new UniProtProtein(uniProtId);
    proteinSequence = uniProtProtein.getProtein();

    System.out.println("Sequence:" + proteinSequence);

    protein = uniProtProtein.getProtein().toString();
    System.out.println ("Length: " + protein.length());
    getProperties = new ProteinTheoProps(protein);
    System.out.println("Molecular Weight: " + getProperties.getMolecularWeight() + " Da");
    System.out.println("Isoelectric Point: " + df.format(getProperties.getIsoelectricPoint()) + " pH");
    System.out.println("Hydrophobicity: " + getProperties.getHydrophobicity());
//    System.out.println("Extinction coefficient with CYS: " + getProperties.getExtinctionCoefficient1());
//    System.out.println("Extinction coefficient without CYS: " + getProperties.getExtinctionCoefficient2());
  }
}

