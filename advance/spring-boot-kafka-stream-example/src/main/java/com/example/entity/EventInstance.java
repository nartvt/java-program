package com.example.demo;

public class EventInstance {

	private int unitNo;
	private String eventCode;
	private long timeStamp;

	public EventInstance(int unitNo, String eventCode, long timeStamp) {
		super();
		this.unitNo = unitNo;
		this.eventCode = eventCode;
		this.timeStamp = timeStamp;
	}

	public int getUnitNo() {
		return unitNo;
	}

	public void setUnitNo(int unitNo) {
		this.unitNo = unitNo;
	}

	public String getEventCode() {
		return eventCode;
	}

	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

	@Override
	public String toString() {
		return unitNo + "," + eventCode + "," + timeStamp;
	}

}
