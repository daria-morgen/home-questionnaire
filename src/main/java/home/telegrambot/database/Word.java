package home.telegrambot.database;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "word")
public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cir_name")
    private String cir_name;

    @Column(name = "latin_name")
    private String latin_name;

    @ManyToOne(cascade = CascadeType.ALL)
    private Theme theme;

    public Word() {
    }

    public Word(String cir_name, String answer, Theme theme) {
        this.cir_name = cir_name;
        this.latin_name = answer;
        this.theme = theme;
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
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Word other = (Word) obj;
        if (this.cir_name != other.cir_name) {
            return false;
        }
        if (!Objects.equals(this.cir_name, other.cir_name)) {
            return false;
        }
        if (!Objects.equals(this.theme, other.theme)) {
            return false;
        }
        return Objects.equals(this.id, other.id);

    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.cir_name);
        hash = 79 * hash + Objects.hashCode(this.latin_name);
        hash = 79 * hash+Objects.hashCode(this.theme);
        return hash;
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
