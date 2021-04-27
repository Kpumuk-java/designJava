package model;


public class User {
    private String uuid;
    private String name;
    private int age;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User(String uuid, String name, int age) {
        this.uuid = uuid;
        this.name = name;
        this.age = age;
    }
}
