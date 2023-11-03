import java.io.*;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;
public class PersonContainer {
    private String fileName;
    private List<Person> people;
    public PersonContainer(String fileName) {
        this.fileName = fileName;
        people = new ArrayList<>();
        LoadPeople();
    }
    private void SavePeople(){
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(people);
            oos.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")
    private void LoadPeople(){
        try {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            people = (List<Person>)ois.readObject();
            ois.close();
        } catch(FileNotFoundException ex) {

        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    public boolean Contains(Person obj){
        return people.contains(obj);
    }
    public void AddPerson(Person obj){
        if(!people.contains(obj)) {
            people.add(obj);
            SavePeople();
        }
    }
    /*public void LoadFromXMLFile(String xmlFileName) {
        try {
            FileInputStream fis = new FileInputStream(xmlFileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Person person = (Person) ois.readObject();
            AddPerson(person);
            ois.close();
        }catch(Exception ex) {
            ex.printStackTrace();
        }
    }*/
    public void LoadFromXMLFile(String xmlFileName) {
        try {
            File xmlFile = new File(xmlFileName);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("Person");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String name = element.getElementsByTagName("name").item(0).getTextContent();
                    String birthPlace = element.getElementsByTagName("birthPlace").item(0).getTextContent();
                    int birthYear = Integer.parseInt(element.getElementsByTagName("birthYear").item(0).getTextContent());

                    Person person = new Person(name, birthPlace, birthYear);
                    AddPerson(person);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}