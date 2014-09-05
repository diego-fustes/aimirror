package xml;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * Created by diego.fustes on 14/08/2014.
 */
public class BrowsingSessions {

    private List<Browse> browses;

    public List<Browse> getBrowses() {
        return browses;
    }

    @XmlElement(name="browse")
    public void setBrowses(List<Browse> browses) {
        this.browses = browses;
    }
}
