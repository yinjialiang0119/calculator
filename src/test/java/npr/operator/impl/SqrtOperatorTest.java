package npr.operator.impl;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Stack;
import npr.domain.ValueNode;
import org.junit.Before;
import org.junit.Test;

public class SqrtOperatorTest {

  private Stack<ValueNode> valueStack = new Stack<>();

  private SqrtOperator sqrtOperator = new SqrtOperator();


  @Before
  public void prepare() {
    valueStack.push(new ValueNode(new BigDecimal(9)));
  }

  @Test
  public void process() {
    sqrtOperator.process(valueStack);
    assertEquals(BigDecimal.valueOf(3), valueStack.peek().getValue());
    assertEquals(BigDecimal.valueOf(9), valueStack.peek().getUndoStack().peek().getValue());
    assertEquals(1, valueStack.size());
  }
}