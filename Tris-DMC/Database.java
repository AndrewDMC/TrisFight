
import java.sql.*;
import java.util.*;

public class Database {

    String url = "jdbc:mysql://localhost:3306/Tris";

    String username = "root";

    String password = "";

    Connection conn = null;
    Statement stat;
    ResultSet result;

    String esito = "";
    String mosse = "";
    String dbMoves = "";

    Random rand = new Random();
    Scanner scanner = new Scanner(System.in);

    int value = 0;

    public Database() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception ex) {
            System.out.println("Error in loading driver");
        }

        try {

            conn = DriverManager.getConnection(url, username, password);

            if (conn != null)
                System.out.println("Database connected!");

        } catch (SQLException e) {

            throw new IllegalStateException("Cannot connect the database!", e);
        }

        try {

            stat = conn.createStatement();

        } catch (SQLException e) {

            throw new IllegalStateException("Cannot create Statement!", e);
        }

    }

    public void InsertToDB(String mosseDB, String esitoDB) {

        try {
            String myQuery = " INSERT INTO esperienza (mosse, esito) VALUES ('" + mosseDB + "','" + esitoDB + "')";
            stat.executeUpdate(myQuery);
            System.out.print("Dati registrati\n");
        } catch (SQLException e) {

            throw new IllegalStateException("Cannot create Statement!", e);
        }

    }

    public void WatchDB() {

        try {

            result = stat.executeQuery("SELECT * FROM ESPERIENZA");

            while (result.next()) {

                System.out.println("ID:" + result.getString(1) + " MOSSE:" + result.getString(2) + " ESITO:"
                        + result.getString(3));

            }

        } catch (SQLException e) {

            throw new IllegalStateException("Cannot execute query", e);
        }

    }

    public int InputAI(String SeqMosse) {
        try {
            System.out.println(SeqMosse);
            result = stat.executeQuery("SELECT * FROM esperienza WHERE mosse LIKE '" + SeqMosse
                    + "%' AND Esito = 'W' OR Esito = 'D' ORDER BY Esito = 'W' DESC");
            System.out.println(result);
            if (result.first()) {
                dbMoves = result.getString(2);
            }
            System.out.println("SUS" + dbMoves);
        }

        catch (SQLException e) {

            throw new IllegalStateException("Cannot execute query", e);

        }
        if (dbMoves != "") {
            try {

                value = Character.getNumericValue(dbMoves.charAt(SeqMosse.length()));

            } catch (Exception e) {

                System.out.println("Non riesco a trovare una mossa adatta. Motivo: " + e + "\n");

            }
        } else {
            System.out.println("\nNon so come procedere. Potresti aiutarmi?\n");
            value = scanner.nextInt();
        }

        return value;

    }

}
