package murach.data;

import java.io.*;
import java.util.*;
import murach.business.Product;

public class ProductIO {

    public static Product getProduct(String productCode, String filepath) {
        try {
            File file = new File(filepath);
            BufferedReader in = new BufferedReader(new FileReader(file));

            String line = in.readLine();
            while (line != null) {
                String[] columns = line.split("\\|");
                if (columns[0].equalsIgnoreCase(productCode)) {
                    String code = columns[0];
                    String description = columns[1];
                    double price = Double.parseDouble(columns[2]);

                    Product p = new Product();
                    p.setCode(code);
                    p.setDescription(description);
                    p.setPrice(price);
                    in.close();
                    return p;
                }
                line = in.readLine();
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Product> getProducts(String filepath) {
        List<Product> products = new ArrayList<>();
        try {
            File file = new File(filepath);
            BufferedReader in = new BufferedReader(new FileReader(file));

            String line = in.readLine();
            while (line != null) {
                String[] columns = line.split("\\|");
                if (columns.length >= 3) {
                    Product p = new Product();
                    p.setCode(columns[0]);
                    p.setDescription(columns[1]);
                    p.setPrice(Double.parseDouble(columns[2]));
                    products.add(p);
                }
                line = in.readLine();
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }
}
