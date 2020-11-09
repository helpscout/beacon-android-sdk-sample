package net.helpscout.sample.beacon.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import timber.log.Timber;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;


public class Utils {

    /**
     * Create a log file to show how it's possible to prefil files in the Contact form
     */
    public static List<String> generateSampleLogFileUri(Context context) {
        List<String> uris = new ArrayList<>();

        try {
            File logAFile = new File(context.getFilesDir() + File.separator + "log_a.txt");
            logAFile.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(logAFile);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            outputStreamWriter.append("This is a sample log called log_a.txt");
            outputStreamWriter.close();
            fileOutputStream.close();
            uris.add(Uri.fromFile(logAFile).toString());
        } catch (IOException exception) {
            Timber.e(exception);
        }

        return uris;
    }

    /**
     * @return the Version name of the app
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
