/**
 * A class that will calculate and predict the theoretical properties of a given protein
 *
 * @author Tram Do
 *
 */

package src;

public class ProteinTheoProps {
  private String mProtein;

  /**
   * Initializes mProtein to the protein strand that is passed in
   *
   * @param protein the protein to set the class member mProtein to
   *
   */

  public ProteinTheoProps (String protein) {
    mProtein = protein;
  }

  /**
   * Returns the protein sequence
   *
   * @return mProtein, the protein
   */

  public String getProtein () {
    return mProtein;
  }

  /**
   * Gets the length of the protein
   *
   * @param protein the protein to find the length of
   *
   * @return the length of the protein
   */

  public int getProteinLength (String protein) {
    return protein.length();
  }

  /**
   * Calculates the molecular weight of a protein
   *
   * @param protein the protein to find the length of
   *
   * @return the molecular weight of the protein
   */

  public double getMolecularWeight (String protein) {
    String codon;
    final int CODON_LENGTH = 3;
    double molecularWeight;



  }
}
