package xml;

import xml.Outfit;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * Created by diego.fustes on 03/09/2014.
 */
public class Basket {

    private List<Outfit> outfits;

    public List<Outfit> getOutfits() {
        return outfits;
    }

    @XmlElement(name = "outfit")
    public void setOutfits(List<Outfit> outfits) {
        this.outfits = outfits;
    }
}
