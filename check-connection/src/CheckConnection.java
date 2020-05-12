/*MIT License. create by Alisson Zubcov.*/

package org.godotengine.godot;

import android.app.Activity;
import com.godot.game.R;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.net.NetworkInfo;

public class CheckConnection extends Godot.SingletonBase {

    private Godot activity;

	static public Godot.SingletonBase initialize(Activity p_activity) {
		return new CheckConnection(p_activity);
	}
    public CheckConnection(Activity p_activity) {
        this.activity = (Godot) p_activity;
        registerClass("CheckConnection", new String[]{"isConnected"});
    }
	
	public boolean isConnected() {
        ConnectivityManager cm = (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnected())
            return true;
        else
            return false;
    }

}
