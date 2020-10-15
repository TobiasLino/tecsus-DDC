package com.tecsus.ddc.bills.properties;

import com.tecsus.ddc.utils.PropertiesLoaderImpl;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author TOBIASDASILVALINO
 */
public class LoaderTest {

    @Test
    public void propertiesLoaderImplTest() {
        PropertiesLoaderImpl loader = new PropertiesLoaderImpl("values.properties");

        Assert.assertEquals("https://www.google.com", loader.getProperty("teste.url"));
    }
}
