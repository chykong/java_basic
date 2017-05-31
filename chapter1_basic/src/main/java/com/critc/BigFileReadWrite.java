package com.critc;

import java.io.*;
import java.util.Scanner;

/**
 * Created by 孔垂云 on 2017/6/1.
 */
public class BigFileReadWrite {
    /**
     * 读取大文件
     *
     * @param filePath
     */
    public void readFile(String filePath) {
        FileInputStream inputStream = null;
        Scanner sc = null;
        try {
            inputStream = new FileInputStream(filePath);
            sc = new Scanner(inputStream, "UTF-8");
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (sc != null) {
                sc.close();
            }
        }
    }

    /**
     * 读取文件
     *
     * @param filePath
     */
    public void readFile2(String filePath) {
        File file = new File(filePath);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file), 5 * 1024 * 1024);   //如果是读大文件，设置缓存
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                //进行操作.....
                System.out.println(tempString);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 写文件
     * @param filePath
     * @param fileContent
     */
    public void writeFile(String filePath, String fileContent) {
        File file = new File(filePath);
        // if file doesnt exists, then create it
        FileWriter fw = null;
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(fileContent);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        BigFileReadWrite file = new BigFileReadWrite();
        //file.readFile("D:\\test.txt");
        // file.readFile2("D:\\test.txt");

        file.writeFile("D:\\test2.txt", "测试写入");
    }
}
