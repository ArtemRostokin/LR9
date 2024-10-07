@Table(title = "moose")
public class Moose {
    @Column(name = "id", type = "int")
    private int id;

    @Column(name = "name", type = "VARCHAR")
    private String name;

    @Column(name = "gender", type = "TEXT")
    private boolean isMale;

    // Конструкторы, геттеры и сеттеры
    public Moose(int id, String name, boolean isMale) {
        this.id = id;
        this.name = name;
        this.isMale = isMale;
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

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean isMale) {
        this.isMale = isMale;
    }
}
