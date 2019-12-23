package by.samsolutions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;

/**
 * @author kiryl.drabysheuski
 */
@RestController
public class GreetingController {

    private final String filePath = "custom_volume/timestamp.txt";

    @RequestMapping("/readLastRequest")
    public String readLastRequest() {
        try (final BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            final String lastRequest = reader.readLine();
            System.out.println("LastRequest is " + lastRequest);
            return lastRequest;

        } catch (IOException e) {
            e.printStackTrace();
            return HttpStatus.INTERNAL_SERVER_ERROR.toString();
        }
    }

    // to simplify testing
    @GetMapping(path = "/writeLastRequest")
    public HttpStatus writeLastRequest() {
        ensureVolumeExists();

        try (final BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {

            final Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            System.out.println("Timestamp is " + timestamp);

            writer.write(timestamp.toString());
            return HttpStatus.ACCEPTED;

        } catch (IOException e) {
            e.printStackTrace();
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

    private void ensureVolumeExists() {
        try {
            Path directory = Files.createDirectories(Paths.get("custom_volume"));
            final Path path = Paths.get(directory.toString() + File.separator + "timestamp.txt");

            final boolean exists = Files.exists(path);
            System.out.println("Exists:" + exists);
            if (!exists) {
                Files.createFile(path);
                System.out.println("File has been just created!");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
