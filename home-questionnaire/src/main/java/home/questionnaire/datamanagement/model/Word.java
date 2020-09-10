package home.questionnaire.datamanagement.model;

import com.google.common.base.Objects;

//@Entity
//@Table(name = "word")
public class Word {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(name = "cir_name")
    private String cir_name;

//    @Column(name = "latin_name")
    private String latin_name;

//    @ManyToOne(cascade = CascadeType.ALL)
    private Theme theme;

    public Word() {
    }

    public Word(String cir_name, String latin_name, Theme theme) {
        this.cir_name = cir_name;
        this.latin_name = latin_name;
        this.theme = theme;
    }

    public Word(String cir_name, String latin_name) {
        this.cir_name = cir_name;
        this.latin_name = latin_name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getCir_name() {
        return cir_name;
    }

    public void setCir_name(String cir_name) {
        this.cir_name = cir_name;
    }

    public String getLatin_name() {
        return latin_name;
    }

    public void setLatin_name(String latin_name) {
        this.latin_name = latin_name;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return Objects.equal(id, word.id) &&
                Objects.equal(cir_name, word.cir_name) &&
                Objects.equal(latin_name, word.latin_name) &&
                Objects.equal(theme, word.theme);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, cir_name, latin_name, theme);
    }

    @Override
    public String toString() {
        return "Word{" +
                "id=" + id +
                ", cir_name='" + cir_name + '\'' +
                ", latin_name='" + latin_name + '\'' +
                ", theme=" + theme.name +
                '}';
    }
}
