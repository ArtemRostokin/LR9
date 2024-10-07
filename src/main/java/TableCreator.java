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

        // проверяем, существует ли таблица
        if (TableChecker.doesTableExist(tableName)) {
            System.out.println("Таблица " + tableName + " уже существует.");
            return; // выходим, если таблица уже существует
        }

        // если таблица не существует, создаем её
        StringBuilder sql = new StringBuilder("CREATE TABLE " + tableName + " (");

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Column.class)) {
                Column column = field.getAnnotation(Column.class);
                sql.append(column.name()).append(" ").append(column.type()).append(", ");
            }
        }

        sql.setLength(sql.length() - 2); // удаляем последнюю запятую
        sql.append(");");

        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/LB9", "postgres", "awerta357");
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql.toString());
            // выводим сообщение о том, что таблица была успешно создана только в случае её создания
            System.out.println("Таблица " + tableName + " успешно создана.");
        }
    }
}


