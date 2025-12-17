import jakarta.persistance.Column;
import jakarta.persistance.Id;
import jakarta.persistance.LocalDateTime;
import jakarta.persistance.GeneratedValue;


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
    public void setEmail(String email)
    {
        this.email=email;
    }
    public string getPassword()
    {
        return password;
    }
    public void setPassword(String password)
    {
        this.password=password;
    }
    public string getRole()
    {
        return role;
    }
    public void setRole(String role)
    {
        this.role=role;
    }
    @PrePersist
    protected void onCreate()
    {
        this.createdAt=LocalDateTime.now();
    }
    public User()
    {
        this.id=id;
        this.fullName=fullName;
        this.email=email;
        this.password=password;
        this.role=role;
        this.createdAt=createdAt;
    }
    public User()
    {

    }
     `
    


}