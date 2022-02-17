package ca.uqac.API.utils;

import java.util.Base64;

public class Base64Utils {

    public static byte[] base64ToByteArray(String base64) {
        if(base64.contains("base64")) base64 = base64.split(",")[1];
        return Base64.getDecoder().decode(base64);
    }
}
