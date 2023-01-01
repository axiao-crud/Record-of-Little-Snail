package com.example.experiment.entity;

/**
 * @author lltt9
 * @date 2022-12-28 20:58
 */
public class Person {
    private String code;

    private String name;

    private String classification;

    private String price;

    public Person(String code, String name, String classification, String price) {
        this.code = code;
        this.name = name;
        this.classification = classification;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (code != null ? !code.equals(person.code) : person.code != null) return false;
        if (name != null ? !name.equals(person.name) : person.name != null) return false;
        return classification != null ? classification.equals(person.classification) : person.classification == null;
    }

    @Override
    public int hashCode() {
        int result = code != null ? code.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (classification != null ? classification.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", classification='" + classification + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }
}
