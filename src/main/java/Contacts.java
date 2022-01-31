import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Contacts {
    private Map<String, Contact> contacts = new HashMap<>();

    public Map<String, Contact> getContacts() {
        return contacts;
    }

    public void addContact(Contact contact) {
        contacts.put(contact.getPhone(), contact);
        System.out.println("Контакт добавлен");
    }

    public void dellContact(String name, String surname) {
        boolean result = false;
        for (Iterator<Map.Entry<String, Contact>> i = contacts.entrySet().iterator(); i.hasNext(); ) {
            Map.Entry<String, Contact> e = i.next();
            Contact v = e.getValue();
            if (name.equals(v.getName()) & surname.equals(v.getSurname())) {
                i.remove();
                result = true;
            }
        }
        if (result) {
            System.out.println("Контакт удален");
        } else {
            System.out.println("Такого контакта нет");
        }
    }


    public Contact searchContact(String number) {
        return contacts.get(number);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, Contact> entry : contacts.entrySet()) {
            stringBuilder
                    .append("Номер телефона Имя Фамилия Группа\n")
                    .append(entry.getKey())
                    .append(" -> ")
                    .append(entry.getValue().toString())
                    .append("\n");
        }
        return stringBuilder.toString();
    }
}
