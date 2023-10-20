// ChocolateStore interface representing the target interface
interface ChocolateStore {
    void purchaseChocolate();
    void sellChocolate();
}

// LocalChocolateSeller class representing a local chocolate store
class LocalChocolateSeller {
    void buyLocalChocolate() {
        System.out.println("Buying local chocolate from the local store.");
    }

    void sellLocalChocolate() {
        System.out.println("Selling local chocolate to customers.");
    }
}

// OnlineChocolateSeller class representing an online chocolate store
class OnlineChocolateSeller {
    void orderChocolateOnline() {
        System.out.println("Ordering chocolate online from the website.");
    }

    void shipChocolate() {
        System.out.println("Shipping chocolate to customers.");
    }
}

// ChocolateStoreAdapter class to adapt LocalChocolateSeller to ChocolateStore
class ChocolateStoreAdapter implements ChocolateStore {
    private LocalChocolateSeller localSeller;

    ChocolateStoreAdapter(LocalChocolateSeller localSeller) {
        this.localSeller = localSeller;
    }

    @Override
    public void purchaseChocolate() {
        localSeller.buyLocalChocolate();
    }

    @Override
    public void sellChocolate() {
        localSeller.sellLocalChocolate();
    }
}

class ChocolateStoreExample {
    public static void main(String[] args) {
        // instances of local and online chocolate sellers
        LocalChocolateSeller localSeller = new LocalChocolateSeller();
        OnlineChocolateSeller onlineSeller = new OnlineChocolateSeller();

        //ChocolateStoreAdapter to adapt the local seller
        ChocolateStore localStore = new ChocolateStoreAdapter(localSeller);

        // Demonstrate purchasing and selling from both local and online stores
        System.out.println("Local Chocolate Store:");
        localStore.purchaseChocolate();
        localStore.sellChocolate();

        System.out.println("\nOnline Chocolate Store:");
        onlineSeller.orderChocolateOnline();
        onlineSeller.shipChocolate();
    }
}
