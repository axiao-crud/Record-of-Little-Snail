import entity.Person;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @description:Stream_Learn
 * @Date: 2022-11-23-14--57
 * @author:A-Xiao
 **/

public class Stream_Learn {

    /**
     *   将list集合中姓张的元素过滤到一个新的集合中
     *
     *   然后将过滤出来的姓张的元素中，再过滤出来长度为3的元素，存储到一个新的集合中
     */
    @Test
    public void test1(){
        List<String> list1 = new ArrayList<>();
        list1.add("张老三");
        list1.add("张小三");
        list1.add("李四");
        list1.add("赵五");
        list1.add("张六");
        list1.add("王八");
        //张集合
        List<String> zhangList = list1.stream().filter(entity -> entity.startsWith("张")).collect(Collectors.toList());
        System.out.println("zhangList = " + zhangList);
        //
        List<String> collect = zhangList.stream().filter(o -> o.length() == 3).collect(Collectors.toList());
        System.out.println("collect = " + collect);
    }


    /**
     * Collection创建集合，List，Set，Map，Array
     */
    @Test
    public void test2(){
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();

        Set<String> set = new HashSet<>();
        Stream<String> stream1 = set.stream();

        Map<String,String> map = new HashMap<>();
        Stream<String> stream2 = map.keySet().stream();
        Stream<String> stream3 = map.values().stream();
        Stream<Map.Entry<String, String>> stream4 = map.entrySet().stream();


        String [] a = {"1","@","3","5"};
        Stream<String> a1 = Stream.of(a);

    }

    /**
     * 从员工集合中筛选出salary大于8000的员工，并放置到新的集合里。
     * 统计员工的最高薪资、平均薪资、薪资之和。
     * 将员工按薪资从高到低排序，同样薪资者年龄小者在前。
     * 将员工按性别分类，将员工按性别和地区分类，将员工按薪资是否高于8000分为两部分。
     */
    @Test
    public void test3(){
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, "male", "New York"));
        personList.add(new Person("Jack", 7000, "male", "Washington"));
        personList.add(new Person("Lily", 7800, "female", "Washington"));
        personList.add(new Person("Anni", 8200, "female", "New York"));
        personList.add(new Person("Owen", 9500, "male", "New York"));
        personList.add(new Person("Alisa", 7900, "female", "New York"));
        //salary大于8000的员工
        personList.stream().filter(entity->entity.getSalary()>8000).map(entity->entity.getName()).collect(Collectors.toList()).forEach(System.out::println);

        //最高薪资
        System.out.println(personList.stream().map(Person::getSalary).collect(Collectors.maxBy(Integer::compareTo)).get());

        //平均薪资
        System.out.println(personList.stream().collect(Collectors.averagingInt(Person::getSalary)));

        //薪资之和
        System.out.println(personList.stream().collect(Collectors.summingInt(Person::getSalary)));

        //员工按薪资从高到低排序，同样薪资者年龄小者在前。
        System.out.println(personList.stream().sorted(Comparator.comparing(Person::getSalary).reversed().thenComparing(Person::getArea))
                .map(Person::getName).collect(Collectors.toList()));

        //将员工按性别分类，将员工按性别和地区分类，将员工按薪资是否高于8000分为两部分。
        System.out.println(personList.stream().collect(Collectors.groupingBy(Person::getSex)));

        System.out.println(personList.stream().collect(Collectors.groupingBy(Person::getSex, Collectors.groupingBy(Person::getArea))));

        System.out.println(personList.stream().collect(Collectors.partitioningBy(person -> person.getSalary() > 8000)));
    }



}
