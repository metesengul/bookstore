package bookstore;

// This class is for interacting with the user file.
public class UserData extends Data{

    static User[] users = new User[100];
    static int userAmount = 0;

    static User currentUser;
    static boolean loggedIn = false;

    static void addUser(String username, String password){
        File.append("users.txt", username + ", " + password + "\n");
        UserData.update();
    }

    static void update(){
        String users[] = File.read("users.txt").split("\n");
        UserData.userAmount = users.length;
        for (int i = 0; i < users.length; i++){
            String[] user = users[i].split(", ");
            UserData.users[i] = new User(user[0], user[1]);
        }
    }

    @Override
    void showInformation() {
        System.out.println("User Data is being used.");
    }
}
