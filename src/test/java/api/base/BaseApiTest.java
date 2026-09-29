package api.base;

import config.ConfigManager;
import io.restassured.RestAssured;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

@Listeners({AllureTestNg.class})
public class BaseApiTest {

    @BeforeClass
    public void setupBaseUri(){
        RestAssured.baseURI= ConfigManager.getValue("api.baseUrl");
    }
}
