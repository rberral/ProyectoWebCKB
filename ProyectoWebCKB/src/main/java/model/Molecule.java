package model;

public abstract class Molecule {
  protected byte[] buf;

  public byte[] toByteArray() {
    return buf;
  }

  public int getSize() {
    return toByteArray().length;
  }
}
