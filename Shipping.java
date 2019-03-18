package bookstore;

class Shipping {

    static void order(){
        String detail = UserData.currentUser.username;
        for (int i = 0; i < Cart.cartAmount; i++){
            detail = detail + ", " +  Cart.cart[i].name;
        }
        File.append("orders.txt", detail + "\n");
    }
}
