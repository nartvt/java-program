package program.com.exercise04;

public class BusOutCity extends Bus {
  private String busDestination;
  private int dayOfUseBus;
  private final int costForOneDay = 500000;

  public BusOutCity(String busId, String userName, String busNumber, String busDestination, int dayOfUseBus) {
    super(busId, userName, busNumber);
    this.busDestination = busDestination;
    this.dayOfUseBus = dayOfUseBus;
  }

  public BusOutCity() {
    super();
  }

  public String getBusDestination() {
    return busDestination;
  }

  public void setBusDestination(String busDestination) {
    this.busDestination = busDestination;
  }

  public int getDayOfUseBus() {
    return dayOfUseBus;
  }

  public void setDayOfUseBus(int dayOfUseBus) {
    this.dayOfUseBus = dayOfUseBus;
  }

  @Override
  public double revenue() {
    return (this.dayOfUseBus * this.costForOneDay);
  }

  @Override
  public String toString() {
    return "BusOutCity [" + super.toString() + ",busDestination=" + busDestination + ", dayOfUseBus=" + dayOfUseBus
        + ", costForOneDay=" + costForOneDay + "]";
  }

}
