package model.type;

import com.google.gson.annotations.SerializedName;


public class CellDep {
  public OutPoint outPoint;
  public DepType depType;

  public CellDep() {
  }

  public CellDep(String txHash, int index, DepType depType) {
    this.outPoint = new OutPoint(txHash, index);
    this.depType = depType;
  }

  public CellDep(byte[] txHash, int index, DepType depType) {
    this.outPoint = new OutPoint(txHash, index);
    this.depType = depType;
  }

  public CellDep(OutPoint outPoint, DepType depType) {
    this.outPoint = outPoint;
    this.depType = depType;
  }

  public CellDep(OutPoint outPoint) {
    this.outPoint = outPoint;
    this.depType = DepType.CODE;
  }

  public model.CellDep pack() {
    return model.CellDep.builder()
        .setOutPoint(outPoint.pack())
        .setDepType(depType.pack())
        .build();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    CellDep cellDep = (CellDep) o;

    if (!outPoint.equals(cellDep.outPoint)) return false;
    return depType == cellDep.depType;
  }

  @Override
  public int hashCode() {
    int result = outPoint.hashCode();
    result = 31 * result + depType.hashCode();
    return result;
  }

  public enum DepType {
    @SerializedName("code")
    CODE(0x00),
    @SerializedName("dep_group")
    DEP_GROUP(0x01);

    private byte value;

    DepType(int value) {
      this.value = (byte) value;
    }

    public byte pack() {
      return value;
    }
  }
}
