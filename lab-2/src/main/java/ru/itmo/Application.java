package ru.itmo;

import java.io.IOException;

import ru.itmo.system.IncredibleSystem;
import ru.itmo.util.CsvWriter;

public class Application {

    public static void main(String[] args) throws IOException {
        CsvWriter.write(
                "result/system.csv",
                (x) -> IncredibleSystem.calculate(x, 1000),
                -2,
                2,
                0.1
        );
    }
}
