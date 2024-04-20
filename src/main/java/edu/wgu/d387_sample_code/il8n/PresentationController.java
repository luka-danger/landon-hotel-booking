package edu.wgu.d387_sample_code.il8n;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api")
public class PresentationController {

    @RequestMapping(path="/TimeZoneConversion.java", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String[] showPresentation() {
        String presentationTime = TimeZoneConversion.displayPresentation();
        return new String[]{presentationTime};
    }
}