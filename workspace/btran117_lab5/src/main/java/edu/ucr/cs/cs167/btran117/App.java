package edu.ucr.cs.cs167.btran117;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class App {
    public static void main(String[] args) {
        final String inputPath = args[0];
        try (JavaSparkContext spark = new JavaSparkContext("local[*]", "CS167-Lab5")) {
            JavaRDD<String> logFile = spark.textFile(inputPath);
            System.out.printf("Number of lines in the log file %d\n", logFile.count());
        }
    }
}
