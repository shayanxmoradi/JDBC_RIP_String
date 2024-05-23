package sql;

import sql.util.ApplicitonProperties;

import java.sql.*;

public class JDBCApp {
    /**
     * @param args [0]-> password is set here
     * @throws SQLException
     */
    public static void main(String[] args) throws SQLException {
//config


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



        try (
                Connection conn = DriverManager.getConnection(ApplicitonProperties.url,
                        ApplicitonProperties.user, ApplicitonProperties.password);

                Statement stmt = conn.createStatement();
                PreparedStatement pstmt = conn.prepareStatement(query1);
        ) {
            ResultSet rs = stmt.executeQuery(query1);

            while (rs.next()) {
                System.out.print(rs.getString(1) + ", ");
                System.out.print(rs.getString(2) + ", ");
                System.out.println(rs.getString(3));

            }

             rs = stmt.executeQuery(query2);
            System.out.println("query 2 : \n ");
            while (rs.next()) {
                System.out.print(rs.getString(1) + ", ");

            }
            rs.close();
        }
    }
}
