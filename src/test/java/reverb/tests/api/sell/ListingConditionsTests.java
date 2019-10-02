package reverb.tests.api.sell;

import lombok.SneakyThrows;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import reverb.api.client.SellService;
import reverb.api.dto.conditions.ConditionDTO;
import reverb.tests.api.sell.dp.ConditionsDataProvider;

import static org.testng.Assert.assertEquals;

public class ListingConditionsTests {

    public static final String API_URL = "https://api.reverb.com/api/";

    private Retrofit retrofit;

    private SellService sellService;

    private int conditionsCount = 0;

    @BeforeClass
    public void setupConfiguration() {
        retrofit = setupRetrofit();
    }

    @BeforeMethod
    public void initService() {
        sellService = retrofit.create(SellService.class);
    }

    @Test
    @SneakyThrows
    public void checkThatConditionsArrayHas8Items() {
        assert sellService.listingConditions().execute().body().getConditions().size() == 8;
    }

    @SneakyThrows
    @Test(dataProviderClass = ConditionsDataProvider.class, dataProvider = "conditionsProvider")
    public void checkConditionNameAndDescription(String name, String description) {
        ConditionDTO conditionDTO = sellService.listingConditions().execute().body().getConditions().get(conditionsCount++);
        assertEquals(conditionDTO.getDisplayName(), name);
        assertEquals(conditionDTO.getDescription(), description);
    }

    public static Retrofit setupRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

}
