package definitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.HelperClass;

public class Hooks {
    private static final Logger logger = LogManager.getLogger(Hooks.class);

    @Before
    public static void setUp() {
        logger.info("Setting up the driver");
        HelperClass.setUpDriver();
    }

    @After
    public static void tearDown() {
        logger.info("Tearing down the driver");
        HelperClass.tearDown();
    }
}