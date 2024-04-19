package edu.wgu.d387_sample_code.il8n;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api")
public class WelcomeController {

    @RequestMapping(path="/WelcomeMessage.java", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String[] showMessage() {
        String finalMessage = WelcomeMessage.getWelcomeMessage();
        return new String[]{finalMessage};
    }
}
