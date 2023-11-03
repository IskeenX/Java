import java.io.PrintWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Person alex = new Person(12, "Alex");
        Person tamas = new Person(32, "Tamas");
        Person larry = new Person(15, "Larry");
        Person ron = new Person(45, "Ron");

        List<Person> aList = new ArrayList<>();
        aList.add(alex);
        aList.add(larry);
        aList.add(tamas);

        System.out.println("Before adding Ron");
        for (Person p: aList) {
            System.out.println("   " + p.getName());
        }
        aList.add(1, ron);
        System.out.println("After adding Ron");
        for (Person p: aList) {
            System.out.println("   " + p.getName());
        }
        aList.set(2, alex);
        System.out.println(aList.get(2));

        List<Person> secondList = Arrays.asList(alex, larry, tamas);
        System.out.println("Size of secondList: " + secondList.size());
        //secondList.add(ron);

        PriorityQueue<Person> queue = new PriorityQueue();
        queue.add(tamas);
        queue.add(alex);
        queue.add(ron);

        System.out.println(queue.peek());
        queue.peek().setAge(82);
        queue.add(queue.poll());
        System.out.println(queue.peek());

        while(!queue.isEmpty()) {
            Person p = queue.poll();
            System.out.println(p);
        }

        LinkedList<Person> linked = new LinkedList();
        linked.add(ron);
        linked.add(larry);
        linked.add(alex);

        for (Person p : linked) {
            System.out.println(p);
        }

        TreeSet<Person> aTree = new TreeSet();
        aTree.add(alex);
        aTree.add(tamas);
        aTree.add(larry);

        System.out.println("The content of our tree");
        for (Person p : aTree) {
            System.out.println("   " + p);
        }

        Person gabor = new Person(25, "Gabor");
        System.out.println("The person who is younger than " + gabor.getName());
        System.out.println("   " + aTree.lower(gabor));
        System.out.println("The person who is older than " + gabor.getName());
        System.out.println("   " + aTree.higher(gabor));

        System.out.println("The list of people older than " + gabor.getName());
        for (Person p : aTree.tailSet(gabor)) {
            System.out.println("   " + p);
        }
    }
}