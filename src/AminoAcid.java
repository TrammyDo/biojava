/**
 * An amino acid class that stores the information of an amino acid.
 *
 * @author Tram Do
 *
 */

public class AminoAcid {
  private char mAbbrev;
  private int mMolecularWeight;
  private double mHydrophobicity;

  /**
   * Initializes the amino acid with the parameter values
   *
   * @param letter the letter of the amino acid
   * @param molecularWeight the molecular weight of an amino acid
   * @param hydrophobicity the hydrophobicity of an amino acid
   *
   */

  public AminoAcid (char letter, int molecularWeight, double hydrophobicity) {
    mAbbrev = letter;
    mMolecularWeight = molecularWeight;
    mHydrophobicity = hydrophobicity;
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

  /**
   * Gets the hydrophobicity of an amino acid
   *
   * @return mHydrophobicity the hydrophobicity of an amino acid
   */

  public double getHydrophobicity () {
    return mHydrophobicity;
  }
}

