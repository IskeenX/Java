import java.util.ArrayList;
import java.util.*;
import java.util.PriorityQueue;

public class Main
{
    public static void main(String[] args)
    {
        Student alex = new Student("Alex", 10);
        Student james  = new Student("James", 5);
        Student bob = new Student("Bob", 2);

        List<Student> students = new ArrayList();
        students.add(alex);
        students.add(james);
        students.add(bob);
        System.out.println("ArrayList");
        for(Student s : students) System.out.println("   " + s);

        PriorityQueue<Student> queue = new PriorityQueue();
        queue.add(alex);
        queue.add(james);
        queue.add(bob);
        System.out.println("Leading");
        System.out.println("   " + queue.peek());
        /*//Reverse the queue
        System.out.println("Before reversing - " + queue);
        Stack stack = new Stack();
        while(!queue.isEmpty()) {
            stack.add(queue.peek());
            queue.remove();
        }
        while (!stack.isEmpty()) {
            queue.add((Student) stack.peek());
            stack.pop();
        }
        System.out.println("After reversing - " + queue);*/

        TreeSet<Student> treeSet = new TreeSet();
        treeSet.addAll(students);
        System.out.println("TreeSet");
        for(Student p: treeSet){
            System.out.println("   " + p);
        }

        Student gabor = new Student("Gabor", 3);
        System.out.println("List of people which average is higher than " + gabor.getAverage());
        for (Student s : treeSet.tailSet(gabor)) {
            System.out.println("   " + s);
        }
    }
}