package npr.operator.impl;

import java.util.Stack;
import npr.domain.ValueNode;

public class MultiplyOperator extends AbstractOperator {

  @Override
  public void process(Stack<ValueNode> valueStack) {
    Stack<ValueNode> stack = popTwiceAndCheck(valueStack);
    Stack<ValueNode> history = (Stack) stack.clone();
    pushAndRecordHistory(valueStack, stack.pop().getValue().multiply(stack.pop().getValue()), history);
  }
}
