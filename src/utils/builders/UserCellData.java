package utils.builders;

public class UserCellData {
    private final String name;
    private final String imageName;

    public UserCellData(String name, String imageName) {
        this.name = name;
        this.imageName = imageName;
    }

    public String getName() { return name; }
    public String getImageName() { return imageName; }
}
