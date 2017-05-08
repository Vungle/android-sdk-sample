package com.publisher.sample;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.vungle.publisher.VungleEventListener;
import com.vungle.publisher.VungleInitListener;
import com.vungle.publisher.VunglePub;

public class MainActivity extends AppCompatActivity {

    private final static String LOG_TAG = MainActivity.class.getSimpleName();
    final VunglePub vunglePub = VunglePub.getInstance();
    final String DEFAULT_PLACEMENT_ID = "DEFAULT35839";
    final String app_id = "58f8f64fcf684f7f4b00002e";

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

    private final VungleEventListener vungleDefaultListener = new VungleEventListener() {

        @Override
        public void onAdEnd(@NonNull String placementReferenceId, boolean wasSuccessFulView, boolean wasCallToActionClicked) {

        }

        @Override
        public void onAdStart(@NonNull String placementReferenceId) {

        }

        @Override
        public void onUnableToPlayAd(@NonNull String placementReferenceId, String reason) {

        }

        @Override
        public void onAdAvailabilityUpdate(@NonNull String placementReferenceId, boolean isAdAvailable) {
            Log.d(LOG_TAG, "onAdAvailabilityUpdate");
            if(DEFAULT_PLACEMENT_ID.equals(placementReferenceId) &&
                    vunglePub.isAdPlayable(DEFAULT_PLACEMENT_ID)) {
                Log.d(LOG_TAG, "ready to play Ad");
                vunglePub.playAd(DEFAULT_PLACEMENT_ID, null);
            }
        }
    };
}
