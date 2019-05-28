package program.com.exercise02;

public enum Rank {
  EXCELLENT("Excellent"), GOOD("Good"), PRETTY("Pretty"), AVERAGE("Average"), STUPID("Stupid");
  private final String text;
  Rank(String text){
    this.text = text;
  }
  public String getText() {
    return this.text;
  }
}
