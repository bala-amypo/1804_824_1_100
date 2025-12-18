public class UserImplement implements UserService{
    @AutoWired
    UseRepository obj;
    User register(User user){
        return obj.save(user);
    }
    String findByEmail(String email){
        return obj.getById(email);
    }

}