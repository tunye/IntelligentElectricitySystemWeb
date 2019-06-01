package com.ct.system.util;

import java.util.UUID;

/**
 * Created by chentong1 on 2019/6/1.
 */

public class Utils {
    public static String generateUid() {
        return UUID.randomUUID().toString().replace("-", "").toLowerCase();
    }
}
