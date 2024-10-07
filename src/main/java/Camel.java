@Table(title = "camel")
public class Camel {
    @Column(name = "id", type = "int")
    private int id;

    @Column(name = "name", type = "VARCHAR")
    private String name;

    @Column(name = "humpType", type = "TEXT")
    private HumpType humpType;

    // Конструкторы, геттеры и сеттеры
    public Camel(int id, String name, HumpType humpType) {
        this.id = id;
        this.name = name;
        this.humpType = humpType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HumpType getHumpType() {
        return humpType;
    }

    public void setHumpType(HumpType humpType) {
        this.humpType = humpType;
    }
}
enum HumpType {
    ONE_HUMP, TWO_HUMPS
}
