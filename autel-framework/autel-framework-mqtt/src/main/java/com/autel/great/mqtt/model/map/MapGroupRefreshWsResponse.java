package com.autel.great.mqtt.model.map;

import com.autel.great.context.base.BaseModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Schema(description = "BizCode: map_group_refresh. <p>When several elements have changed on the server end, such as drag an element on web end, the user end can be notified through WebSocket. " +
        "The downward parameter has the layer group_id. The user end can call \"*Obtain Map Element List*\" to refresh the element list through http after receiving the ID.</p>")
public class MapGroupRefreshWsResponse extends BaseModel {

    @JsonProperty("ids")
    @NotNull
    @Size(min = 1)
    @Schema(description = "group id collection", format = "uuid")
    private List<@Pattern(regexp = "^[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}$") String> ids;

    public MapGroupRefreshWsResponse() {
    }

    @Override
    public String toString() {
        return "MapGroupRefreshWsResponse{" +
                "ids=" + ids +
                '}';
    }

    public List<String> getIds() {
        return ids;
    }

    public MapGroupRefreshWsResponse setIds(List<String> ids) {
        this.ids = ids;
        return this;
    }
}
