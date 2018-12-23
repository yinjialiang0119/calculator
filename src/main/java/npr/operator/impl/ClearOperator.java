package npr.operator.impl;

import java.util.Stack;
import npr.domain.ValueNode;

public class ClearOperator extends AbstractOperator {

  @Override
  public void process(Stack<ValueNode> valueStack) {
    valueStack.clear();
  }
}
