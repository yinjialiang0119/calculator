package npr.operator.impl;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Stack;
import npr.domain.ValueNode;
import org.junit.Before;
import org.junit.Test;

public class MultiplyOperatorTest {

  private Stack<ValueNode> valueStack = new Stack<>();

  private MultiplyOperator multiplyOperator = new MultiplyOperator();


  @Before
  public void prepare() {
    valueStack.push(new ValueNode(new BigDecimal(2)));
    valueStack.push(new ValueNode(new BigDecimal(3)));
  }

  @Test
  public void process() {
    multiplyOperator.process(valueStack);
    assertEquals(BigDecimal.valueOf(6), valueStack.peek().getValue());
    assertEquals(BigDecimal.valueOf(2), valueStack.peek().getUndoStack().pop().getValue());
    assertEquals(BigDecimal.valueOf(3), valueStack.peek().getUndoStack().pop().getValue());
    assertEquals(1, valueStack.size());
  }
}