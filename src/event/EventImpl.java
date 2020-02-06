package event;

import java.util.Map;

public class EventImpl implements CountProcessor.Event {
	private Long                eventTime;
	private Map<String, String> payload;

	public EventImpl(Long eventTime, Map<String, String> payload) {
		this.eventTime = eventTime;
		this.payload = payload;
	}

	@Override
	public Long eventTime() {
		return eventTime;
	}

	@Override
	public Map<String, String> payload() {
		return payload;
	}
}
