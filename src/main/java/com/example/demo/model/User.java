import jakarta.persistance.Column;
import jakarta.persistance.Id;

public class User
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    @Column(unqiue="true")
    private String email;
    private String password;
    private String role;
    @PrePersist

    


}