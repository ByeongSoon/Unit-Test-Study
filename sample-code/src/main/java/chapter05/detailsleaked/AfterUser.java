package chapter05.detailsleaked;

public class AfterUser {

    private String _name;
    public String name;

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        this._name = normalizeName(name);
    }

    private String normalizeName(String name) {
        String result = (name == null ? "" : name).trim();

        if (result.length() > 50) {
            return result.substring(0,50);
        }

        return result;
    }
}
