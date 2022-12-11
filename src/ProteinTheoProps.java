/**
 * A class that will calculate and predict the theoretical properties of a given protein
 *
 * @author Tram Do
 *
 */

package src;
import java.lang.Math;

import org.biojava.nbio.aaproperties.PeptideProperties;
import org.biojava.nbio.aaproperties.PeptidePropertiesImpl;
import org.biojava.nbio.core.sequence.ProteinSequence;



public class ProteinTheoProps {
  private String mProtein;

  /**
   * Initializes mProtein to the protein strand that is passed in
   *
   * @param protein the protein to set the class member mProtein to
   */

  public ProteinTheoProps(String protein) {
    mProtein = protein;
  }

  /**
   * Returns the protein sequence
   *
   * @return mProtein, the protein
   */

  public String getProtein() {
    return mProtein;
  }

  /**
   * Gets the length of the protein
   *
   * @param protein the protein to find the length of
   * @return the length of the protein
   */

  public int getProteinLength(String protein) {
    return protein.length();
  }

  /**
   * Calculates the molecular weight of a protein
   *
   * @return the molecular weight of the protein
   */

  public double getMolecularWeight() {
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

  /**
   * Calculates the isoelectric point of a protein
   *
   * @return pH the isoelectric point of the protein
   */

  public double getIsoelectricPoint() {
    final char ASP = 'D', GLU = 'E', CYS = 'C', TYR = 'Y', HIS = 'H', LYS = 'K', ARG = 'R';
    int numASP = 0, numGLU = 0, numCYS = 0, numTYR = 0, numHIS = 0, numLYS = 0, numARG = 0;
    double pH = 0.0, QN1, QN2, QN3, QN4, QN5, QP1, QP2, QP3, QP4, totalCharge = 1.0;

    for (int i = 0; i < mProtein.length(); i++) {
      if (mProtein.charAt(i) == ASP) {
        numASP++;
      } else if (mProtein.charAt(i) == GLU) {
        numGLU++;
      } else if (mProtein.charAt(i) == CYS) {
        numCYS++;
      } else if (mProtein.charAt(i) == TYR) {
        numTYR++;
      } else if (mProtein.charAt(i) == HIS) {
        numHIS++;
      } else if (mProtein.charAt(i) == LYS) {
        numLYS++;
      } else if (mProtein.charAt(i) == ARG) {
        numARG++;
      }
    }

    while (totalCharge > 0) {
      QN1 = -1 / (1 + Math.pow(10, (3.65 - pH))); // this calculates the charge of the C-terminal (the end containing the
      // carboxyl group.
      QN2 = -(numASP) / (1 + Math.pow(10, (3.9 - pH)));
      QN3 = -(numGLU) / (1 + Math.pow(10, (4.07 - pH)));
      QN4 = -(numCYS) / (1 + Math.pow(10, (8.18 - pH)));
      QN5 = -(numTYR) / (1 + Math.pow(10, (10.46 - pH)));
      QP1 = numHIS / (1 + Math.pow(10, (pH - 6.04)));
      QP2 = 1 / (1 + Math.pow(10, (pH - 8.2))); // charge for the N terminus
      QP3 = numLYS / (1 + Math.pow(10, (pH - 10.54)));
      QP4 = numARG / (1 + Math.pow(10, (pH - 12.48)));

      totalCharge = QN1 + QN2 + QN3 + QN4 + QN5 + QP1 + QP2 + QP3 + QP4;

      if (pH >= 14) {
        System.out.println("Error with pH - higher than 14");
      }

      if (totalCharge > 0) {
        pH += 0.01;
      }
    }

    return pH;
  }

  /**
   * Calculates the hydroprobicity of a protein
   *
   * @return hydrophobicity the hydrophobicity of a protein
   */

 public double getHydrophobicity (ProteinSequence protein) {

    PeptidePropertiesImpl peptideProperties = new PeptidePropertiesImpl();

    return peptideProperties.getAvgHydropathy(protein);
  }

  /**
   * Calculates the extinction coefficient of a protein including cystine
   *
   * @return extinctionCoeffiecient the extinction coefficient with cystine
   */

//  public double getExtinctionCoefficient1 () {
//    boolean ignoreCase = true;
//    PeptideProperties peptideProperties = new PeptideProperties();
//
//    double extinctionCoefficient = PeptideProperties.getExtinctionCoefficient(sequence, ignoreCase);
//
//    return extinctionCoefficient;
//  }
//
//  /**
//   * Calculates the extinction coefficient of a protein excluding cystine
//   *
//   * @return extinctionCoeffiecient the extinction coefficient without cystine
//   */
//
//  public double getExtinctionCoefficient2 () {
//    String sequence = mProtein.toString();
//    boolean ignoreCase = false;
//    PeptideProperties peptideProperties = new PeptideProperties();
//
//    double extinctionCoefficient = peptideProperties.getExtinctionCoefficient(sequence, ignoreCase);
//
//    return extinctionCoefficient;
//  }
}
