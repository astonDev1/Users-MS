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
public class User {

    @Id
    private String id;

    @Indexed
    private String firstName;

    @Indexed
    private String lastName;

    @Indexed
    private String username;

    @Indexed
    private int statId;

    @Indexed
    private String email;

    @Indexed
    private boolean isAdmin;



    //test change

}
