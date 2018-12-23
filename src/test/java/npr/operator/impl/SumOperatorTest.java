package npr.operator.impl;


import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Stack;
import npr.domain.ValueNode;
import org.junit.Before;
import org.junit.Test;

public class SumOperatorTest {

  private Stack<ValueNode> valueStack = new Stack<>();

  private SumOperator sumOperator = new SumOperator();


  @Before
  public void prepare() {
    valueStack.push(new ValueNode(new BigDecimal(1)));
    valueStack.push(new ValueNode(new BigDecimal(2)));
  }

  @Test
  public void process() {
    sumOperator.process(valueStack);
    assertEquals(BigDecimal.valueOf(3), valueStack.peek().getValue());
    assertEquals(BigDecimal.valueOf(1), valueStack.peek().getUndoStack().pop().getValue());
    assertEquals(BigDecimal.valueOf(2), valueStack.peek().getUndoStack().pop().getValue());
    assertEquals(1, valueStack.size());
  }
}