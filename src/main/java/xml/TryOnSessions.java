package xml;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * Created by diego.fustes on 14/08/2014.
 */
public class TryOnSessions {

    private List<TryOn> tryOns;

    public List<TryOn> getTryOns() {
        return tryOns;
    }

    @XmlElement(name = "try_on")
    public void setTryOns(List<TryOn> tryOns) {
        this.tryOns = tryOns;
    }
}
