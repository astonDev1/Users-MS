package users.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Profile {

    @Id
    private String id;

    private String role;
    private String userName;
    private Integer gamesPlayed;    private Integer avgPercent;

    private String bestCategory;


}
