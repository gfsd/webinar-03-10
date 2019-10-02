package reverb.api.dto.conditions;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConditionDTO {
    @JsonProperty("uuid")
    private String uuid;
    @JsonProperty("display_name")
    public String displayName;
    @JsonProperty("description")
    public String description;
}
