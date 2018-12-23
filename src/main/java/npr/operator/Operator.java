package npr.operator;


import java.util.Stack;
import npr.domain.ValueNode;

public interface Operator {

  void process(Stack<ValueNode> valueStack);

}
