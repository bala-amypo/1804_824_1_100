public class UserController
{
    @Autowired
    UserService obj;
    @PostMapping("/register")
    public User UserRegister(User user)
    {
        return obj.register(user);
    }

    
}