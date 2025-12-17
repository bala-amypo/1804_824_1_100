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
    private LocalDateTime createdAt;

    public Long getID()
    {
        return  id;
    }
    public void setId(Long id)
    {
        this.id=id;
    }
    public String getFullName()
    {
        return fullName;
    }
    public void setFullName(String fullName)
    {
        this.fullName=fullName;
    }
    public String getEmail()
    {
        return email;
    }
    public void setEmail(){
        this.email=email;
    }
    public string get
    


}