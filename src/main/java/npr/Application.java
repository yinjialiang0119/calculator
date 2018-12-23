package npr;

import java.util.Scanner;

public class Application {


  public static void main(String[] args) {
    NprCalculator nprCalculator = new NprCalculator();
    Scanner input = new Scanner(System.in);
    System.out.println("The Npr Calculator is started");
    System.out.println("Please input");
    while (input.hasNextLine()) {
      String line = input.nextLine();
      if (null == line || "".equals(line.trim())) {
        continue;
      }
      if ("exit".equals(line.trim())) {
        break;
      }
      try {
        nprCalculator.process(line.trim());
      } catch (Exception e) {
        break;
      }
    }
  }
}
