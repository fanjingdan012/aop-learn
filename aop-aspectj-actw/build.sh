#!/usr/bin/env bash
ASPECTJ_WEAVER=~/.m2/repository/org/aspectj/aspectjweaver/1.9.1/aspectjweaver-1.9.1.jar
ASPECTJ_RT=~/.m2/repository/org/aspectj/aspectjrt/1.9.1/aspectjrt-1.9.1.jar
ASPECTJ_TOOLS=~/.m2/repository/org/aspectj/aspectjtools/1.9.1/aspectjtools-1.9.1.jar
java -jar $ASPECTJ_TOOLS -cp $ASPECTJ_RT -source 1.5 -sourceroots src/main/java/ -d target/classes
read -p "Press any key to continue." var