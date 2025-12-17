import jakarta.persistance.column;
import jakarta.persistance.Id;

public class User
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    @column(unqiue="true")
    private String email;
    private String password;
    private String role;
    @PrePersist

    


}