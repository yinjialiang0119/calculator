package npr;


import npr.exception.NprException;

public class NprCalculator {

  private CalculateOperator calculateOperator = new CalculateOperator();

  public void process(String input) {
    String[] inputs = input.split("\\s");
    for (String value : inputs) {
      try {
        calculateOperator.process(value);
      } catch (NprException e) {
        System.out.println(e.getMessage());
        break;
      } catch (Exception e) {
        System.out.println("system error");
        throw e;
      }
    }
    System.out.println(calculateOperator.getResult());
  }

  public CalculateOperator getCalculateOperator() {
    return calculateOperator;
  }
}
