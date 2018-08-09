javac Agent.java
jar cvfm agent.jar MANIFEST.MF Agent.class
javac Main.java
java -javaagent:agent.jar=agentargs Main
pause
