import java.util.Objects;

public class Archive {
    private String indentifier;
    private String name;

    public Archive(String indentifier, String name){
        this.indentifier = indentifier;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Archive archive = (Archive) o;
        return Objects.equals(indentifier, archive.indentifier);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(indentifier);
    }

    public String toString(){
        return indentifier + ": " + name;
    }
}
