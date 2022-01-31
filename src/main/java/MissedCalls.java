import java.time.LocalDateTime;
import java.util.Map;
import java.util.TreeMap;

public class MissedCalls {

    Map<LocalDateTime, String> missedCalls = new TreeMap<>();
    StringBuilder sb = new StringBuilder();

    public void addMissedCalls(String missedCall) {
        missedCalls.put(LocalDateTime.now(), missedCall);
    }

    public Map<LocalDateTime, String> getMissedCalls() {
        return missedCalls;
    }

    public String getMissedCallsString(Contacts contacts) {
        for (Map.Entry<LocalDateTime, String> entry : missedCalls.entrySet()) {
            Contact contact = contacts.searchContact(entry.getValue());
            sb.append(entry.getKey())
                    .append(" ")
                    .append(contact == null ? entry.getValue() : contact)
                    .append("\n");
        }
        return sb.toString();
    }

    public Map<LocalDateTime, String> clearCalls() {
        missedCalls.entrySet().clear();
        return missedCalls;
    }

}
