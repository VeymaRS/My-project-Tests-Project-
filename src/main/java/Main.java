import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Contacts contacts = new Contacts();
        MissedCalls missedCalls = new MissedCalls();
        while (true) {
            System.out.println("""
                    Меню:
                    1. Добавить контакт;
                    2. Удалить контакт (по имени и фамилии);
                    3. Добавить пропущенный вызов;
                    4. Вывести все пропущенные вызовы;
                    5. Вывести все контакты;
                    6. Очистить пропущенные вызовы;
                    7. Выход""");
            int input = scanner.nextInt();
            if (input == 1) {
                System.out.println("Введите данные в формате 'Имя/Фамилия/Номер телефона'");
                String inputContact = scanner.next();
                String[] partsContact = inputContact.split("/");
                String nameContact = partsContact[0];
                String surnameContact = partsContact[1];
                String phoneNumber = partsContact[2];
                System.out.println("Выберите группу в которую требуется добавить контакт. Возможные варианты:");
                for (Group group : Group.values()) {
                    System.out.println(group.name());
                }
                String inputInsertGroup = scanner.next();
                String[] partsGroup = inputInsertGroup.split("/");
                for (Group group : Group.values()) {
                    for (String parts : partsGroup) {
                        if (parts.equals(group.name())) {
                            contacts.addContact(new Contact(nameContact, surnameContact, phoneNumber, group));
                        }
                    }
                }
            } else if (input == 2) {
                System.out.println("Введите имя и фамилию контакта для удаления через символ '/'");
                String inputContact = scanner.next();
                String[] partsContact = inputContact.split("/");
                String nameContact = partsContact[0];
                String surnameContact = partsContact[1];
                contacts.dellContact(nameContact, surnameContact);
            } else if (input == 3) {
                System.out.println("Введите номер пропущенного вызова");
                String missedCall = scanner.next();
                missedCalls.addMissedCalls(missedCall);
            } else if (input == 4) {
                System.out.print(missedCalls.getMissedCallsString(contacts));
            } else if (input == 5) {
                System.out.println(contacts);
            } else if (input == 6) {
                missedCalls.clearCalls();
            } else if (input == 7) {
                break;
            }
        }
        System.out.println(contacts);
    }
}



