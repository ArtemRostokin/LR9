import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ObjectInserter {
    public static boolean insertObject(Object obj) throws Exception {
        Class<?> clazz = obj.getClass();
        if (!clazz.isAnnotationPresent(Table.class)) {
            throw new RuntimeException("No Table annotation present on class " + clazz.getName());
        }

        Table table = clazz.getAnnotation(Table.class);
        String tableName = table.title();

        Field idField = clazz.getDeclaredField("id");
        idField.setAccessible(true);
        int id = (int) idField.get(obj);

        if (ObjectChecker.doesObjectExist(clazz, id)) {
            System.out.println("Объект с id " + id + " уже существует в таблице " + tableName + ". Пропускаем вставку.");
            return false;
        }

        StringBuilder sql = new StringBuilder("INSERT INTO " + table.title() + " (");

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Column.class)) {
                Column column = field.getAnnotation(Column.class);
                sql.append(column.name()).append(", ");
            }
        }

        sql.setLength(sql.length() - 2);
        sql.append(") VALUES (");

        for (int i = 0; i < fields.length; i++) {
            if (fields[i].isAnnotationPresent(Column.class)) {
                sql.append("?, ");
            }
        }

        sql.setLength(sql.length() - 2);
        sql.append(");");

        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/LB9", "postgres", "awerta357");
             PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {

            int index = 1;
            for (Field field : fields) {
                if (field.isAnnotationPresent(Column.class)) {
                    field.setAccessible(true);
                    Object value = field.get(obj);
                    if (field.getName().equals("isMale")) {
                        pstmt.setString(index++, (boolean) value ? "м" : "ж");
                    } else if (value instanceof WeightCategory) {
                        pstmt.setString(index++, ((WeightCategory) value).name()); // используем setString для enum
                    } else if (value instanceof HumpType) {
                        pstmt.setString(index++, ((HumpType) value).name()); // используем setString для enum
                    } else {
                        pstmt.setObject(index++, value);
                    }
                }
            }
            pstmt.executeUpdate();
        }
        return true;
    }
}




