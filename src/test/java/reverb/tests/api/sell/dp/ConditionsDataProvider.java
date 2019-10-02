package reverb.tests.api.sell.dp;

import org.testng.annotations.DataProvider;

public class ConditionsDataProvider {

    @DataProvider
    public Object[][] conditionsProvider() {
        return new Object[][] {{"Brand New", "Brand New items are sold by an authorized dealer or original builder and include all original packaging."},
                {"Mint", "Mint items are in essentially new original condition but have been opened or played."},
                {"Excellent", "Excellent items are almost entirely free from blemishes and other visual defects and have been played or used with the utmost care."},
                {"Very Good", "Very Good items may show a few slight marks or scratches but are fully functional and in overall great shape."},
                {"Good", "Good condition items function properly but may exhibit some wear and tear."},
                {"Fair", "Fair condition gear should function but will show noticeable cosmetic damage or other issues."},
                {"Poor", "Poor condition gear may not work properly but can still perform most functions."},
                {"Non Functioning", "Non Functioning items do not work as they should. All known issues should be described in the listing description."},
        };
    }
}
