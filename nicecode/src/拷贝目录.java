

import java.io.*;

public class 拷贝目录{
    public static void main(String[] args) {
        //拷贝源
        File srcFile = new File("C:\\Test");
        //拷贝目标
        File destFile = new File("D:\\Test\\");
        //调用方法拷贝
        copyDir(srcFile, destFile);

    }

    /**
     * 拷贝目录
     * @param srcFile 拷贝源
     * @param destFile 拷贝目标
     */
    private static void copyDir(File srcFile, File destFile) {
        //如果srcFile 是个文件的话，递归结束
        if (srcFile.isFile()){
            FileInputStream in = null;
            FileOutputStream out = null;
            try {
                //读这个文件
                in = new FileInputStream(srcFile);
                //写到这个文件中
                String path  = destFile.getAbsolutePath().endsWith("\\")?destFile.getAbsolutePath():destFile.getAbsolutePath()+"\\"+srcFile.getAbsolutePath().substring(3);
                System.out.println(path);
                out = new FileOutputStream(path);
                byte[] bytes = new byte[1024 * 1024];
                int readCount = 0;
                while ((readCount = in.read(bytes)) != -1){
                    out.write(bytes,0,readCount);
                }

                out.flush();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (out != null) {
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }


            return;
        }
        //获取源下面的子目录
        File[] files = srcFile.listFiles();
        for (File file : files) {
            //如果是目录就新建新目录
            if (file.isDirectory()){
                //源目录
                String srcDir = file.getAbsolutePath();
                //目标目录
                String destDir = destFile.getAbsolutePath().endsWith("\\")?destFile.getAbsolutePath():destFile.getAbsolutePath()+"\\"+srcDir.substring(3);

                File newFile = new File(destDir);
                if (!newFile.exists()){
                    newFile.mkdirs();
                }
            }


            //递归调用
            copyDir(file , destFile);
        }
    }


}