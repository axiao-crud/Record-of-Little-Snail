import entity.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * 并行流
 *
 * @author lltt9
 * @date 2022-12-11 13:27
 */
public class ParallelStream {

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, "male", "New York"));
        personList.add(new Person("Jack", 7000, "male", "Washington"));
        personList.add(new Person("Lily", 7800, "female", "Washington"));
        personList.add(new Person("Anni", 8200, "female", "New York"));
        personList.add(new Person("Owen", 9500, "male", "New York"));
        personList.add(new Person("Alisa", 7900, "female", "New York"));
        //串行流
        personList.parallelStream().forEach(person -> {
            System.out.println(person.getName());

        });
        //并行流
        personList.parallelStream().forEachOrdered(person -> {
            System.out.println(person.getName());
        });


    }
}
