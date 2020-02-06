package event;

public enum Duration {
	_5(5L), _10(10L), _15(15L), _60(60);

	private long time;

	Duration(long l) {
		time = l;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}


}
