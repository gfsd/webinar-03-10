package reverb.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import reverb.api.dto.conditions.ConditionDTO;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ListingConditionsDTO {

    @JsonProperty("conditions")
    private List<ConditionDTO> conditions;
}
