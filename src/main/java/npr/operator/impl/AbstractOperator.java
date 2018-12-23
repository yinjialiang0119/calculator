package npr.operator.impl;

import java.math.BigDecimal;
import java.util.Stack;
import npr.domain.ValueNode;
import npr.exception.NprException;
import npr.operator.Operator;

abstract class AbstractOperator implements Operator {

  protected Stack<ValueNode> popTwiceAndCheck(Stack<ValueNode> valueStack) {
    Stack<ValueNode> stack = new Stack<>();
    if (valueStack.size() < 2) {
      throw new NprException("insucient parameters");
    }
    stack.push(valueStack.pop());
    stack.push(valueStack.pop());
    return stack;
  }

  protected void pushAndRecordHistory(Stack<ValueNode> valueStack, BigDecimal result, Stack history) {
    ValueNode newNode = new ValueNode();
    newNode.setUndoStack(history);
    newNode.setValue(result);
    valueStack.push(newNode);
  }

  protected Stack<ValueNode> popOnceAndCheck(Stack<ValueNode> valueStack) {
    if (valueStack.isEmpty()) {
      throw new NprException("insucient parameters");
    }
    Stack<ValueNode> stack = new Stack<>();
    stack.push(valueStack.pop());
    return stack;
  }

}
