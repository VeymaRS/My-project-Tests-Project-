import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


public class ContactsTest {
    Contacts sut;

    @BeforeEach
    public void startEach() {
        System.out.println("One test started");
        sut = new Contacts();
    }

    @AfterEach
    public void finishEach() {
        System.out.println("One test finished");
    }

    @BeforeAll
    public static void started() {
        System.out.println("Tests started");
    }

    @AfterAll
    public static void finished() {
        System.out.println("Tests finished");
    }

    @Test
    public void testAddContact() {
        Contact contact = new Contact("Ivan", "Ivanov", "8922755654", Group.WORK);

        sut.addContact(contact);

        assertEquals(sut.getContacts().size(), 1);
    }

    @Test
    public void testDellContact() {
        Contact contact1 = new Contact("Ivan", "Ivanov", "8922755654", Group.WORK);
        Contact contact2 = new Contact("Sergey", "Potapov", "8922441231", Group.WORK);
        sut.addContact(contact1);
        sut.addContact(contact2);

        sut.dellContact("Ivan", "Ivanov");

        assertFalse(sut.getContacts().containsValue(contact1));
    }
}
