package murach.data;

import java.io.*;
import java.util.*;
import murach.business.User;

public class UserIO {

    public static void add(User user, String filename) {
        try {
            File file = new File(filename);
            PrintWriter out = new PrintWriter(new FileWriter(file, true));
            out.println(user.getEmail() + "|" + user.getFirstName() + "|" + user.getLastName());
            out.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static User getUser(String email, String filename) {
        try {
            BufferedReader in = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = in.readLine()) != null) {
                String[] columns = line.split("\\|");
                if (columns.length >= 3 && columns[0].equalsIgnoreCase(email)) {
                    in.close();
                    return new User(columns[0], columns[1], columns[2]);
                }
            }
            in.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        return null;
    }

    public static List<User> getUsers(String filename) {
        List<User> users = new ArrayList<>();
        try {
            BufferedReader in = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = in.readLine()) != null) {
                String[] columns = line.split("\\|");
                if (columns.length >= 3) {
                    users.add(new User(columns[0], columns[1], columns[2]));
                }
            }
            in.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        return users;
    }
}
