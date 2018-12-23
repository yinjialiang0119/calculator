package npr.domain;

import java.math.BigDecimal;
import java.util.Stack;

public class ValueNode {

  private BigDecimal value;

  private Stack<ValueNode> undoStack;

  public ValueNode(BigDecimal value) {
    this.value = value;
  }

  public ValueNode() {
  }

  public ValueNode(BigDecimal value, Stack<ValueNode> undoStack) {
    this.value = value;
    this.undoStack = undoStack;
  }

  public BigDecimal getValue() {
    return value;
  }

  public void setValue(BigDecimal value) {
    this.value = value;
  }

  public Stack<ValueNode> getUndoStack() {
    return undoStack;
  }

  public void setUndoStack(Stack<ValueNode> undoStack) {
    this.undoStack = undoStack;
  }
}
