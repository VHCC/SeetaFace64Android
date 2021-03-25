package com.seetatech.seetaverify.utils;

import android.content.Context;
import android.support.annotation.Nullable;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FileUtils {

    public static void copyFromAsset(Context context, String fileName, File dst, boolean overwrite) {
        if (!dst.exists() || overwrite) {
            try {
                //noinspection ResultOfMethodCallIgnored
                dst.createNewFile();
                InputStream in = context.getAssets().open(fileName);
                FileUtils.copyInStreamToFile(in, dst);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Nullable
    public static HashMap<String, String> readConfigFile(File file) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String buffer = null;
            HashMap<String, String> ret = new HashMap<>();
            while ((buffer = reader.readLine()) != null) {
                String[] kv = buffer.split("=");
                ret.put(kv[0], kv[1]);
            }
            return ret;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Nullable
    public static void putConfigFile(HashMap<String,String> hashMap, File configFile) {

        try {
            if ( !configFile.exists() ){
                configFile.createNewFile();
            }
            Iterator iterator = hashMap.entrySet().iterator();
            StringBuffer sb = new StringBuffer();
            while (iterator.hasNext()) {
                Map.Entry entry = (Map.Entry) iterator.next();
                String key = entry.getKey().toString().trim();
                String kv = key + "=" + hashMap.get(key);
                sb.append(kv.trim());
                sb.append("\n");
            }
            OutputStreamWriter write = new OutputStreamWriter(new FileOutputStream(configFile),"UTF-8");
            BufferedWriter writer=new BufferedWriter(write);
            writer.write(sb.toString());
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void copyInStreamToFile(InputStream in, File dst) throws IOException {
        FileOutputStream out = new FileOutputStream(dst);
        copyFile(in, out);
        in.close();
        out.flush();
        out.close();
    }

    private static void copyFile(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int read;
        while ((read = in.read(buffer)) != -1) {
            out.write(buffer, 0, read);
        }
    }
}
