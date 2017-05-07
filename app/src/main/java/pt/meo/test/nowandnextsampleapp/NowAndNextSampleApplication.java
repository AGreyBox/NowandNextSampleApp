package pt.meo.test.nowandnextsampleapp;

import android.app.Application;

import java.io.File;

import timber.log.Timber;

/**
 * Created by dplopez on 07-05-2017.
 */

public class NowAndNextSampleApplication extends Application {
    private static NowAndNextSampleApplication applicationInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationInstance = this;
        initializeTimber();
    }

    // region Helper Methods
    public static NowAndNextSampleApplication getInstance() {
        return applicationInstance;
    }

    public static File getCacheDirectory() {
        return applicationInstance.getCacheDir();

    }

    private void initializeTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree() {
                // Add the line number to the tag
                @Override
                protected String createStackElementTag(StackTraceElement element) {
                    return String.format("[Line - %s] [Method - %s] [Class - %s]",
                            element.getLineNumber(),
                            element.getMethodName(),
                            super.createStackElementTag(element));
                }
            });
        }
    }
}
