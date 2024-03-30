package ru.itmo.util;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.function.Function;

public class CsvWriter {
    
    public static void write(
            String filename,
            Function<Double, Double> function,
            double from,
            double to,
            double step
    ) throws IOException {
        Path path = Paths.get("src/main/resources").resolve(filename);
        if (!Files.exists(path.getParent())) {
            Files.createDirectories(path.getParent());
        }
        try (PrintWriter printWriter = new PrintWriter(Files.newBufferedWriter(path))) {
            printWriter.println("x,ƒ(x)");
            for (double current = from; current - to <= 0; current += step) {
                printWriter.println(current + "," + function.apply(current));
            }
        }

    }
}
