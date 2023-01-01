package com.example.experiment.testmethod;

import com.example.experiment.entity.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试List的各种API
 *
 * @author lltt9
 * @date 2022-12-28 20:58
 */
public class ListTest {
    public static void main(String[] args) {
        /**
         * List里的removeAll,retainAll方法  对应需要修改对象的equals和hashCode方法
         */

        List<Person> referList = new ArrayList<Person>();
        referList.add(new Person("1", "!2", "ai", "768"));
        referList.add(new Person("1", "56", "t", "90"));

        List<Person> nowList = new ArrayList<>();
        nowList.add(new Person("1", "56", "t", "123"));
        nowList.add(new Person("1", null, "ai", "5"));
        /**
         * 判断两个元素是否相等时，用Objects.equals方法替代equals方法
         */
        for (Person person : referList) {
            for (Person person1 : nowList) {
                if (person.getName().equals(person1.getName())) {
                    System.out.println("yes");
                }
            }
        }
        System.out.println(referList);

    }


}
