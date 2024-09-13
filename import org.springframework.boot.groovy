import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class IosVersionDetectorApplication {
    public static void main(String[] args) {
        SpringApplication.run(IosVersionDetectorApplication.class, args);
    }
}

@RestController
class IosVersionController {

    @GetMapping("/")
    public String detectIosVersion(@RequestHeader("User-Agent") String userAgent) {
        if (userAgent.contains("iPhone") || userAgent.contains("iPad")) {
            String version = extractIosVersion(userAgent);
            if (version != null) {
                double iosVersion = Double.parseDouble(version);
                if (iosVersion < 16.5) {
                    return "<html><body style='background: linear-gradient(45deg, #f3ec78, #af4261);'><h1>Welcome!</h1><img src='Trollface.jpg' alt='Greeting Image'></body></html>";
                } else {
                    return "<html><body style='background: linear-gradient(45deg, #f3ec78, #af4261);'><h1>no jelbrek for u :(</h1></body></html>";
                }
            }
        }
        return "<html><body style='background: linear-gradient(45deg, #f3ec78, #af4261);'><h1>nice try ;)</h1></body></html>";
    }

    private String extractIosVersion(String userAgent) {
        String[] parts = userAgent.split("OS ");
        if (parts.length > 1) {
            String versionPart = parts[1].split(" ")[0];
            return versionPart.replace("_", "."); // Replace underscores with dots
        }
        return null;
    }
}
