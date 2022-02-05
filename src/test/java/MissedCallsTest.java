import org.junit.jupiter.api.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class MissedCallsTest {
    MissedCalls sut;

    @BeforeEach
    public void startEach() {
        System.out.println("One test started");
        sut = new MissedCalls();
    }

    @BeforeAll
    public static void started() {
        System.out.println("Tests started");
    }

    @AfterEach
    public void finishEach() {
        System.out.println("One test finished");
    }

    @AfterAll
    public static void finished() {
        System.out.println("Tests finished");
    }

    @ParameterizedTest
    @ValueSource(strings = {"8945666222", "8945555333", "8945111245"})
    public void testAddMissedCalls(String calls) {
        //when
        int callsBefore = sut.getMissedCalls().size();
        sut.addMissedCalls(calls);
        int callsAfter = sut.getMissedCalls().size();
        //then
        assertNotEquals(callsBefore, callsAfter);
    }

    @Test
    public void testGetMissedCalls() {
        String missedCall = "89376664545";
        sut.missedCalls.put(LocalDateTime.now(), missedCall);
        //then
        assertEquals(sut.getMissedCalls().size(), 1);
    }


    @Test
    public void testClearCalls() {
        //given
        LocalDateTime time1 = LocalDateTime.now().minusSeconds(1);
        String missedCall1 = "89376664545";
        LocalDateTime time2 = LocalDateTime.now();
        String missedCall2 = "89376664466";
        sut.missedCalls.put(time1, missedCall1);
        sut.missedCalls.put(time2, missedCall2);

        //when
        assertEquals(sut.missedCalls.size(), 2);

        sut.clearCalls();

        //then
        assertEquals(sut.missedCalls.size(), 0);
    }
}
