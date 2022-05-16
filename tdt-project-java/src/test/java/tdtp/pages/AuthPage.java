package tdtp.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;


@DefaultUrl("https://lighthouse-demo.evozon.com/login")
public class AuthPage extends PageObject {

    public void authenticate(String authUsername, String authPassword) {
        try {
            String url = "http://" + URLEncoder.encode(authUsername, StandardCharsets.UTF_8.toString()) + ":"
                    +  URLEncoder.encode(authPassword, StandardCharsets.UTF_8.toString())+"@" + "lighthouse-demo.evozon.com/login";
            getDriver().get(url);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
