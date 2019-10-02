package reverb.tests.ui.sell;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import lombok.SneakyThrows;
import org.testng.annotations.*;
import reverb.api.client.SellService;
import reverb.api.dto.conditions.ConditionDTO;

import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.testng.Assert.assertEquals;
import static reverb.tests.api.sell.ListingConditionsTests.setupRetrofit;

public class ListingConditionsTests {

    private int currentOption = 2;

    @BeforeSuite
    public void baseConfigurations() {
        Configuration.baseUrl = "https://sandbox.reverb.com/";
        Configuration.timeout = 30000;
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
    }

    @DataProvider
    @SneakyThrows
    private Object[][] conditionsDataProvider() {
        SellService sellService = setupRetrofit().create(SellService.class);

        List<ConditionDTO> conditions = sellService.listingConditions().execute().body().getConditions();
        Object[][] objectsDataProvider = new Object[conditions.size()][2];

        for (int i = 0; i < conditions.size(); i++) {
            ConditionDTO condition = conditions.get(i);
            objectsDataProvider[i][0] = condition.getDisplayName();
            objectsDataProvider[i][1] = condition.getDescription();
        }

        return objectsDataProvider;
    }

    @BeforeClass
    public void openConditionsBlock() {
        open("/de");

        //click on Sell button
        $("a[class*='site-header'][class*='button']").click();

        //click on the 'Start a listing from scratch' link
        $(".sell__header p a").click();

        $("#product-condition").shouldBe(visible);
    }

    @Test(dataProvider = "conditionsDataProvider")
    public void checkConditionListTest(String displayName, String description) {
        $("#product-condition").click();

        SelenideElement currentOptionElement = $(String.format("#product-condition option:nth-child(%d)", currentOption++));

        String currentName = currentOptionElement.getText();

        currentOptionElement.click();

        String currentDescription = $(".condition-explanation div").getText();

        assertEquals(currentName, displayName);
        assertEquals(currentDescription, description);
    }
}
