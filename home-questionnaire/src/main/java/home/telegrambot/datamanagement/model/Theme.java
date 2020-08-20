package home.telegrambot.datamanagement.model;//package com.morgen.model;


//@Entity
//@Table(name="theme")
public class Theme {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

//    @Column(name="name")
    String name;

    public Theme(String name) {
        this.name = name;
    }

    public Theme() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    //todo add equals and hashcode
    @Override
    public boolean equals(Object o) {
        return true;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String
    toString() {
        return "Theme{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
