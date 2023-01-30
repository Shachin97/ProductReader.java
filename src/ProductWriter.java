import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class ProductWriter

{
    public static void main(String[] args) {

    ArrayList<Product> product0data = new ArrayList<>();
        ArrayList<String> lines = new ArrayList<>();

        Scanner in = new Scanner(System.in);
    String ID= "";
    String name = "";
    String description = "";
    double cost = 0;
    String CSV = "";

    File workingDirectory = new File(System.getProperty("user.dir"));
    Path file = Paths.get(workingDirectory.getPath() + "\\src\\ProductTestData.txt");
    boolean done = false;
    do
    {
        ID = SafeInput.getNonZeroLenString(in, "Enter the ID Number");
        name = SafeInput.getNonZeroLenString(in, "Enter the name");
        description = SafeInput.getNonZeroLenString(in, "Enter the description");
        cost = SafeInput.getDouble(in, "Enter the Cost");


        product0data.add(new Product(ID, name, description, cost));
        done = SafeInput.getYNConfirm(in, "Are you done entering");


    }
        while(!done);
        for(Product p:product0data)
        System.out.println(p.toCSVDataRecord());

        try
    {

        OutputStream out =
                new BufferedOutputStream(Files.newOutputStream(file, CREATE));
        BufferedWriter writer =
                new BufferedWriter(new OutputStreamWriter(out));



        for(Product rec : product0data)
        {
            writer.write(rec.toCSVDataRecord());

            writer.newLine();
        }
        writer.close();
        System.out.println("Data file written!");
    }
        catch (IOException e)
    {
        e.printStackTrace();
    }


}

}

