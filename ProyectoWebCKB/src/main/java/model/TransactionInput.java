package model;

public class TransactionInput {

  public CellInputConcrete input;
  public CellOutput output;
  public byte[] outputData;

  public TransactionInput(CellInputConcrete input, CellOutput output) {
    this(input, output, new byte[0]);
  }

  public TransactionInput(CellInputConcrete input, CellOutput output, byte[] outputData) {
    this.input = input;
    this.output = output;
    this.outputData = outputData;
  }
}
