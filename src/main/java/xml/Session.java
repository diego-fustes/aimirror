package xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by diego.fustes on 14/08/2014.
 */
@XmlRootElement(name = "session")
public class Session {

    private BrowsingSessions browsingSessions;
    private TryOnSessions tryOnSessions;
    private Basket basket;


    public BrowsingSessions getBrowsingSessions() {
        return browsingSessions;
    }

    @XmlElement(name = "browsing_sessions")
    public void setBrowsingSessions(BrowsingSessions browsingSessions) {
        this.browsingSessions = browsingSessions;
    }

    public TryOnSessions getTryOnSessions() {
        return tryOnSessions;
    }

    @XmlElement(name = "try_on_sessions")
    public void setTryOnSessions(TryOnSessions tryOnSessions) {
        this.tryOnSessions = tryOnSessions;
    }

    public Basket getBasket() {
        return basket;
    }

    @XmlElement(name = "basket")
    public void setBasket(Basket basket) {
        this.basket = basket;
    }
}
