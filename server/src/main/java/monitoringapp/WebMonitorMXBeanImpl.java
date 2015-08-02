package monitoringapp;

public class WebMonitorMXBeanImpl implements WebMonitorMXBean {

	private static WebMonitorMXBeanImpl instance = null;
	public static synchronized WebMonitorMXBeanImpl getInstance(){
		if (instance == null){
			instance = new WebMonitorMXBeanImpl();
		}
		return instance;
	}

	private Integer numRequestCounter = 0;
	private Integer numRootRequestsCounter = 0;

	@Override
	public Integer getNumRequests() { return numRequestCounter; }

	@Override
	public Integer getNumRootRequests() { return numRootRequestsCounter; }

	public synchronized void  incNumRequestCounter() { this.numRequestCounter += 1; }

	public synchronized void incNumRootRequestsCounter() { this.numRootRequestsCounter += 1; }


}
