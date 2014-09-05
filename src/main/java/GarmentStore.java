import xml.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by diego.fustes on 03/09/2014.
 */
public class GarmentStore {

    public List<Browse> loadBrowses() throws JAXBException {

        List<Browse> totalBrowses = new ArrayList<Browse>();
        File usageDbFolder = new File("C:\\Users\\diego.fustes\\Documents\\aiStylist\\data\\statistics_actigraX_20131020");

        JAXBContext jaxbContextSession = JAXBContext.newInstance(Session.class);

        Unmarshaller jaxbUnmarshallerSession = jaxbContextSession.createUnmarshaller();

        for (File usageDbFile : usageDbFolder.listFiles()) {

            Session session = (Session) jaxbUnmarshallerSession.unmarshal(usageDbFile);

            BrowsingSessions browsingSessions = session.getBrowsingSessions();

            List<Browse> browses = browsingSessions.getBrowses();
            if (browses != null)
                totalBrowses.addAll(browses);

        }

        System.out.println("BROWSES SIZE: " + totalBrowses.size());

        return totalBrowses;
    }

    public List<Outfit> loadTryOnOutfits() throws JAXBException {

        List<Outfit> totalOutfits = new ArrayList<Outfit>();
        File usageDbFolder = new File("C:\\Users\\diego.fustes\\Documents\\aiStylist\\data\\statistics_actigraX_20131020");

        JAXBContext jaxbContextSession = JAXBContext.newInstance(Session.class);

        Unmarshaller jaxbUnmarshallerSession = jaxbContextSession.createUnmarshaller();

        for (File usageDbFile : usageDbFolder.listFiles()) {

            Session session = (Session) jaxbUnmarshallerSession.unmarshal(usageDbFile);

            TryOnSessions tryOnSessions = session.getTryOnSessions();

            if (tryOnSessions != null) {

                List<TryOn> tryOns = tryOnSessions.getTryOns();
                if (tryOns != null) {
                    for (TryOn tryOn : tryOns) {
                        if (tryOn.getOutfits() != null)
                            totalOutfits.addAll(tryOn.getOutfits());
                    }

                }

            }

        }

        System.out.println("TRY-ON OUTFITS SIZE: " + totalOutfits.size());

        return totalOutfits;
    }

    public List<Outfit> loadBasketOutfits() throws JAXBException {

        List<Outfit> totalOutfits = new ArrayList<Outfit>();
        File usageDbFolder = new File("C:\\Users\\diego.fustes\\Documents\\aiStylist\\data\\statistics_actigraX_20131020");

        JAXBContext jaxbContextSession = JAXBContext.newInstance(Session.class);

        Unmarshaller jaxbUnmarshallerSession = jaxbContextSession.createUnmarshaller();

        for (File usageDbFile : usageDbFolder.listFiles()) {

            Session session = (Session) jaxbUnmarshallerSession.unmarshal(usageDbFile);

            Basket basket = session.getBasket();

            if (basket != null) {


                if (basket.getOutfits() != null)
                    totalOutfits.addAll(basket.getOutfits());


            }

        }

        System.out.println("BASKET OUTFITS SIZE: " + totalOutfits.size());

        return totalOutfits;
    }

    public List<Garment> loadGarments() throws JAXBException {

        File garmentsDb = new File("C:\\Users\\diego.fustes\\Documents\\aiStylist\\data\\garment_db.xml");
        JAXBContext jaxbContextGarments = JAXBContext.newInstance(Garments.class);

        Unmarshaller jaxbUnmarshallerGarments = jaxbContextGarments.createUnmarshaller();

        Garments garmentRoot = (Garments) jaxbUnmarshallerGarments.unmarshal(garmentsDb);
        List<Garment> garments = garmentRoot.getGarments();

        File garmentsDbKids = new File("C:\\Users\\diego.fustes\\Documents\\aiStylist\\data\\garment_db_kids.xml");
        Garments garmentRootKids = (Garments) jaxbUnmarshallerGarments.unmarshal(garmentsDbKids);
        garments.addAll(garmentRootKids.getGarments());

        System.out.println("GARMENTS SIZE: " + garments.size());

        return garments;


    }

}
