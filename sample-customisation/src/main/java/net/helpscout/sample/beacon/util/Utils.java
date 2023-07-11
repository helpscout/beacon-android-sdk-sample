package net.helpscout.sample.beacon.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import timber.log.Timber;


public class Utils {

    /**
     * Create a dummy log file to show how it's possible to prefill files in the Contact form
     */
    public static List<String> generateSampleLogFileUri(Context context) {
        List<String> uris = new ArrayList<>();

        try {
            File logAFile = new File(context.getFilesDir(), "log_a.txt");
            if (logAFile.createNewFile()) {
                FileWriter fileWriter = new FileWriter(logAFile);
                fileWriter.write("This is a sample log called log_a.txt");
                fileWriter.close();

                uris.add(logAFile.toURI().toString());
            } else {
                Timber.e("Failed to create log file");
            }
        } catch (IOException exception) {
            Timber.e(exception);
        }

        return uris;
    }

    /**
     * Get the app's version name
     *
     * @return app's version name
     */
    public static String getAppVersion(Context context) {
        try {
            PackageInfo pInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return pInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
