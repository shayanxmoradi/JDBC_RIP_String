package sql;

import java.sql.*;
import java.util.Scanner;

public class Main {
    /**
     * @param args [0]-> password is set here
     * @throws SQLException
     */
    public static void main(String[] args) throws SQLException {
//config
        String url = "jdbc:postgresql://localhost:5432/hw7";
        String user = "postgres";
        String password = args[0].replace("password=", "");

        //  System.getenv("key");

        String query1 = """
                     SELECT *
                         FROM customer AS C
                     JOIN depositor d on C.customer_name = d.customer_name
                     join account a on a.account_number = d.account_number
                     WHERE NOT EXISTS (
                         SELECT 1
                         FROM borrower b
                         WHERE c.customer_name = b.customer_name
                     );
                          ;
                """;

//
        String query2 = """
                         SELECT c1.customer_name
                          FROM customer c1
                                   JOIN (
                              SELECT customer_street, customer_city
                              FROM customer
                              GROUP BY customer_street, customer_city
                              HAVING COUNT(*) > 1
                          ) c2
                                        ON c1.customer_street = c2.customer_street AND c1.customer_city = c2.customer_city;
                                
                """;
        try {
            Class.forName("org.postgresql.Driver");
            //or use
            //  DriverManager.registerDriver(new org.postgresql.Driver());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


        try (
                Connection conn = DriverManager.getConnection(url, user, password);
                Statement stmt = conn.createStatement();
                PreparedStatement pstmt = conn.prepareStatement(query1);
        ) {
            ResultSet rs = stmt.executeQuery(query1);

            while (rs.next()) {
                System.out.print(rs.getString(1) + ", ");
                System.out.print(rs.getString(2) + ", ");
                System.out.println(rs.getString(3));

            }
            rs.close();

            ResultSet rs2 = stmt.executeQuery(query2);
            System.out.println("query 2 : \n ");
            while (rs2.next()) {
                System.out.print(rs2.getString(1) + ", ");

            }
            rs2.close();
        }
    }
}
