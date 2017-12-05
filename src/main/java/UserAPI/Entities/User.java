package UserAPI.Entities;

import com.google.common.base.Strings;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.*;

@Entity("users")
@Indexes({@Index(options = @IndexOptions(unique = true),
        fields = {@Field(value = "username")})})
public class User{
    @Id
    @Property("id")
    private ObjectId id;

    @Property("username")
    private String username;

    @Property("password")
    private String password;

    @Property("email")
    private String email;

    public User(){}

    public User (String username, String password, String email){
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public ObjectId getId(){
        return this.id;
    }

    public void setUsername(String username){
        this.username = username;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getUsername(){
        return this.username;
    }
    public String getPassword(){
        return this.password;
    }
    public String getEmail(){
        return this.email;
    }

    public boolean isValid(){
        return !Strings.isNullOrEmpty(username) && !Strings.isNullOrEmpty(password) && !Strings.isNullOrEmpty(email);
    }
}
