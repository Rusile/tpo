package ru.itmo;

import java.io.IOException;

import ru.itmo.system.IncredibleSystem;
import ru.itmo.util.CsvWriter;

public class Application {

    public static void main(String[] args) throws IOException {
        CsvWriter.write(
                "result/system_left.csv",
                (x) -> IncredibleSystem.calculate(x, 1000),
                -1,
                0,
                0.1
        );

        CsvWriter.write(
                "result/system_right.csv",
                (x) -> IncredibleSystem.calculate(x, 1000),
                1,
                2,
                0.1
        );
    }
}
