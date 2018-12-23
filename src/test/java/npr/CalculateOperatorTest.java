package npr;


import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import npr.exception.NprException;
import org.junit.Test;

public class CalculateOperatorTest {

  private CalculateOperator calculateOperator = new CalculateOperator();

  @Test
  public void processNumberPush() {
    calculateOperator.process("10");
    calculateOperator.process("11");
    assertEquals(BigDecimal.valueOf(11), calculateOperator.getValueStack().pop().getValue());
    assertEquals(BigDecimal.valueOf(10), calculateOperator.getValueStack().pop().getValue());
  }

  @Test
  public void processSum() {
    calculateOperator.process("10");
    calculateOperator.process("11");
    calculateOperator.process("+");
    assertEquals(BigDecimal.valueOf(21), calculateOperator.getValueStack().pop().getValue());
  }

  @Test
  public void processSub() {
    calculateOperator.process("10");
    calculateOperator.process("11");
    calculateOperator.process("-");
    assertEquals(BigDecimal.valueOf(-1), calculateOperator.getValueStack().pop().getValue());
  }

  @Test
  public void processMultiply() {
    calculateOperator.process("10");
    calculateOperator.process("11");
    calculateOperator.process("*");
    assertEquals(BigDecimal.valueOf(110), calculateOperator.getValueStack().pop().getValue());
  }

  @Test
  public void processDivide() {
    calculateOperator.process("10");
    calculateOperator.process("2");
    calculateOperator.process("/");
    assertEquals(BigDecimal.valueOf(5), calculateOperator.getValueStack().pop().getValue().stripTrailingZeros());
  }

  @Test
  public void processSqrt() {
    calculateOperator.process("9");
    calculateOperator.process("sqrt");
    assertEquals(BigDecimal.valueOf(3), calculateOperator.getValueStack().pop().getValue().stripTrailingZeros());
  }

  @Test
  public void processUndo() {
    calculateOperator.process("9");
    calculateOperator.process("sqrt");
    calculateOperator.process("undo");
    assertEquals(BigDecimal.valueOf(9), calculateOperator.getValueStack().pop().getValue().stripTrailingZeros());
  }

  @Test
  public void processClear() {
    calculateOperator.process("10");
    calculateOperator.process("2");
    calculateOperator.process("clear");
    assertEquals(0, calculateOperator.getValueStack().size());
  }

  @Test(expected = NprException.class)
  public void processInsucientParam() {
    calculateOperator.process("10");
    calculateOperator.process("+");
  }

  @Test(expected = NprException.class)
  public void processNotSupportOperator() {
    calculateOperator.process("10");
    calculateOperator.process("11");
    calculateOperator.process("&");
  }
}