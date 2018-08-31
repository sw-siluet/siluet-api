package team.hoosasak.siluet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import team.hoosasak.siluet.service.AccountService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/account/login/facebook", method = RequestMethod.POST)
    private ResponseEntity<?> loginWithFacebook(@RequestParam String token) {
        try {
            URL url = new URL("https://graph.facebook.com/me?fields=id&access_token=\"" + token + "\"");
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"))) {
                for (String line; (line = reader.readLine()) != null; )
                    System.out.println(line);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(token, HttpStatus.OK);
    }

    @RequestMapping(value = "/account/login/kakao", method = RequestMethod.POST)
    private ResponseEntity<?> loginWithKakao(@RequestParam String token) {
        return new ResponseEntity<>(token, HttpStatus.OK);
    }

}
