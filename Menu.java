package bookstore;


import java.util.Scanner;

class Menu{

    static void register(){
        System.out.print("--- Register ---\n" +
                "Please enter an username: ");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        System.out.print("Please enter a password: ");
        String password = scanner.nextLine();

        boolean userExists = false;
        for(int i = 0; i < UserData.userAmount; i++){
            if(UserData.users[i].username.equals(username)){
                userExists = true;
            }
        }

        if(userExists){
            System.out.print("\n--- Pop Up ---\nUser already exists.\n\n");
            return;
        }
        UserData.addUser(username, password);
        System.out.print("\n--- Pop Up ---\nUser saved, please login.\n\n");
    }

    static void login(){
        System.out.print("--- Login ---\n" +
                "Please enter your username: ");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();

        System.out.print("Please enter your password: ");
        String password = scanner.nextLine();

        for(int i = 0; i<UserData.userAmount; i++){
            if (username.equals(UserData.users[i].username)){
                if (password.equals(UserData.users[i].password))
                {
                    UserData.currentUser = UserData.users[i];
                    UserData.loggedIn = true;
                    System.out.print("\n--- Pop Up ---\nLogged in as " + username + ".\n\n");
                    return;
                }
                else{
                    System.out.print("\n--- Pop Up ---\nIncorrect password.\n\n");
                    return;
                }
            }
        }
        System.out.print("\n--- Pop Up ---\nUser not found.\n\n");
    }

    static void logout(){
        UserData.loggedIn = false;
        Cart.clearCart();
        System.out.print("\n--- Pop Up ---\nLogged out.\n\n");
    }

    static void showBooks(){

        Scanner scanner = new Scanner(System.in);

        while(true){

            System.out.print("--- Books ---\n");
            for(int i = 0; i < BookData.bookAmount; i++){
                System.out.print("[" + (i+1) +"] " + BookData.books[i].name + "\n");
            }
            System.out.print("[0] Return\nPlease enter your choice: ");

            int input = scanner.nextInt();
            System.out.print("\n\n");

            if (input == 0){
                return;
            }

            System.out.print("--- Book ---\n");
            Book b = BookData.books[input-1];
            System.out.print("Name: " + b.name + "\nAuthor: " + b.author + "\nCost: " + b.cost + "$\n" +
                    "[1] Add to cart.\n" +
                    "[0] Return\nPlease enter your choice: ");
            input = scanner.nextInt();
            if (input == 1){
                if (!UserData.loggedIn){
                    System.out.print("\n--- Pop Up ---\nYou have to login before adding an item to cart.\n\n");
                    continue;
                }
                // Polymorphism: Book objects are stored in an Item array,
                // Item is the parent class of Book.
                // Item array will be used in other parts of the program. (e.g. in "showCart()" function)
                Cart.addToCart(b);
                System.out.print("\n--- Pop Up ---\n" + b.name + " added to cart.");
            }
            System.out.print("\n\n");
        }

    }

    static void showCart(){
        System.out.print("--- Cart ---\n");
        double totalCost = 0;
        for(int i = 0; i < Cart.cartAmount; i++){
            System.out.print(Cart.cart[i].name + ": $" + Cart.cart[i].cost + "\n");
            totalCost += Cart.cart[i].cost;
        }

        if (Cart.cartAmount == 0){
            System.out.print("Cart is empty.\n\n");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Total cost is $" + totalCost + "\n" +
                "[1] Checkout\n" +
                "[2] Clear\n" +
                "[0] Return\nPlease enter your choice: ");
        int input = scanner.nextInt();
        if (input == 1){
            Bank.checkOut(totalCost);
            Shipping.order();
            Cart.clearCart();
            System.out.print("\n--- Pop Up ---\nTransaction complete, order sent.\n");
        }
        else if (input == 2){
            Cart.clearCart();
            System.out.print("\n--- Pop Up ---\nCart cleared.\n");
        }
        System.out.print("\n");
    }

}

