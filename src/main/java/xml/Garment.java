package xml;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * Created by diego.fustes on 14/08/2014.
 */
public class Garment {

    private String id;
    private String gender;
    private String category;
    private String name;


    public String getId() {
        return id;
    }

    @XmlAttribute
    public void setId(String id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    @XmlAttribute
    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCategory() {
        return category;
    }

    @XmlAttribute
    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    @XmlAttribute
    public void setName(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Garment)) return false;

        Garment garment = (Garment) o;

        if (!id.equals(garment.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Garment{" +
                "id='" + id + '\'' +
                ", gender='" + gender + '\'' +
                ", category='" + category + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
