package com.example.sp.androiddevelopmentutils.utils;

import java.io.File;

/**
 * Created by SP on 2018/7/2.
 * 删除文件工具类
 */

public class DeleteFileUtils {
    public static void deleteFile(String path) {
        File file = new File(path);
        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
            }
            if (file.isDirectory()) {
                File files[] = file.listFiles();
                for (int i = 0; i < files.length; i++) {
                    files[i].delete();
                }
            }
        }
    }
}
