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
public class Project {

    private String title;

    private String description;

    private LocalDateTime finalDate;

    private LocalDateTime createdOn;

    private String creatorUsername;
}
