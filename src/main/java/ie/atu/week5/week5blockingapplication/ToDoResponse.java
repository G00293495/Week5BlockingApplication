package ie.atu.week5.week5blockingapplication;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ToDoResponse {
    @JsonProperty("userID")
    private int userId;

    @JsonProperty("id")
    private int id;

    @JsonProperty("title")
    private int title;

    @JsonProperty("completed")
    private int completed;
}
