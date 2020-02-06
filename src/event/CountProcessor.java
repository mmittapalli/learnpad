package event;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Consumer;
import java.util.stream.Collectors;

class CountProcessor {
	private final BlockingQueue<Event> events;
	private final Set<String>          fields;

	private CountProcessor(BlockingQueue<Event> events, Set<String> fields) {
		this.events = events;
		this.fields = fields;
	}

	/**
	 * @param field    - Name of field counts are requested
	 * @param lookBack - Duration to look back from now
	 * @return The count of specified field over supplied duration
	 */
	Count of(String field, Duration lookBack) {
		long count = 0L, min = Long.MAX_VALUE, max = 0L, total = 0L;
		BigDecimal average;
		if (field.isEmpty()) {
			return new CountImpl(0L, 0L, 0L, new BigDecimal(0), 0L);
		}

		List<Event> filteredEvents = events.stream().filter(e -> e.eventTime() <= lookBack.getTime()).filter(e -> (null != e.payload().get(field))).collect(Collectors.toList());
		for (Event event : filteredEvents) {
			long val = 1L;
			try {
				val = Long.valueOf(event.payload().get(field));
			} catch (Exception e) {
			}
			total = total + val;
			min = val < min ? val : min;
			max = val > max ? val : max;

		}

		average = new BigDecimal(total);
		average = average.divide(new BigDecimal(filteredEvents.size()));

		count = filteredEvents.size();

		return new CountImpl(count, total, min, average, max);
	}

	;

	/**
	 * @param field    - Name of field counts are requested
	 * @param lookBack - Duration to look back from now
	 * @return The count of specified field over supplied duration
	 */
	public Future<Count> asyncOf(String field, Duration lookBack) {

		ExecutorService executorService = Executors.newFixedThreadPool(10);

		Future<Count> future = executorService.submit(() -> of(field, lookBack));
		executorService.shutdown();

		return future;

	}


	public interface Count {
		Long count();

		Long total();

		Long min();

		BigDecimal average();

		Long max();
	}

	public interface Event {
		Long eventTime();

		Map<String, String> payload();
	}

	public static void main(String[] args) {
		//Bounded Queue
		BlockingQueue<Event> queue = new ArrayBlockingQueue<>(10);
		Map<String, String> payLoad1 = new HashMap<>();
		payLoad1.put("id", "2");
		payLoad1.put("resolution", "786432");
		payLoad1.put("colors", "256");
		payLoad1.put("polygons", "2M");
		payLoad1.put("processor", "GFX");

		queue.add(new EventImpl(6L, payLoad1));


		Map<String, String> payLoad2 = new HashMap<>();
		payLoad2.put("id", "3");
		payLoad2.put("resolution", "786432");
		payLoad2.put("colors", "256");
		payLoad2.put("polygons", "2M");
		payLoad2.put("processor", "GDI");

		queue.add(new EventImpl(4L, payLoad2));

		Map<String, String> payLoad3 = new HashMap<>();
		payLoad3.put("id", "4");
		payLoad3.put("colors", "256");
		payLoad3.put("polygons", "2M");
		payLoad3.put("processor", "GRX");

		queue.add(new EventImpl(1L, payLoad3));

		Map<String, String> payLoad4 = new HashMap<>();
		payLoad4.put("id", "1");
		payLoad4.put("resolution", "307200");
		payLoad4.put("colors", "32");
		payLoad4.put("polygons", "1M");
		payLoad4.put("processor", "VDI");
		queue.add(new EventImpl(60L, payLoad4));

		Set<String> fields = new HashSet<>();
		fields.add("resolution");
		fields.add("colors");
		fields.add("processor");
		fields.add("polygons");

		CountProcessor processor = new CountProcessor(queue, fields);
		Consumer<String> print = System.out::println;
		print.accept("****SYNCHRONOUS CALLS***");

		print.accept("Count of colors over 5 Sec :" + processor.of("colors", Duration._5));
//		print.accept("Count of resolution over 15 Sec :"+processor.of("resolution", Duration._15));
//		print.accept("Count of processor over 15 Sec :"+processor.of("processor", Duration._15));
//		print.accept("Count of polygons over 15 Sec :"+processor.of("polygons", Duration._15));
//
//		print.accept("*****ASYNCHRONOUS CALLS*****");
//		try {
//			print.accept("Count of colors over 5 Sec :"+processor.asyncOf("colors", Duration._5).get());
//			print.accept("Count of resolution over 15 Sec :" + processor.asyncOf("resolution", Duration._15).get());
//			print.accept("Count of processor over 15 Sec :"+processor.asyncOf("processor", Duration._15).get());
//			print.accept("Count of polygons over 15 Sec :"+processor.asyncOf("polygons", Duration._15).get());
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		} catch (ExecutionException e) {
//			e.printStackTrace();
//		}


	}
}
