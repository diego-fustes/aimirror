package xml;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * Created by diego.fustes on 03/09/2014.
 */
public class Outfit {

    private List<Garment> garments;

    public List<Garment> getGarments() {
        return garments;
    }

    @XmlElement(name="garment")
    public void setGarments(List<Garment> garments) {
        this.garments = garments;
    }
}
