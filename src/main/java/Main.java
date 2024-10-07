public class Main {
    public static void main(String[] args) {
        try {
            // �������� ������� ��� ����
            try {
                TableCreator.createTable(Moose.class);
            } catch (Exception e) {
                System.out.println("������ ��� �������� ������� ��� ����: " + e.getMessage());
            }

            // �������� �������� ����
            Moose moose = new Moose(1, "���", true);
            Moose moose1 = new Moose(2, "��������", false);
            Moose moose2 = new Moose(3, "�����", true);
            Moose moose3 = new Moose(4, "�����", true);

            // ������� �������� ���� � �������
            try {
                if (ObjectInserter.insertObject(moose)) {
                    System.out.println("���� ��� ������� �������� � �������.");
                }
            } catch (Exception e) {
                System.out.println("������ ��� ������� ���� ����: " + e.getMessage());
            }

            try {
                if (ObjectInserter.insertObject(moose1)) {
                    System.out.println("���� �������� ������� �������� � �������.");
                }
            } catch (Exception e) {
                System.out.println("������ ��� ������� ���� ��������: " + e.getMessage());
            }

            try {
                if (ObjectInserter.insertObject(moose2)) {
                    System.out.println("���� ����� ������� �������� � �������.");
                }
            } catch (Exception e) {
                System.out.println("������ ��� ������� ���� �����: " + e.getMessage());
            }

            try {
                if (ObjectInserter.insertObject(moose3)) {
                    System.out.println("���� ����� ������� �������� � �������.");
                }
            } catch (Exception e) {
                System.out.println("������ ��� ������� ���� �����: " + e.getMessage());
            }

            try {
                TableCreator.createTable(Hippo.class);
            } catch (Exception e) {
                System.out.println("������ ��� �������� ������� ��� ��������: " + e.getMessage());
            }

            Hippo hippo1 = new Hippo(1, "������", WeightCategory.HEAVY);
            Hippo hippo2 = new Hippo(2, "�����", WeightCategory.MEDIUM);
            Hippo hippo3 = new Hippo(3, "�����", WeightCategory.LIGHT);

            try {
                if (ObjectInserter.insertObject(hippo1)) {
                    System.out.println("������� ������ ������� �������� � �������.");
                }
            } catch (Exception e) {
                System.out.println("������ ��� ������� �������� �������: " + e.getMessage());
            }

            try {
                if (ObjectInserter.insertObject(hippo2)) {
                    System.out.println("������� ����� ������� �������� � �������.");
                }
            } catch (Exception e) {
                System.out.println("������ ��� ������� �������� �����: " + e.getMessage());
            }

            try {
                if (ObjectInserter.insertObject(hippo3)) {
                    System.out.println("������� ����� ������� �������� � �������.");
                }
            } catch (Exception e) {
                System.out.println("������ ��� ������� �������� �����: " + e.getMessage());
            }

            try {
                TableCreator.createTable(Camel.class);
            } catch (Exception e) {
                System.out.println("������ ��� �������� ������� ��� ��������: " + e.getMessage());
            }

            Camel camel1 = new Camel(1, "���", HumpType.TWO_HUMPS);
            Camel camel2 = new Camel(2, "����", HumpType.ONE_HUMP);
            Camel camel3 = new Camel(3, "�����", HumpType.TWO_HUMPS);

            try {
                if (ObjectInserter.insertObject(camel1)) {
                    System.out.println("������� ��� ������� �������� � �������.");
                }
            } catch (Exception e) {
                System.out.println("������ ��� ������� �������� ����: " + e.getMessage());
            }

            try {
                if (ObjectInserter.insertObject(camel2)) {
                    System.out.println("������� ���� ������� �������� � �������.");
                }
            } catch (Exception e) {
                System.out.println("������ ��� ������� �������� ����: " + e.getMessage());
            }

            try {
                if (ObjectInserter.insertObject(camel3)) {
                    System.out.println("������� ����� ������� �������� � �������.");
                }
            } catch (Exception e) {
                System.out.println("������ ��� ������� �������� ������: " + e.getMessage());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


