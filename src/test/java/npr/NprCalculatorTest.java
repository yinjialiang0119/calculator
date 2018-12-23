package npr;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NprCalculatorTest {

  NprCalculator nprCalculator = new NprCalculator();

  @Test
  public void process() {
    nprCalculator.process("1 2 +");
    assertEquals(true, "stack:3".equals(nprCalculator.getCalculateOperator().getResult()));
  }

  @Test
  public void processComplexOne() {
    nprCalculator.process("1 2 3 4 * *");
    assertEquals(true, "stack:1 24".equals(nprCalculator.getCalculateOperator().getResult()));
  }

  @Test
  public void processComplexTwo() {
    nprCalculator.process("1 24 3 4 * /");
    assertEquals(true, "stack:1 2".equals(nprCalculator.getCalculateOperator().getResult()));
  }

  @Test
  public void processComplexThree() {
    nprCalculator.process("1 24 3 4 * * undo undo");
    assertEquals(true, "stack:1 24 3 4".equals(nprCalculator.getCalculateOperator().getResult()));
  }

  @Test
  public void processComplexFour() {
    nprCalculator.process("1 24 8 4 * * undo undo / sqrt undo undo");
    assertEquals(true, "stack:1 24 8 4".equals(nprCalculator.getCalculateOperator().getResult()));
  }
}