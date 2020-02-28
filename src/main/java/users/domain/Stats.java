package users.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document

public class Stats {

    @Id
    public String id;

    @Indexed
    private int wins;

    @Indexed
    private int losses;

    @Indexed
    private int gamesPlayed;

}
