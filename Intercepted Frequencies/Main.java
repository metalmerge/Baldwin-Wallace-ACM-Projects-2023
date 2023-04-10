import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // System.out.print("Number of cases: ");
    int cases = 1;
    // sc.nextInt();
    for (int i = 0; i < cases; i++) {
      // System.out.println("Number of lines: ");
      int numlines = 3;
      // sc.nextInt();
      ArrayList < Message > array = new ArrayList < > ();

      // for (int j = 0; j < numlines; j++) {
      // int messageNum = sc.nextInt();
      // int lineNum = sc.nextInt();
      // String str = sc.nextLine();
      // array.add(new Message(str.substring(1, str.length()), messageNum, lineNum));
      // }
      array.add(new Message("Hello", 0, 0));
      array.add(new Message("World", 0, 1));
      array.add(new Message("Hi", 1, 0));
      array.add(new Message("Goodbye", 2, 0));
      array.add(new Message("!", 0, 2));

      Collections.sort(array, new MessageComparator());
      System.out.print("Case " + (i + 1) + ":");
      int currentMessageNum = -1;
      for (Message message: array) {
        if (message.messageNum != currentMessageNum) {
          System.out.println("\nMessage " + (currentMessageNum + 1) + ":");
          currentMessageNum = message.messageNum;
        }
        System.out.print(message.text + " ");
      }
    }
  }
}