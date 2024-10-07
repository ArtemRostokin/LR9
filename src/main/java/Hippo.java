@Table(title = "hippo")
public class Hippo {
    @Column(name = "id", type = "int")
    private int id;

    @Column(name = "name", type = "VARCHAR")
    private String name;

    @Column(name = "weightCategory", type = "TEXT")
    private WeightCategory weightCategory;

    // Конструкторы, геттеры и сеттеры
    public Hippo(int id, String name, WeightCategory weightCategory) {
        this.id = id;
        this.name = name;
        this.weightCategory = weightCategory;
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

    public WeightCategory getWeightCategory() {
        return weightCategory;
    }

    public void setWeightCategory(WeightCategory weightCategory) {
        this.weightCategory = weightCategory;
    }
}
enum WeightCategory {
    LIGHT, MEDIUM, HEAVY
}