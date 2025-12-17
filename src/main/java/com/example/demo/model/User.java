import jakarta.persistance.column;

public class User
{
    private Long id;
    private String fullName;
    private String Password;
    @column(unqiue="true")
    private String Email;


}