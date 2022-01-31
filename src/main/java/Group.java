public enum Group {
    WORK("Работа"),
    FRIENDS("Друзья"),
    FAMILY("Семья");

    Group(String s) {

    }

public void printValue () {
        for (Group names : Group.values()) {
            System.out.println(names);
        }
}

}
