package model.type;

import model.*;
import static model.MoleculeConverter.packUint64;

import model.Utils;

public class CellOutput {
  public long capacity;
  public Script type;
  public Script lock;

  public CellOutput() {
  }

  public CellOutput(long capacity, Script lock) {
    this.capacity = capacity;
    this.lock = lock;
  }

  public CellOutput(long capacity, Script lock, Script type) {
    this.capacity = capacity;
    this.lock = lock;
    this.type = type;
  }

  public long occupiedCapacity(byte[] data) {
    long byteSize = Utils.ckbToShannon(8);
    if (data != null) {
      byteSize += Utils.ckbToShannon(data.length);
    }
    if (lock != null) {
      byteSize += lock.occupiedCapacity();
    }
    if (type != null) {
      byteSize += type.occupiedCapacity();
    }
    return byteSize;
  }

  public model.CellOutput pack() {
	    return model.CellOutput.builder()
	        .setLock(lock.pack())
	        .setType(type == null ? null : type.pack())
	        .setCapacity(packUint64(capacity))
	        .build();
	  }
}
