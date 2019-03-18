// 1306170018
// Mustafa Mete Şengül

package bookstore;
import java.util.Scanner;


public class BookStore {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        UserData.update();
        BookData.update();

        while(true){
            if (UserData.loggedIn){
                System.out.print("--- Menu ---\n" +
                        "[1] Logout\n" +
                        "[2] Show Cart\n" +
                        "[3] Show Books\n" +
                        "[0] Exit\n" +
                        "Please enter your choice: ");
                int input = scanner.nextInt();
                System.out.print("\n");

                switch (input){
                    case 1: Menu.logout();
                        break;
                    case 2: Menu.showCart();
                        break;
                    case 3: Menu.showBooks();
                        break;
                    default:
                        break;
                }

                if (input == 0){
                    break;
                }
            }
            else{
                System.out.print("--- Menu ---\n" +
                        "[1] Login\n" +
                        "[2] Register\n" +
                        "[3] Show Books\n" +
                        "[0] Exit\n" +
                        "Please enter your choice: ");
                int input = scanner.nextInt();
                System.out.print("\n");

                switch (input){
                    case 1: Menu.login();
                        break;
                    case 2: Menu.register();
                        break;
                    case 3: Menu.showBooks();
                        break;
                    default:
                        break;
                }

                if (input == 0){
                    break;
                }
            }
        }
    }
}
