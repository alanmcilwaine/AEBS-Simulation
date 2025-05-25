package com.fixit.aebs;

public enum Sensitivity {
  MAX {
    @Override
    public double sensitivity() {
      return 1;
    }
  }
  ,
  HIGH {
    @Override
    public double sensitivity() {
      return 0.75;
    }
  },
  MEDIUM {
    @Override
    public double sensitivity() {
      return 0.5;
    }
  },
  LOW {
    @Override
    public double sensitivity() {
      return 0.25;
    }
  },
  NONE;

  /* The distance sensitivity for AEBS to use. */
  public double sensitivity() {
    return 0;
  }
}
