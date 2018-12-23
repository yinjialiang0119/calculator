package npr.operator.impl;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Stack;
import npr.domain.ValueNode;

public class SqrtOperator extends AbstractOperator {

  @Override
  public void process(Stack<ValueNode> valueStack) {
    Stack<ValueNode> stack = popOnceAndCheck(valueStack);
    Stack<ValueNode> history = (Stack) stack.clone();
    BigDecimal one = stack.pop().getValue();
    pushAndRecordHistory(valueStack,
        new BigDecimal(Math.sqrt(one.doubleValue()), new MathContext(15, RoundingMode.HALF_UP)), history);
  }
}
