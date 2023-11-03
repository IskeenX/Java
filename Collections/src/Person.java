public class Person  implements  Comparable {
    private int age;
    private String name;
    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }
    @Override
    public int compareTo(Object obj) {
        return Integer.compare(this.age, ((Person)obj).getAge());
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return "Name: " + name + ", age: " + age;
    }
}