package com.mindyu.sport_system.util;

import java.security.SecureRandom;
import java.util.Random;

import static com.mindyu.sport_system.util.Md5Util.byteToHexString;

public class Salt {

    public static String getRandomSalt(){
        String str = "";
        Random RANDOM = new SecureRandom();
        byte[] salt = new byte[16];
        RANDOM.nextBytes(salt);

        return byteToHexString(salt);
    }

}
