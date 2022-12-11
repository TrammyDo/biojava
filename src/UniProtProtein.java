/**
 * A class that will obtain a protein sequence using the UniProt ID
 *
 * @author Tram Do
 *
 */

import org.biojava.nbio.core.sequence.ProteinSequence;
import org.biojava.nbio.core.sequence.io.FastaReaderHelper;
import java.net.URL;

public class UniProtProtein {
  private ProteinSequence mProtein;

  /**
   * Reads from the UniProt database to obtain the sequence of a protein
   *
   * @param uniProtId the ID of the protein sequence to obtain
   */

  public UniProtProtein(String uniProtId) throws Exception {
    URL uniprotFasta = new URL (String.format ("https://www.uniprot.org/uniprotkb/%s.fasta", uniProtId));
    ProteinSequence seq = FastaReaderHelper.readFastaProteinSequence(uniprotFasta.openStream()).get(uniProtId);
    mProtein = seq;
  }

  public ProteinSequence getProtein() {
    return mProtein;
  }
}
