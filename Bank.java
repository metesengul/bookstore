package bookstore;

class Bank {
    static void checkOut(double cost){
        File.append("transactions.txt", UserData.currentUser.username + ", -$" + cost + "\n");
    }
}
