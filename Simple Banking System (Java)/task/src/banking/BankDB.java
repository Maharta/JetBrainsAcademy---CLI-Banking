package banking;

import org.sqlite.SQLiteDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BankDB {
    private static String url;

    private static Connection connect() {
        SQLiteDataSource dataSource = new SQLiteDataSource();
        dataSource.setUrl(url);
        Connection con = null;
        try {
            con = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return con;
    }

    public static void createOrConnectToDBFile() {
        try (Connection ignored = connect()) {
            System.out.println("Database Connection Success!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void createCardTableIfNotExist() {

        String sql = "CREATE TABLE IF NOT EXISTS card("
                + "id INTEGER PRIMARY KEY, "
                + "number TEXT type UNIQUE, "
                + "PIN TEXT, "
                + "balance INTEGER DEFAULT 0"
                + ");";

        try (Connection con = connect();
             Statement statement = con.createStatement()) {

            statement.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int addNewCard(Card card) {
        String sql = "INSERT INTO card (number, PIN) "
                + "VALUES (" + card.getNumber() + ", " +
                "'" + card.getPIN() + "');";


        try (Connection con = connect();
             Statement statement = con.createStatement()) {

            return statement.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static Card getRequestedNumber(String number, String PIN) {
        String sql = "SELECT * FROM card WHERE number = " + number;

        try (Connection con = connect();
             Statement statement = con.createStatement()) {

            ResultSet rs = statement.executeQuery(sql);
            if (!rs.next()) {
                return null;
            }
            String numberFromDB = rs.getString("number");
            String actualPIN = rs.getString("PIN");

            if (!PIN.equals(actualPIN)) {
                return null;
            }

            int balance = rs.getInt("balance");

            return new Card(numberFromDB, actualPIN, balance);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public static void setUrl(String url) {
        BankDB.url = url;
    }


}
