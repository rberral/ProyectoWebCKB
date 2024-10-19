package model.type;

import java.util.List;

import model.type.Header;
import model.MoleculeConverter;
import model.Numeric;


public class Block {
  public Header header;

  public List<Transaction> transactions;

  public List<byte[]> proposals;

  public List<Uncle> uncles;

  public String extension;

  public static class Uncle {

    public Header header;

    public List<byte[]> proposals;
  }

  public byte[] getExtensionBytes() {
    if (this.extension == null) {
      return null;
    }
    return Numeric.hexStringToByteArray(this.extension);
  }

  public model.Block pack() {
    if (this.extension != null) {
      return model.BlockV1.builder().setHeader(header.pack())
          .setTransactions(MoleculeConverter.packTransactionVec(transactions))
          .setProposals(MoleculeConverter.packProposalShortIdVec(proposals))
          .setUncles(MoleculeConverter.packUncleBlockVec(uncles))
          .setExtension(MoleculeConverter.packBytes(this.getExtensionBytes()))
          .build()
          .asV0();
    } else {
      return model.Block.builder()
          .setHeader(header.pack())
          .setTransactions(MoleculeConverter.packTransactionVec(transactions))
          .setProposals(MoleculeConverter.packProposalShortIdVec(proposals))
          .setUncles(MoleculeConverter.packUncleBlockVec(uncles))
          .build();
    }
  }
}
