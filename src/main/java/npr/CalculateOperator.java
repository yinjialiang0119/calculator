package npr;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import npr.constant.OperatorEnum;
import npr.domain.ValueNode;
import npr.operator.Operator;
import npr.operator.impl.ClearOperator;
import npr.operator.impl.DiviOperator;
import npr.operator.impl.MultiplyOperator;
import npr.operator.impl.SqrtOperator;
import npr.operator.impl.SubtractOperator;
import npr.operator.impl.SumOperator;
import npr.operator.impl.UndoOperator;

public class CalculateOperator {

  private Stack<ValueNode> valueStack = new Stack<>();

  private Map<OperatorEnum, Operator> abilities = new HashMap<>();

  public CalculateOperator() {
    abilities.put(OperatorEnum.UNDO, new UndoOperator());
    abilities.put(OperatorEnum.SUM, new SumOperator());
    abilities.put(OperatorEnum.SUBTRACT, new SubtractOperator());
    abilities.put(OperatorEnum.MULTIPLY, new MultiplyOperator());
    abilities.put(OperatorEnum.DIVI, new DiviOperator());
    abilities.put(OperatorEnum.SQRT, new SqrtOperator());
    abilities.put(OperatorEnum.CLEAR, new ClearOperator());
  }

  public void process(String item) {
    try {
      BigDecimal number = new BigDecimal(item);
      valueStack.push(new ValueNode(number));
    } catch (NumberFormatException e) {
      abilities.get(OperatorEnum.getValue(item)).process(valueStack);
    }
  }

  public String getResult() {
    StringBuilder result = new StringBuilder("stack:");
    valueStack.stream().forEach(valueNode ->
        result.append(valueNode.getValue().setScale(10, RoundingMode.UP).stripTrailingZeros().toPlainString() + " "));
    return result.toString().trim();
  }

  public Stack<ValueNode> getValueStack() {
    return valueStack;
  }
}
