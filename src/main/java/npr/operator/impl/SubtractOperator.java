package npr.operator.impl;

import java.math.BigDecimal;
import java.util.Stack;
import npr.domain.ValueNode;

public class SubtractOperator extends AbstractOperator {

  @Override
  public void process(Stack<ValueNode> valueStack) {
    Stack<ValueNode> stack = popTwiceAndCheck(valueStack);
    Stack<ValueNode> history = (Stack) stack.clone();
    BigDecimal one = stack.pop().getValue();
    BigDecimal two = stack.pop().getValue();
    pushAndRecordHistory(valueStack, one.subtract(two), history);
  }
}
