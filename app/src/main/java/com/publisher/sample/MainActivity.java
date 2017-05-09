package com.publisher.sample;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.vungle.publisher.VungleAdEventListener;
import com.vungle.publisher.VungleInitListener;
import com.vungle.publisher.VunglePub;

public class MainActivity extends AppCompatActivity {

    private final static String LOG_TAG = MainActivity.class.getSimpleName();
    final VunglePub vunglePub = VunglePub.getInstance();
    final String DEFAULT_PLACEMENT_ID = "DEFAULT33938";
    final String app_id = "58dd5e7b76c1fbc01700007c";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vunglePub.init(this, app_id, new String[]{DEFAULT_PLACEMENT_ID}, new VungleInitListener() {
            @Override
            public void onSuccess() {
                Log.d(LOG_TAG, "init success");
                vunglePub.addEventListeners(vungleDefaultListener);
                vunglePub.loadAd(DEFAULT_PLACEMENT_ID);
            }

            @Override
            public void onFailure(Throwable error) {
                Log.d(LOG_TAG, "init failure");
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private final VungleAdEventListener vungleDefaultListener = new VungleAdEventListener() {

        @Override
        public void onAdEnd(@NonNull String placementReferenceId, boolean wasSuccessFulView, boolean wasCallToActionClicked) {
            Log.d(LOG_TAG, "onAdEnd");
        }

        @Override
        public void onAdStart(@NonNull String placementReferenceId) {
            Log.d(LOG_TAG, "onAdStart");
        }

        @Override
        public void onUnableToPlayAd(@NonNull String placementReferenceId, String reason) {
            Log.d(LOG_TAG, "onUnableToPlayAd");
        }

        @Override
        public void onAdAvailabilityUpdate(@NonNull String placementReferenceId, boolean isAdAvailable) {
            Log.d(LOG_TAG, "onAdAvailabilityUpdate : " + isAdAvailable);
            if(isAdAvailable && DEFAULT_PLACEMENT_ID.equals(placementReferenceId) &&
                    vunglePub.isAdPlayable(DEFAULT_PLACEMENT_ID)) {
                Log.d(LOG_TAG, "ready to play Ad");
                vunglePub.playAd(DEFAULT_PLACEMENT_ID, null);
            }
        }
    };
}
