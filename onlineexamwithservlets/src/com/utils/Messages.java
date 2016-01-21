package com.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Messages
{
    private static final Properties properties = new Properties();

    private Messages()
    {

    }

    public static void load(InputStream inputStream) throws IOException
    {
        properties.load(inputStream);
    }

    public static String getMessage(String key)
    {
        return (String) properties.get(key);
    }
}
