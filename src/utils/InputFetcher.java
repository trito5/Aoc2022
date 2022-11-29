package utils;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Calendar;

import static java.nio.file.Files.createFile;
import static utils.Constants.FILES;
import static utils.Constants.TXT;
import static secrets.Secrets.COOKIE;

public class InputFetcher {
    static String YEAR = "2020";
    public static void createInputFiles() throws IOException, InterruptedException {
        int today = today();
        today = 1;

        if (!inputFileExists(today)) {
            String input = getInput(today);
            Path path = createFile(Path.of(FILES + today + TXT));
            Files.write(path, input.getBytes());
        }
        if (!testFileExists(today)) {
            String input = "";
            Path path = createFile(Path.of(FILES + today + "t" + TXT));
            Files.write(path, input.getBytes());
        }
     }

    private static String getInput(int dayOfMonth) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder()
                 .uri(URI.create("https://adventofcode.com/" + YEAR + "/day/" + dayOfMonth + "/input"))
                 .header("Cookie", COOKIE)
                 .build();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());
        int code = response.statusCode();
        if (code >= 300) {
            throw new IllegalStateException("Did not fetch input , code: " + code + ", response " + response.body());
        }
        return response.body();
    }

    private static int today() {
         Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.DAY_OF_MONTH);
     }

     private static boolean inputFileExists(int dayOfMonth) {
         File fileDir = new File(FILES + dayOfMonth + TXT);
        return fileDir.exists();
     }

    private static boolean testFileExists(int dayOfMonth) {
        File fileDir = new File(FILES + dayOfMonth + "t" + TXT);
        return fileDir.exists();
    }

}
