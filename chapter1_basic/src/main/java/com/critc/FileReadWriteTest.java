package com.critc;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 孔垂云 on 2017/4/17.
 * 文件读写
 */
public class FileReadWriteTest {
    /**
     * 创建文件夹
     *
     * @throws Exception
     */
    public void createDir() throws Exception {
        String path = "D:" + File.separator + "dir";
        File file = new File("D:\\dir");
        if (!file.exists())
            file.mkdir();
    }

    /**
     * 创建文件
     *
     * @throws Exception
     */
    public void createFile() throws Exception {
        File file = new File("D:\\dir\\test.txt");
        if (!file.exists())
            file.createNewFile();
    }

    /**
     * 删除文件
     */
    public void deleteFile() {
        File file = new File("D:\\dir\\test.txt");
        file.deleteOnExit();
        if (file.exists())
            file.delete();
    }

    /**
     * 读取文件列表
     *
     * @return
     */
    public List<String> readFile() {
        String path = "D:\\dir\\test.txt";
        File file = new File(path);
        List<String> list = new ArrayList<String>();
        BufferedReader reader = null;
        try {
            if (file.exists()) {
                reader = new BufferedReader(new InputStreamReader(new FileInputStream(path), "GBK"));
                String tempString = null;
                while ((tempString = reader.readLine()) != null) {
                    list.add(tempString);
                }
                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return list;
    }

    /**
     * 写文件
     */
    public void writeFile() {
        String path = "D:\\dir\\test.txt";
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(path);
            OutputStreamWriter osw = new OutputStreamWriter(fileOutputStream, "GBK");
            String fileContent = "测试\r\n20160720\r\n";
            osw.write(fileContent);
            osw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        FileReadWriteTest fileReadWrite = new FileReadWriteTest();
        fileReadWrite.createDir();
        fileReadWrite.createFile();
//        fileReadWrite.deleteFile();

        fileReadWrite.writeFile();
        List<String> list = fileReadWrite.readFile();
        for (String str : list) {
            System.out.println("文件内容：" + str);
        }
    }
}
