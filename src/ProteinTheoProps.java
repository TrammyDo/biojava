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
   * @return the molecular weight of the protein
   */

  public double getMolecularWeight () {
    double molecularWeight = 0;
    AminoAcidSet aminoAcidSet;
    AminoAcid aminoAcid;

    aminoAcidSet = new AminoAcidSet();

    for (int i = 0; i < mProtein.length(); i++) {
     aminoAcid = aminoAcidSet.getAminoAcid(mProtein.charAt(i));
     molecularWeight += aminoAcid.getMolecularWeight();
    }

    return molecularWeight;
  }

  public double getIsoelectricPoint () {
    final char ASP = 'D', GLU = 'E', CYS = 'C', TYR = 'Y', HIS = 'H', LYS = 'K', ARG = 'R';
    int numASP = 0, numGLU = 0, numCYS = 0, numTYR = 0, numHIS = 0, numLYS = 0, numARG = 0;
    double isoelectricPoint = 0;

    for (int i = 0; i < mProtein.length(); i++)
    {
      if (mProtein.charAt(i) == ASP) {
        numASP++;
      }
      else if (mProtein.charAt(i) == GLU) {
        numGLU++;
      }
      else if (mProtein.charAt(i) == CYS) {
        numCYS++;
      }
      else if (mProtein.charAt(i) == TYR) {
        numTYR++;
      }
      else if (mProtein.charAt(i) == HIS) {
        numHIS++;
      }
      else if (mProtein.charAt(i) == LYS) {
        numLYS++;
      }
      else if (mProtein.charAt(i) == ARG) {
        numARG++;
      }
    }

    return isoelectricPoint;
  }
}
