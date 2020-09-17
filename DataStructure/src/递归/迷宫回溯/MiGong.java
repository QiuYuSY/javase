package 递归.迷宫回溯;

public class MiGong {
    public static void main(String[] args) {
        int[][] map = new int[8][7];

        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
            map[i][0] = 1;
            map[i][6] = 1;
        }

        map[3][1] = 1;
        map[3][2] = 1;
        map[1][2] = 1;
        map[2][2] = 1;


        System.out.println(setWay(map,1,1));

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j]+"\t");
            }
            System.out.println();
        }
    }

    //用递归会回溯来给小球找路
    //i,j表示从地图那个位置开始出发
    //如果小球能到map[6][5]说明找到
    //0为没走过的路 1为墙 2表示通路可以走 3为已走过但是走不通
    /**
     *
     * @param map 代表地图
     * @param i 开始位置
     * @param j 开始位置
     * @return 找到返回ture否则false
     */
    public static boolean setWay(int[][] map, int i, int j){
        if (map[6][5] == 2){//已经找到
            return true;
        }else {
            if (map[i][j] == 0){//没走过
                //假定可以走
                map[i][j] = 2;
                if (setWay(map,i,j-1)){
                    return true;
                }else if (setWay(map,i+1,j)){
                    return true;
                }else if (setWay(map,i,j+1)){
                    return true;
                }else if (setWay(map,i-1,j)){
                    return true;
                }else {
                    map[i][j] = 3;
                    return false;
                }
            }else {//可能性：1是墙不能走，2走过了，3错误的
                return false;
            }

        }
    }

}
