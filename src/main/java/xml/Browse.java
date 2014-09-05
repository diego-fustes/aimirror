package xml;


import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * Created by diego.fustes on 14/08/2014.
 */
public class Browse {

    private List<Garment> garments;

    public List<Garment> getGarments() {
        return garments;
    }

    @XmlElement(name="garment")
    public void setGarments(List<Garment> garments) {
        this.garments = garments;
    }


}
