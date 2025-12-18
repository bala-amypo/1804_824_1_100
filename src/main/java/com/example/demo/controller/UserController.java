public class UserController
{
    @Autowired
    UserService obj;
    
    ostMapping("/register")
    public User UserRegister(User user)
    {
        return obj.register(user);
    }

    
}