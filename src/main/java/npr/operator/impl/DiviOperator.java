package npr.operator.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Stack;
import npr.domain.ValueNode;

public class DiviOperator extends AbstractOperator {

  @Override
  public void process(Stack<ValueNode> valueStack) {
    Stack<ValueNode> stack = popTwiceAndCheck(valueStack);
    Stack<ValueNode> history = (Stack) stack.clone();
    BigDecimal one = stack.pop().getValue();
    BigDecimal two = stack.pop().getValue();
    pushAndRecordHistory(valueStack, one.divide(two, 15, RoundingMode.HALF_UP), history);
  }
}
