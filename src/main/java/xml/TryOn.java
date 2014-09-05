package xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * Created by diego.fustes on 03/09/2014.
 */
public class TryOn {

    private String begin;
    private String end;
    private List<Outfit> outfits;

    public String getBegin() {
        return begin;
    }

    @XmlAttribute
    public void setBegin(String begin) {
        this.begin = begin;
    }

    public String getEnd() {
        return end;
    }

    @XmlAttribute
    public void setEnd(String end) {
        this.end = end;
    }

    public List<Outfit> getOutfits() {
        return outfits;
    }

    @XmlElement(name = "outfit")
    public void setOutfits(List<Outfit> outfits) {
        this.outfits = outfits;
    }


}
