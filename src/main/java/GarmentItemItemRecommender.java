import org.apache.commons.math3.linear.*;
import xml.Browse;
import xml.Garment;
import xml.Outfit;

import java.util.List;

/**
 * Created by diego.fustes on 03/09/2014.
 */
public class GarmentItemItemRecommender {

    private List<Garment> garmentsDb;
    private SparseRealMatrix itemItemMatrix;

    public GarmentItemItemRecommender(List<Garment> garmentsDb) {
        this.garmentsDb = garmentsDb;
        this.itemItemMatrix = null;
    }

    private void updateItemItemMatrix(List<Garment> garmentPack, int amount) {

        if (garmentPack != null) {

            for (Garment garment1 : garmentPack) {
                for (Garment garment2 : garmentPack) {

                    if (!garment1.equals(garment2)) {
                        int pos1 = garmentsDb.indexOf(garment1);
                        int pos2 = garmentsDb.indexOf(garment2);

                        itemItemMatrix.addToEntry(pos1, pos2, amount);
                        itemItemMatrix.addToEntry(pos2, pos1, amount);

                    }
                }
            }
        }

    }

    public void buildItemItemMatrix(List<Browse> browses, List<Outfit> tryOnOutfits, List<Outfit> basketOutfits) {

        this.itemItemMatrix = new OpenMapRealMatrix(garmentsDb.size(), garmentsDb.size());

        for (Browse browse : browses) {
            List<Garment> garmentsPack = browse.getGarments();
            updateItemItemMatrix(garmentsPack, 1);
        }

        for (Outfit outfit : tryOnOutfits) {
            List<Garment> garmentsPack = outfit.getGarments();
            updateItemItemMatrix(garmentsPack, 2);
        }

        for (Outfit outfit : basketOutfits) {
            List<Garment> garmentsPack = outfit.getGarments();
            updateItemItemMatrix(garmentsPack, 3);
        }


    }

    private Garment getFirstRecommendation() {

        RealVector vector = new ArrayRealVector(itemItemMatrix.getRowDimension());
        for (int i = 0; i < itemItemMatrix.getRowDimension(); i++) {
            vector.setEntry(i, itemItemMatrix.getRowVector(i).getL1Norm());
        }

        return garmentsDb.get(vector.getMaxIndex());

    }

    private Garment getRecommendedItem(List<Garment> browsedItems) {

        RealVector realVector = new OpenMapRealVector(garmentsDb.size());

        for (Garment browsedItem : browsedItems) {

            int pos = garmentsDb.indexOf(browsedItem);
            realVector = realVector.add(itemItemMatrix.getRowVector(pos));

        }

        return garmentsDb.get(realVector.getMaxIndex());

    }

    public Garment recommendItem(List<Garment> browsedItems) {

        if (itemItemMatrix == null) {
            throw new UnsupportedOperationException("You mus call build browse matrix first!!!");
        }

        Garment recommendedGarment = null;

        if (browsedItems == null || browsedItems.isEmpty()) {
            return getFirstRecommendation();
        } else {
            return getRecommendedItem(browsedItems);
        }


    }
}
