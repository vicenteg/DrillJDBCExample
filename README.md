# Drill JDBC Example

This is some example code for connecting to Apache Drill via JDBC. 

We assume you have Drill already installed and configured in clustered mode (with a zookeeper instance). You only need one drillbit to test this.

You don't need any data. The test query will make use of data that ships with drill. The data is stored in Drill's classpath.

Tested with Drill 1.0.0.

# Instructions

0. Install Drill and Zookeeper. Start Zookeeper, then your drillbit: http://drill.apache.org/docs/distributed-mode-prerequisites/
1. Clone this repository. Edit the java source file to modify the JDBC url to your liking.
2. Build it: `mvn clean package`
3. Run it: `java -cp /opt/apache-drill-1.0.0/jars/jdbc-driver/drill-jdbc-all-1.0.0.jar:target/DrillJDBCExample-1.0-SNAPSHOT.jar com.mapr.drill.DrillJDBCExample`

