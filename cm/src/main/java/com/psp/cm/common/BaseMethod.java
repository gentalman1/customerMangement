package com.psp.cm.common;

import org.springframework.stereotype.Component;

@Component
public class BaseMethod {

    public static Boolean checkNotNull(Object object) {
        return object != null;
    }
}
