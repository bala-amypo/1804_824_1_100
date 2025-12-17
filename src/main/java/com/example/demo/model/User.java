import jakarta.persistance.column;
import jakarta.persistance.Id;

public class User
{
    @Id
    private Long id;
    private String fullName;
    private String Password;
    @column(unqiue="true")
    private String Email;


}