package monitoringapp;

import javax.management.*;
import java.lang.management.ManagementFactory;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class Jmxer {

	public static MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();

	private static ObjectName objectName(String objectName) throws MalformedObjectNameException {
		Map<String,String> nameMap = new HashMap<>();
		nameMap.put("name",objectName);
		return new ObjectName("com.monitoringapp",new Hashtable<>(nameMap));
	}


	public static void registerMBean(Object obj, String typeName)
			throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException,
			MBeanRegistrationException {
		mBeanServer.registerMBean(obj, objectName(typeName));
	}

}