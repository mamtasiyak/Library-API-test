import com.github.javafaker.Faker;

public class Setup {
    public String id;
    public String authorName;
    Faker faker = new Faker();
    String aisle = faker.number().digits(6);

    public String payload = "{\n" +
            "\"name\":\"Chemistry\",\n" +
            "\"isbn\":\"physics\",\n" +
            "\"aisle\":" + aisle + ",\n" +
            "\"author\":\"Sonu\"\n" +
            "}";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
