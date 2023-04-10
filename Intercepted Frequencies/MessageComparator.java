import java.util.Comparator;

public class MessageComparator implements Comparator < Message > {
  public int compare(Message m1, Message m2) {
    if (m1.messageNum != m2.messageNum) {
      return m1.messageNum - m2.messageNum;
    } else {
      return m1.messageNum - m2.messageNum;
    }
  }
}