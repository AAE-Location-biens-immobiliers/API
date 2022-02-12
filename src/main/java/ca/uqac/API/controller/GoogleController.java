package ca.uqac.API.controller;

import ca.uqac.API.entity.Comptes;
import ca.uqac.API.utils.ParameterStringBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/api/google")
public class GoogleController {

    @GetMapping("/autocomplete")
    public ResponseEntity<Comptes> AutoComplete(@RequestParam("input") String input, @RequestParam("key") String apiKey, @RequestParam("language") String lang) {
        try {
            Map<String, String> parameters = new HashMap<>();
            parameters.put("input", input);
            parameters.put("key", apiKey);
            parameters.put("language", lang);

            URL url = new URL("https://maps.googleapis.com/maps/api/place/autocomplete/json?".concat(ParameterStringBuilder.getParamsString(parameters)));

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setDoOutput(true);


            int status = con.getResponseCode();
            System.out.println(status);

            BufferedReader in = null;

            if (status > 299) {
                in = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            } else {
                in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            }


            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            System.out.println(content);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
