public class Main {
    public static void main(String[] args) {
        PersonContainer container = new PersonContainer("people.ser");

        Person person1 = new Person("Alex", "Budapest", 2000);
        Person person2 = new Person("George", "New York", 1986);

        container.AddPerson(person1);
        container.AddPerson(person2);

        //Test Contains method
        System.out.println("Container contains person1: " + container.Contains(person1));
        System.out.println("Container contains person2: " + container.Contains(person2));

        //Test loading from XML file
        container.LoadFromXMLFile("person.xml");

        //Test contains method after loading from XML
        System.out.println("Container contains person1: " + container.Contains(person1));
    }
}