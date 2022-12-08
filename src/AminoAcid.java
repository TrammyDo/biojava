/**
 * An amino acid class that stores the information of an amino acid.
 *
 * @author Tram Do
 *
 */

package src;

public class AminoAcid {
  private char mAbbrev;
  private int mMolecularWeight;

  /**
   * Initializes the amino acid with the parameter values
   *
   * @param letter the letter of the amino acid
   * @param molecularWeight the molecular weight of an amino acid
   *
   */

  public AminoAcid (char letter, int molecularWeight) {
    mAbbrev = letter;
    mMolecularWeight = molecularWeight;
  }

  /**
   * Gets the letter abbreviation of an amino acid
   *
   * @return mAbbrev the abbreviated name of an amino acid
   */

  public char getAAName () {
    return mAbbrev;
  }

  /**
   * Gets the molecular weight of an amino acid
   *
   * @return mMolecularWeight the molecular weight of an amino acid
   */

  public int getMolecularWeight () {
    return mMolecularWeight;
  }
}
