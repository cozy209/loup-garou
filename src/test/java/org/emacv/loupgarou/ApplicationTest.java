package org.emacv.loupgarou;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

@Slf4j
public class ApplicationTest {

    @Test
    public void initTest(){
        Application application = new Application();

        application.run();

        log.info("Bonjour");

        Assert.assertTrue(true);

    }

}