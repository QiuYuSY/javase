import java.util.Scanner;

class 登录系统{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("请输入用户名，长度为（6-14位）");
        String username = s.next();
        System.out.println("请输入密码");
        String password = s.next();
        UserService u = new UserService();
        try {
            u.register(username,password);
            System.out.println("用户"+username+"已经成功登录");
        } catch (RegisterException e) {
            e.printStackTrace();
        }

    }
}

class UserService{

    public void register (String username,String password) throws RegisterException {
        if (username == null || username.length()>14 || username.length() < 6){
            throw new RegisterException("用户名不合法，长度必须在[6-14]之间");
        }
        if (password.length() == 0){
            throw new RegisterException("密码不能为空");
        }
    }
}

class RegisterException extends Exception{
    public RegisterException() {
    }

    public RegisterException(String message) {
        super(message);
    }
}