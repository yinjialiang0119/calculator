package npr.operator.impl;

import java.util.Stack;
import npr.domain.ValueNode;

public class UndoOperator extends AbstractOperator {

  @Override
  public void process(Stack<ValueNode> valueStack) {
    if (valueStack.isEmpty()) {
      return;
    }
    ValueNode valueNode = valueStack.pop();
    if (null == valueNode.getUndoStack()) {
      return;
    }
    if (valueNode.getUndoStack().size() == 1) {
      ValueNode one = valueNode.getUndoStack().pop();
      valueStack.push(new ValueNode(one.getValue(), one.getUndoStack()));
      return;
    }
    ValueNode one = valueNode.getUndoStack().pop();
    ValueNode two = valueNode.getUndoStack().pop();
    valueStack.push(new ValueNode(one.getValue(), one.getUndoStack()));
    valueStack.push(new ValueNode(two.getValue(), two.getUndoStack()));
  }
}
