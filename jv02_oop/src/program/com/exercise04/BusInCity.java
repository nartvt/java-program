package program.com.exercise04;

public class BusInCity extends Bus {
  private String routeWay;
  private int totalKM;
  private final int costForOneKM = 20000;

  public BusInCity(String busId, String userName, String busNumber, String routeWay, int totalKM) {
    super(busId, userName, busNumber);
    this.routeWay = routeWay;
    this.totalKM = totalKM;
  }

  public BusInCity() {

  }

  public String getRouteWay() {
    return routeWay;
  }

  public void setRouteWay(String routeWay) {
    this.routeWay = routeWay;
  }

  public int getTotalKM() {
    return totalKM;
  }

  public void setTotalKM(int totalKM) {
    this.totalKM = totalKM;
  }

  @Override
  public double revenue() {
    return (this.totalKM * this.costForOneKM);
  }

  @Override
  public String toString() {
    return "BusInCity [" + super.toString() + ",routeWay=" + routeWay + ", totalKM=" + totalKM + ", costForOne="
        + costForOneKM + "]";
  }

}
