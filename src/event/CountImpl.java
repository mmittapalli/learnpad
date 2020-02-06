package event;

import java.math.BigDecimal;

public class CountImpl implements CountProcessor.Count {
	private Long       countR;
	private Long       totalR;
	private Long       minR;
	private BigDecimal averageR;
	private Long       maxR;

	public CountImpl(Long countR, Long totalR, Long minR, BigDecimal averageR, Long maxR) {
		this.countR = countR;
		this.totalR = totalR;
		this.minR = minR;
		this.averageR = averageR;
		this.maxR = maxR;
	}

	@Override
	public Long count() {
		return countR;
	}

	@Override
	public Long total() {
		return totalR;
	}

	@Override
	public Long min() {
		return minR;
	}

	@Override
	public BigDecimal average() {
		return averageR;
	}

	@Override
	public Long max() {
		return maxR;
	}

	public String toString() {
		return "Count: " + countR + " Total: " + totalR + " Min: " + minR + " Average: " + averageR + " Max: " + maxR;
	}
}
