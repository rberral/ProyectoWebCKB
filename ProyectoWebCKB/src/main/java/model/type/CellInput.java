package model.type;

import static model.MoleculeConverter.packUint64;

public class CellInput {
  public OutPoint previousOutput;
  public long since;

  public CellInput() {
  }

  public CellInput(OutPoint previousOutput, long since) {
    this.previousOutput = previousOutput;
    this.since = since;
  }

  public CellInput(OutPoint previousOutput) {
    this(previousOutput, 0);
  }

  public model.CellInput pack() {
    return model.CellInput.builder()
        .setSince(packUint64(since))
        .setPreviousOutput(previousOutput.pack())
        .build();
  }
}
