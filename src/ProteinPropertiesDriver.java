/*
Filename:   ProteinDriver.java
Author:     Tram Do
Course:     BINF 395
Assignment: Protein
Purpose:    Create a program to read in a DNA strand and translate it into a protein.
Hours:      15
 */

import org.biojava.nbio.core.sequence.ProteinSequence;

import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.Scanner;

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
    ImageIcon icon = new ImageIcon("C:\\Users\\John\\IdeaProjects\\biojavaTram\\img\\png-clipart-protein-structure-amino-acid-biology-proteins-s-text-structure-thumbnail.png");

    uniProtId = (String) JOptionPane.showInputDialog(null, "Enter a UniProt ID",
            "Protein Theoretical Properties", JOptionPane.INFORMATION_MESSAGE, icon, null, "");
    JButton button = new JButton("Calculate!");
    button.addActionListener(new ButtonPress());
    uniProtProtein = new UniProtProtein(uniProtId);
    proteinSequence = uniProtProtein.getProtein();
    protein = uniProtProtein.getProtein().toString();
    getProperties = new ProteinTheoProps(protein);

    String output[] = {"Sequence: " + proteinSequence, "\nLength: " + protein.length(),
                       "\nMolecular Weight: " + getProperties.getMolecularWeight() + " Da",
                       "\nIsolectric Point: " + df.format(getProperties.getIsoelectricPoint()) + " pH",
                       "\nHydrophobicity: " + df.format(getProperties.getHydrophobicity()),
                       "\nExtinction coefficient 1: " + df.format(getProperties.getExtinctionCoefficient1()),
                       "\nExtinction coefficient 2: " + df.format(getProperties.getExtinctionCoefficient2())};

    JList list = new JList(output);
    JScrollPane scrollPane = new JScrollPane(list);
    scrollPane.setPreferredSize(new Dimension(500, 500));
    JOptionPane.showMessageDialog(null, scrollPane, "Protein Theoretical Properties",
                                  JOptionPane.PLAIN_MESSAGE);
  }
}

