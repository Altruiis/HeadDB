package tsp.headdb.database;

import tsp.headdb.HeadDB;
import tsp.headdb.api.HeadAPI;
import tsp.headdb.util.Log;

public class DatabaseUpdateTask implements Runnable {

    @Override
    public void run() {
        HeadDB.getInstance().getPlayerData().save();
        HeadAPI.getDatabase().updateAsync(heads -> Log.info("Fetched " + HeadAPI.getHeads().size() + " heads!"));
    }

}
