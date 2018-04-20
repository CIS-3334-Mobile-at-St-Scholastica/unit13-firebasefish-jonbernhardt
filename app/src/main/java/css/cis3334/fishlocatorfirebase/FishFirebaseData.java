package css.cis3334.fishlocatorfirebase;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cssuser on 4/20/2017.
 */

public class FishFirebaseData {

    public static final String FishDataTag = "Fish Data";
    private DatabaseReference fishDatabase = open();

    public DatabaseReference open()  {
        // Get an instance of the database and a reference to the fish data in it
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("fish");
        return myRef;
    }

    public void close() {

    }

    public Fish createFish( String species, String weightInOz, String dateCaught) {           //Added String rating as a parameter
        // ---- Get a new database key for the vote
        String key = fishDatabase.push().getKey();
        // ---- set up the fish object
        Fish newFish = new Fish(key, species, weightInOz, dateCaught);

        // ---- write the vote to Firebase
        fishDatabase.child(key).setValue(newFish);
        return newFish;
    }

    public Fish createFish( String species, String weightInOz, String dateCaught, String locationLatitude, String locationLongitude) {           //Added String rating as a parameter
        // ---- Get a new database key for the vote
        String key = fishDatabase.push().getKey();
        // ---- set up the fish object
        Fish newFish = new Fish(key, species, weightInOz, dateCaught, locationLatitude, locationLongitude);

        // ---- write the vote to Firebase
        fishDatabase.child(key).setValue(newFish);
        return newFish;
    }

    public void deleteFish(Fish fish) {
        String key = fish.getKey();
        fishDatabase.child(key).removeValue();

    }

    public List<Fish> getAllFish(DataSnapshot dataSnapshot) {
        List<Fish> fishList = null;
        String key = "0";
        while (fishDatabase.child(key) != null){
            Fish fish = dataSnapshot.getValue(Fish.class);

        }
        return fishList;
    }

}
