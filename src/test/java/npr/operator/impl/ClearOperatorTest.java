package npr.operator.impl;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Stack;
import npr.domain.ValueNode;
import org.junit.Before;
import org.junit.Test;

public class ClearOperatorTest {

  private Stack<ValueNode> valueStack = new Stack<>();

  private ClearOperator clearOperator = new ClearOperator();


  @Before
  public void prepare() {
    valueStack.push(new ValueNode(new BigDecimal(6)));
    valueStack.push(new ValueNode(new BigDecimal(2)));
  }

  @Test
  public void process() {
    clearOperator.process(valueStack);
    assertEquals(0, valueStack.size());
  }
}