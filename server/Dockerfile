FROM java:8

# Install maven
RUN echo "cache-bust3"
RUN apt-get update  
RUN apt-get install -y maven

WORKDIR /code

# Prepare by downloading dependencies
ADD pom.xml /code/pom.xml  
RUN ["mvn", "dependency:resolve"]  
RUN ["mvn", "verify"]

# Adding source, compile and package into a fat jar
ADD src /code/src  
RUN ["mvn", "package"]

EXPOSE 3333 3334
EXPOSE 8000

CMD ["/usr/lib/jvm/java-8-openjdk-amd64/bin/java", "-Djava.rmi.server.hostname=192.168.59.103", "-Dcom.sun.management.jmxremote.port=3333", "-Dcom.sun.management.jmxremote.rmi.port=3334", "-Dcom.sun.management.jmxremote.authenticate=false", "-Dcom.sun.management.jmxremote.ssl=false", "-jar", "target/monitoringapp-jar-with-dependencies.jar"] 


