import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ObjectChecker {
    public static boolean doesObjectExist(Class<?> clazz, int id) throws Exception {
        Table table = clazz.getAnnotation(Table.class);
        String tableName = table.title();

        String sql = "SELECT 1 FROM " + tableName + " WHERE id = ?"; // предполагая, что id - это первичный ключ

        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/LB9", "postgres", "awerta357");
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet resultSet = pstmt.executeQuery();
            return resultSet.next(); // если результат существует, значит объект уже есть
        }
    }
}
