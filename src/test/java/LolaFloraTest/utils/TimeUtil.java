package LolaFloraTest.utils;



import LolaFloraTest.core.PropKey;
import LolaFloraTest.core.PropertyReader;

import java.io.IOException;

public class TimeUtil {

    public static Long getImplicitWait() throws IOException {
        return Long.parseLong(PropertyReader.getInstance().getProperty(PropKey.IMPLICIT_WAIT.getPropVal()));
    }

    public static Long getExplicitWait() throws IOException {
        return Long.parseLong(PropertyReader.getInstance().getProperty(PropKey.EXPLICIT_WAIT.getPropVal()));
    }
}
