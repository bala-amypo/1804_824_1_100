public class UserController
{
    @Autowired
    UserService obj;
    @postMapping("/register")
    public User UserRegister(User user)
    {
        return obj.register(user);
    }
    
    
}