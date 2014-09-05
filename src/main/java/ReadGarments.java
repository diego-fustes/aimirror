import xml.Browse;
import xml.Garment;
import xml.Outfit;

import javax.xml.bind.JAXBException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by diego.fustes on 14/08/2014.
 */
public class ReadGarments {

    public static void main(String[] args) throws JAXBException {

        GarmentStore store = new GarmentStore();

        //Obtain Garments Database
        List<Garment> garmentsDb = store.loadGarments();

        //Obtain sessions data
        List<Browse> browses = store.loadBrowses();
        List<Outfit> tryOnOutfits = store.loadTryOnOutfits();
        List<Outfit> basketOutfits = store.loadBasketOutfits();

        //Create Browse Item-Item matrix
        GarmentItemItemRecommender recommender = new GarmentItemItemRecommender(garmentsDb);
        recommender.buildItemItemMatrix(browses, tryOnOutfits, basketOutfits);

        //Recommend garment
        List<Garment> browsedGarments = new ArrayList<Garment>();
        Garment browsedGarment1 = garmentsDb.get(38);

        System.out.println("Browsed garment: " + browsedGarment1);
        browsedGarments.add(browsedGarment1);

        Garment recommendedGarment = recommender.recommendItem(browsedGarments);
        System.out.println("Recommended garment: " + recommendedGarment);


    }


}
