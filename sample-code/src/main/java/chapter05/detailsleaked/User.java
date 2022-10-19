package chapter05.detailsleaked;

public class User {

    public String name;

    public String normalizeName(String name) {
        String result = (name == null ? "" : name).trim();

        if (result.length() > 50) {
            return result.substring(0,50);
        }

        return result;
    }

}
