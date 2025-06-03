package uni.pu.fmi.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    private String title;

    private String description;

    private LocalDateTime finalDate;

    private int priority;

    private String type;

    private String status;

    private LocalDateTime createdOn;

    private String creatorUsername;

    private String projectTitle;
}
