package npr.constant;


import npr.exception.NprException;

public enum OperatorEnum {

  SUM("+"), UNDO("undo"), SUBTRACT("-"), MULTIPLY("*"), DIVI("/"), CLEAR("clear"), SQRT("sqrt");

  private final String value;

  OperatorEnum(String value) {
    this.value = value;
  }

  public static OperatorEnum getValue(String value) {
    for (OperatorEnum emun : OperatorEnum.values()) {
      if (emun.value.equals(value)) {
        return emun;
      }
    }
    throw new NprException("NOT SUPPORTED OPERATOR");
  }
}
