package entity;

/**
 * @description:员工类
 * @Date: 2022-11-23-15--45
 * @author:A-Xiao
 **/
public class Person {
    private String name;  // 姓名
    private int salary; // 薪资

    private String sex; //性别
    private String area;  // 地区

    // 构造方法


    public String getSex() {
        return sex;
    }

    public Person setSex(String sex) {
        this.sex = sex;
        return this;
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public int getSalary() {
        return salary;
    }

    public Person setSalary(int salary) {
        this.salary = salary;
        return this;
    }



    public String getArea() {
        return area;
    }

    public Person setArea(String area) {
        this.area = area;
        return this;
    }

    public Person(String name, int salary, String sex, String area) {
        this.name = name;
        this.salary = salary;
        this.sex = sex;
        this.area = area;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Person{");
        sb.append("name='").append(name).append('\'');
        sb.append(", salary=").append(salary);
        sb.append(", sex='").append(sex).append('\'');
        sb.append(", area='").append(area).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
