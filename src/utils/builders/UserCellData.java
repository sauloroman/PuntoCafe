package utils.builders;

public class UserCellData {
    private final String name;
    private final String email;
    private final String imageName;

    public UserCellData(String name, String email, String imageName) {
        this.name = name;
        this.email = email;
        this.imageName = imageName;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getImageName() { return imageName; }
}
