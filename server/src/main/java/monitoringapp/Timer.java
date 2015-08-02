package monitoringapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Supplier;

public class Timer {

	private static Logger logger = LoggerFactory.getLogger(Timer.class.getSimpleName());

	public static <O> O time(String name, Supplier<O> func) {
		Long startTime = System.currentTimeMillis();
		O output = func.get();
		Long totalTime = System.currentTimeMillis() - startTime;
		logger.info("timed:" + name + " took:" + totalTime);
		return output;
	}

}