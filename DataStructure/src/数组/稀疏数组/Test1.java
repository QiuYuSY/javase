package 数组.稀疏数组;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Test1 {
    public static void main(String[] args) throws IOException {
        //创建一个棋盘数组
        int[][] chessArray1 = new int[11][11];
        chessArray1[1][2] = 1;
        chessArray1[2][3] = 2;
        chessArray1[4][5] = 1;

        for (int[] row : chessArray1) {
            for (int data: row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        //得到不等于0的数的个数
        int sum = 0;
        for (int i = 0; i < chessArray1.length; i++) {
            for (int j = 0; j < chessArray1[i].length; j++) {
                if (chessArray1[i][j] != 0) sum++;
            }
        }

        //将数组边为稀疏数组
        int[][] sparseArray = new int[sum+1][3];
        sparseArray[0][0] = chessArray1.length;
        sparseArray[0][1] = chessArray1[0].length;
        sparseArray[0][2] = sum;
        int index = 1;
        for (int i = 0; i < chessArray1.length; i++) {
            for (int j = 0; j < chessArray1[i].length; j++) {
                if (chessArray1[i][j] != 0 ){
                    sparseArray[index][0] = i;
                    sparseArray[index][1] = j;
                    sparseArray[index][2] = chessArray1[i][j];
                    index++;
                }
            }

        }
        //把稀疏数组放到硬盘中
        FileWriter fw = null;
        try {
            fw = new FileWriter("123");
            for (int i = 0; i < sparseArray.length; i++) {
                for (int j = 0; j < sparseArray[i].length; j++) {
                    fw.write(sparseArray[i][j]+"\t");
                }
                fw.write("\n");
            }
            fw.flush();
        } catch (IOException e){
            e.printStackTrace();
        }finally {
            if (fw != null) {
                fw.close();
            }
        }

        //清空稀疏数组
        for (int i = 0; i < sparseArray.length;i++) {
            for (int j = 0; j < sparseArray[i].length; j++) {
                sparseArray[i][j] = 0;

            }

        }

        //从硬盘中取出
        BufferedReader in = null;
        in = new BufferedReader(new FileReader("123"));
        String line;
        int rowForBR = 0;

        while ((line = in.readLine()) != null) {
            String[] tlemp = line.split("\t");
            for (int i = 0; i < tlemp.length; i++) {
                sparseArray[rowForBR][i] = (Integer.parseInt(tlemp[i]));
            }
            rowForBR++;
        }


        //打印稀疏数组
        for (int i = 0; i < sparseArray.length; i++) {
            for (int j = 0; j < sparseArray[i].length; j++) {
                System.out.print(sparseArray[i][j]+"\t");
            }
            System.out.println();
        }

        //将稀疏数组变为棋盘数组
        int[][] chessArray2 = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i <= sum; i++) {
            chessArray2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        //打印
        for (int[] row : chessArray2) {
            for (int data: row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }


    }
}
