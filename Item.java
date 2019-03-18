package bookstore;

abstract class Item implements Description, Dealer, Currency{

    String name;
    double cost;

    String description;
    String color;
    String size;
    String weight;

    String companyName;
    String companyAddress;
    String companyWebsite;
    String companyNumber;

    public Item(String name,
                double cost,
                String description,
                String color,
                String size,
                String weight,
                String companyName,
                String companyAddress,
                String companyWebsite,
                String companyNumber) {
        this.name = name;
        this.cost = cost;
        this.description = description;
        this.color = color;
        this.size = size;
        this.weight = weight;
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.companyWebsite = companyWebsite;
        this.companyNumber = companyNumber;
    }


    // Constructor Overloading
    Item(String name, double cost){
        this(name, cost, "none", "none", "none", "none", "none", "none", "none", "none");
    }

    @Override
    public double toEuro() {
        return this.cost * 0.88;
    }

    @Override
    public double toTurkishLira() {
        return this.cost * 5.37;
    }

    @Override
    public double toJapaneseYen() {
        return this.cost * 113.37;
    }

    @Override
    public String description() {
        return this.description;
    }

    @Override
    public String color() {
        return this.color;
    }

    @Override
    public String size() {
        return this.size;
    }

    @Override
    public String weight() {
        return this.weight;
    }

    @Override
    public String companyAddress() {
        return this.companyAddress;
    }

    @Override
    public String companyNumber() {
        return this.companyNumber;
    }

    @Override
    public String companyName() {
        return this.companyName;
    }

    @Override
    public String companyWebsite() {
        return this.companyWebsite;
    }
}
