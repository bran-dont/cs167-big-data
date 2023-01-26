#!/usr/bin/env sh
mvn clean package
hadoop jar target/btran117_lab1-1.0-SNAPSHOT.jar input.txt output.txt