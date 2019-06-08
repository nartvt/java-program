package program.com.exercise04;

public abstract class Bus {
  protected String busId;
  protected String userName;
  protected String busNumber;

  protected Bus(String busId, String userName, String busNumber) {
    super();
    this.busId = busId;
    this.userName = userName;
    this.busNumber = busNumber;
  }

  protected Bus() {
    super();
  }

  public String getBusId() {
    return busId;
  }

  public void setBusId(String busId) {
    this.busId = busId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getBusNumber() {
    return busNumber;
  }

  public void setBusNumber(String busNumber) {
    this.busNumber = busNumber;
  }

  public abstract double revenue();

  @Override
  public String toString() {
    return "busId=" + busId + ", userName=" + userName + ", busNumber=" + busNumber;
  }

}
