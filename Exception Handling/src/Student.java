public class Student implements Comparable<Student> {
    private String name;
    private int average;
    public Student(String name, int average)
    {
        this.name = name;
        this.average = average;
    }
    public String getName()
    {
        return name;
    }
    public int getAverage()
    {
        return average;
    }
    public void setAverage(int average) throws IncorrectAverageException
    {
        if (average < 0) throw new IncorrectAverageException("IncorrectAverageException has been got! Negative number.");
        this.average = average;
    }
    @Override
    public String toString()
    {
        return "Name: " +name+ ", Average: " +average;
    }

    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.average, other.average);
    }
}