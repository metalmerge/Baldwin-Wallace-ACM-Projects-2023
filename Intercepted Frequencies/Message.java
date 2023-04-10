public class Message {
  public String text;
  public int messageNum;
  public int lineNum;

  public Message(String text, int messageNum, int lineNum) {
    this.text = text;
    this.messageNum = messageNum;
    this.lineNum = lineNum;
  }

  public int compareTo(Message other) {
    return this.messageNum - other.messageNum;
  }

  @Override
  public String toString() {
    return "Message{" +
      "text='" + text + '\'' +
      ", messageNum=" + messageNum +
      ", lineNum=" + lineNum +
      '}';
  }
}