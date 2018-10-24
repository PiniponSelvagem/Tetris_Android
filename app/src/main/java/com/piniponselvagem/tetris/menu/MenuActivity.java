package com.piniponselvagem.tetris.menu;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.piniponselvagem.tetris.R;
import com.piniponselvagem.tetris.game.GameActivity;
import com.piniponselvagem.tetris.options.OptionsActivity;

import java.io.File;

public class MenuActivity extends AppCompatActivity {
    private static final String PLAYER_DATA = "player.dat";
    private static String playerName;
    private static String dataFileLocation;
    private OptionsActivity optionsActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        optionsActivity = new OptionsActivity();
        dataFileLocation = getFilesDir().getPath();
        getAppVersion();
        //isPlayerDataPresent();
    }

    public void startGame(View v) {
        Intent goToGameActivity = new Intent(getApplicationContext(), GameActivity.class);
        startActivity(goToGameActivity);
    }

    public void options(View v) {
        Intent goToOptionsActivity = new Intent(getApplicationContext(), OptionsActivity.class);
        startActivity(goToOptionsActivity);
    }

    public void highScores(View v) {
        //Intent goToHighScoresActivity = new Intent(getApplicationContext(), HighScoresActivity.class);
        //startActivity(goToHighScoresActivity);
    }

    private void getAppVersion() {
        TextView text = (TextView) findViewById(R.id.versionText);

        PackageInfo pInfo = null;
        try {
            pInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        if (pInfo != null) {
            String version = pInfo.versionName;
            text.append(' '+version);
        }
    }

    /*
    private void isPlayerDataPresent() {
        File file = this.getFileStreamPath(PLAYER_DATA);
        if(!file.exists()) {
            String player = getString(R.string.player);
            Log.i(this.getClass().getSimpleName(), "Player data not found. Creating new Player: "+player);
            optionsActivity.writePlayerData(player, dataFileLocation+'/'+PLAYER_DATA);
        }
        else optionsActivity.readPlayerData(dataFileLocation+'/'+PLAYER_DATA);
    }
    */

    public static void setPlayerName(String name) {
        playerName = name;
    }

    public static String getPlayerName() {
        return playerName;
    }

    public static String getDataFileFullPath() {
        return dataFileLocation;
    }

    public static String getPlayerDataFileName() {
        return PLAYER_DATA;
    }
}
