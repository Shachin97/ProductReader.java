import java.util.Objects;

public class Product {
    private String IDNum;
    private String description;
    private double cost;
    private String name;
    static private int IDSeed = 1;

    public static void setIDSeed(int IDSeed) {
        Product.IDSeed = IDSeed;
    }

    public static int getIDSeed() {
        return IDSeed;
    }

    public Product(String IDNum, String name, String description, double cost) {
        this.IDNum = IDNum;
        this.description = description;
        this.cost = cost;
        this.name = name;
        
    }

    public Product(String name, String description, double cost) {
        this.description = description;
        this.cost = cost;
        this.name = name;
    }

    public String getIDNum() {
        return IDNum;
    }

    private String genIDNum() {
        String newID = " " + IDSeed;
        while (newID.length() < 8) {
            newID = "0" + newID;
        }
        IDSeed++;
        return newID;
    }


    public void setIDNum(String IDNum) {
        this.IDNum = IDNum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "IDNum='" + IDNum + '\'' +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                ", name='" + name + '\'' +
                '}';
    }


    public String toCSVDataRecord() {
        return IDNum + ", " + name + ", " + description + ", " + cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.cost, cost) == 0 && Objects.equals(IDNum, product.IDNum) && Objects.equals(description, product.description) && Objects.equals(name, product.name);
    }


    public String toJSONRecord()
    {
        String retString = "";
        char DQ = '\u0022';  // Assign the double quote char to a variable
        retString =  "{" + DQ + "IDNum" + DQ + ":" + DQ + this.IDNum + DQ + ",";
        retString += DQ + "Name" + DQ + ":" + DQ + this.name + DQ + ",";
        retString += " " + DQ + "Description"  + DQ + ":" + DQ + this.description + DQ + ",";
        retString += " " + DQ + "Cost"  + DQ + ":" + DQ + this.cost + DQ + ",";


        return retString;
    }
    public String toXMLRecord()
    {

        String retString = "";

        retString = "<Product>" + "<IDNum>" + this.IDNum + "</IDNum>";
        retString += "<Name>" + this.name + "</Name>";
        retString += "<Description>" + this.description + "</description>";
        retString += "<Cost>" + this.cost + "</title></Product>";

        return retString;
    }

}



