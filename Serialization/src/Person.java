import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.Objects;
@XmlRootElement
public class Person implements Serializable {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return year == person.year && Objects.equals(name, person.name) && Objects.equals(birthPlace, person.birthPlace);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, birthPlace, year);
    }
    @XmlElement(name = "Nickname")
    private String name;
    private transient String birthPlace;
    private int year;
    public Person(){}
    public Person(String name, String birthPlace, int year) {
        this.name = name;
        this.birthPlace = birthPlace;
        this.year = year;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public String getBirthPlace() {
        return birthPlace;
    }
    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Name: " + name + ", Place: " + birthPlace + ", Year: " + year;
    }
}