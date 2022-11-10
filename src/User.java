import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@JsonIgnoreProperties({"name","age"})
@Accessors(chain = true)
public class User {
    private String name;
    private int age;
    private String type;
}
