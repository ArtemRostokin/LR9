public class Main {
    public static void main(String[] args) {
        try {
            // Создание таблицы для Лося
            try {
                TableCreator.createTable(Moose.class);
            } catch (Exception e) {
                System.out.println("Ошибка при создании таблицы для Лося: " + e.getMessage());
            }

            // Создание объектов Лося
            Moose moose = new Moose(1, "Том", true);
            Moose moose1 = new Moose(2, "Матильда", false);
            Moose moose2 = new Moose(3, "Гарри", true);
            Moose moose3 = new Moose(4, "Робин", true);

            // Вставка объектов Лося в таблицу
            try {
                if (ObjectInserter.insertObject(moose)) {
                    System.out.println("Лось Том успешно вставлен в таблицу.");
                }
            } catch (Exception e) {
                System.out.println("Ошибка при вставке Лося Тома: " + e.getMessage());
            }

            try {
                if (ObjectInserter.insertObject(moose1)) {
                    System.out.println("Лось Матильда успешно вставлен в таблицу.");
                }
            } catch (Exception e) {
                System.out.println("Ошибка при вставке Лося Матильды: " + e.getMessage());
            }

            try {
                if (ObjectInserter.insertObject(moose2)) {
                    System.out.println("Лось Гарри успешно вставлен в таблицу.");
                }
            } catch (Exception e) {
                System.out.println("Ошибка при вставке Лося Гарри: " + e.getMessage());
            }

            try {
                if (ObjectInserter.insertObject(moose3)) {
                    System.out.println("Лось Робин успешно вставлен в таблицу.");
                }
            } catch (Exception e) {
                System.out.println("Ошибка при вставке Лося Робин: " + e.getMessage());
            }

            try {
                TableCreator.createTable(Hippo.class);
            } catch (Exception e) {
                System.out.println("Ошибка при создании таблицы для Бегемота: " + e.getMessage());
            }

            Hippo hippo1 = new Hippo(1, "Гектор", WeightCategory.HEAVY);
            Hippo hippo2 = new Hippo(2, "Альфа", WeightCategory.MEDIUM);
            Hippo hippo3 = new Hippo(3, "Бетти", WeightCategory.LIGHT);

            try {
                if (ObjectInserter.insertObject(hippo1)) {
                    System.out.println("Бегемот Гектор успешно вставлен в таблицу.");
                }
            } catch (Exception e) {
                System.out.println("Ошибка при вставке Бегемота Гектора: " + e.getMessage());
            }

            try {
                if (ObjectInserter.insertObject(hippo2)) {
                    System.out.println("Бегемот Альфа успешно вставлен в таблицу.");
                }
            } catch (Exception e) {
                System.out.println("Ошибка при вставке Бегемота Альфы: " + e.getMessage());
            }

            try {
                if (ObjectInserter.insertObject(hippo3)) {
                    System.out.println("Бегемот Бетти успешно вставлен в таблицу.");
                }
            } catch (Exception e) {
                System.out.println("Ошибка при вставке Бегемота Бетти: " + e.getMessage());
            }

            try {
                TableCreator.createTable(Camel.class);
            } catch (Exception e) {
                System.out.println("Ошибка при создании таблицы для Верблюда: " + e.getMessage());
            }

            Camel camel1 = new Camel(1, "Сэм", HumpType.TWO_HUMPS);
            Camel camel2 = new Camel(2, "Миша", HumpType.ONE_HUMP);
            Camel camel3 = new Camel(3, "Алекс", HumpType.TWO_HUMPS);

            try {
                if (ObjectInserter.insertObject(camel1)) {
                    System.out.println("Верблюд Сэм успешно вставлен в таблицу.");
                }
            } catch (Exception e) {
                System.out.println("Ошибка при вставке Верблюда Сэма: " + e.getMessage());
            }

            try {
                if (ObjectInserter.insertObject(camel2)) {
                    System.out.println("Верблюд Миша успешно вставлен в таблицу.");
                }
            } catch (Exception e) {
                System.out.println("Ошибка при вставке Верблюда Миши: " + e.getMessage());
            }

            try {
                if (ObjectInserter.insertObject(camel3)) {
                    System.out.println("Верблюд Алекс успешно вставлен в таблицу.");
                }
            } catch (Exception e) {
                System.out.println("Ошибка при вставке Верблюда Алекса: " + e.getMessage());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


