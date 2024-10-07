import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TableCreator {
    public static void createTable(Class<?> clazz) throws Exception {
        if (!clazz.isAnnotationPresent(Table.class)) {
            throw new RuntimeException("No Table annotation present on class " + clazz.getName());
        }

        Table table = clazz.getAnnotation(Table.class);
        String tableName = table.title();

        // ���������, ���������� �� �������
        if (TableChecker.doesTableExist(tableName)) {
            System.out.println("������� " + tableName + " ��� ����������.");
            return; // �������, ���� ������� ��� ����������
        }

        // ���� ������� �� ����������, ������� �
        StringBuilder sql = new StringBuilder("CREATE TABLE " + tableName + " (");

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Column.class)) {
                Column column = field.getAnnotation(Column.class);
                sql.append(column.name()).append(" ").append(column.type()).append(", ");
            }
        }

        sql.setLength(sql.length() - 2); // ������� ��������� �������
        sql.append(");");

        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/LB9", "postgres", "awerta357");
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql.toString());
            // ������� ��������� � ���, ��� ������� ���� ������� ������� ������ � ������ � ��������
            System.out.println("������� " + tableName + " ������� �������.");
        }
    }
}


