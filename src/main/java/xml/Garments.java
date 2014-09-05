package xml;



import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by diego.fustes on 14/08/2014.
 */
@XmlRootElement(name = "garments")
public class Garments {

    private List<Garment> garments;


    public List<Garment> getGarments() {
        return garments;
    }

    @XmlElement(name="garment")
    public void setGarments(List<Garment> garments) {
        this.garments = garments;
    }
}
