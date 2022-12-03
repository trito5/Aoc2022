import java.io.IOException;
import utils.Tests;

import static utils.InputFetcher.createInputFiles;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        createInputFiles();
        Dec03.run();
        //Tests.run();
    }
}