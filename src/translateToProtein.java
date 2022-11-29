package src;
import org.biojava.nbio.core.sequence.ProteinSequence;
import org.biojava.nbio.core.sequence.io.FastaReaderHelper;
import java.net.URL;

public class translateToProtein {
  private ProteinSequence mProtein;

  public translateToProtein (String uniProtId) throws Exception {
    URL uniprotFasta = new URL (String.format ("https://www.uniprot.org/uniprotkb/%s.fasta", uniProtId));
    ProteinSequence seq = FastaReaderHelper.readFastaProteinSequence(uniprotFasta.openStream()).get(uniProtId);
    mProtein = seq;
  }

  public ProteinSequence getProtein() {
    return mProtein;
  }

}
