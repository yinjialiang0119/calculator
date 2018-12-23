package npr.operator.impl;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Stack;
import npr.domain.ValueNode;
import org.junit.Before;
import org.junit.Test;

public class UndoOperatorTest {

  private Stack<ValueNode> valueStack = new Stack<>();

  private UndoOperator undoOperator = new UndoOperator();

  private SumOperator sumOperator = new SumOperator();

  private SqrtOperator sqrtOperator = new SqrtOperator();


  @Before
  public void prepare() {
    valueStack.push(new ValueNode(new BigDecimal(2)));
    valueStack.push(new ValueNode(new BigDecimal(3)));
  }

  @Test
  public void undoPushNumber() {
    undoOperator.process(valueStack);
    assertEquals(BigDecimal.valueOf(2), valueStack.peek().getValue());
    assertEquals(1, valueStack.size());
  }

  @Test
  public void undoTwoNumberCalculate() {
    sumOperator.process(valueStack);
    assertEquals(BigDecimal.valueOf(5), valueStack.peek().getValue());
    assertEquals(1, valueStack.size());
    undoOperator.process(valueStack);
    assertEquals(2, valueStack.size());
    assertEquals(BigDecimal.valueOf(3), valueStack.pop().getValue());
    assertEquals(BigDecimal.valueOf(2), valueStack.pop().getValue());
  }

  @Test
  public void undoOneNumberCalculate() {
    valueStack.push(new ValueNode(new BigDecimal(9)));
    sqrtOperator.process(valueStack);
    assertEquals(BigDecimal.valueOf(3), valueStack.peek().getValue());
    assertEquals(3, valueStack.size());
    undoOperator.process(valueStack);
    assertEquals(3, valueStack.size());
    assertEquals(BigDecimal.valueOf(9), valueStack.pop().getValue());
  }

  @Test
  public void undoTwiceCalculate() {
    valueStack.push(new ValueNode(new BigDecimal(5)));
    valueStack.push(new ValueNode(new BigDecimal(6)));
    sumOperator.process(valueStack);
    sumOperator.process(valueStack);
    assertEquals(BigDecimal.valueOf(14), valueStack.peek().getValue());
    assertEquals(2, valueStack.size());
    undoOperator.process(valueStack);
    undoOperator.process(valueStack);
    assertEquals(4, valueStack.size());
    assertEquals(BigDecimal.valueOf(6), valueStack.pop().getValue());
    assertEquals(BigDecimal.valueOf(5), valueStack.pop().getValue());
    assertEquals(BigDecimal.valueOf(3), valueStack.pop().getValue());
    assertEquals(BigDecimal.valueOf(2), valueStack.pop().getValue());
  }
}