
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 用户登录系统 {
    public static void main(String[] args) {
        //初始化一个界面,得到用户输入的账户密码
        Map<String,String> userLoginInfo = initUI();
        //验证用户名和密码
        boolean loginSuccess = login(userLoginInfo);
        //最后输出结果
        System.out.println(loginSuccess?"登录成功":"登录失败");
    }

    /**
     * 用户登录
     * @param userLoginInfo 用户登录信息
     * @return 登录信息是否正确 正确返回true，错误返回false
     */
    private static boolean login(Map<String, String> userLoginInfo) {
        //JDBC代码
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs= null;

        try {
            // 1、注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 2、获取连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/xsr","root","13958797107");
            // 3、获取数据库操作对象
            stmt = conn.createStatement();
            // 4、执行sql语句
            //取出Map集合中用户输入的账户名和密码
            String inputName = userLoginInfo.get("loginName");
            String inputPwd = userLoginInfo.get("loginPwd");
            String sql = "select * from t_user where loginName = '"+inputName+"' and loginPwd = '"+inputPwd+"'";
            rs = stmt.executeQuery(sql);
            // 5、获取查询结果集
            if (rs.next() == true){
                return true;
            }
            // 6、释放资源
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        //账户密码不正确
        return false;
    }

    /**
     * 初始化用户界面，,得到用户输入的账户密码
     * @return 用户输入的用户名和密码等登录信息
     */
    private static Map<String, String> initUI() {
        Scanner s = new Scanner(System.in);

        System.out.println("请输入用户名");
        String loginName = s.nextLine();

        System.out.println("请输入密码");
        String loginPwd = s.nextLine();

        Map<String,String> userLoginInfo = new HashMap<>();
        userLoginInfo.put("loginName",loginName);
        userLoginInfo.put("loginPwd",loginPwd);

        return userLoginInfo;

    }


}
