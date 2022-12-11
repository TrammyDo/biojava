/**
 * An amino acid set class that will store all the information for each amino acid.
 *
 * @author Tram Do
 *
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AminoAcidSet {
  private AminoAcid[] mAminoAcids;
  private int mSize;

  /**
   * Initializes an amino acid array and fills it with information from a text file
   */

  public AminoAcidSet () {
    final int NUM_AMINO_ACIDS = 22;
    char AAAbbrev;
    int molecularWeight;
    double hydrophobicity;
    String aminoAcidFile = "data/aminoacid.txt";

    mAminoAcids = new AminoAcid [NUM_AMINO_ACIDS];
    mSize = 0;

    try {
      File aminoAcids = new File (aminoAcidFile);
      Scanner scanner = new Scanner (aminoAcids);

      while (scanner.hasNext()) {
        AAAbbrev = scanner.next().charAt(0);
        molecularWeight = scanner.nextInt();
        hydrophobicity = scanner.nextDouble();

        mAminoAcids[mSize] = new AminoAcid (AAAbbrev, molecularWeight, hydrophobicity);
        mSize++;
      }
      scanner.close();
    } catch (FileNotFoundException e) {
      System.out.println ("An error occurred");
      e.printStackTrace();
    }

  }

  /**
   * Gets the amino acid
   *
   * @param aminoAcid the amino acid to get
   *
   * @return the amino acid with corresponding name
   */

  public AminoAcid getAminoAcid (char aminoAcid) {
    AminoAcid aminoAcidReturned = null;
    boolean bAminoAcidFound = false;

    for (int i = 0; i < mSize && !bAminoAcidFound; i++) {
      if (aminoAcid == mAminoAcids[i].getAAName()) {

        aminoAcidReturned = mAminoAcids[i];
        bAminoAcidFound = true;
      }
    }

    if (!bAminoAcidFound) {
      System.out.println ("No amino acid found");
      System.exit(1);
    }

    return aminoAcidReturned;
  }
}


