package reverb.api.client;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import reverb.api.dto.ListingConditionsDTO;

public interface SellService {

    @GET("listing_conditions")
    @Headers("Accept-Version: 3.0")
    Call<ListingConditionsDTO> listingConditions();
}
