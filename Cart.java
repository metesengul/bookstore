package bookstore;

// This class is for interacting with the shopping cart of current user.
public class Cart {
    static Item[] cart = new Item[100];
    static int cartAmount = 0;

    static void addToCart(Item item){
        Cart.cart[Cart.cartAmount] = item;
        Cart.cartAmount++;
    }

    static void clearCart(){
        Cart.cartAmount = 0;
    }
}
