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

//

//
//        Scanner sc = new Scanner(System.in);
//        System.out.println("enter the name of your student");
//        String name = sc.nextLine();
//        String query2 = """
//                select * from student
//                where name = ?
//                """;
//
//        String query3 = """
//                Update  student set name= ?
//                where id = 2
//                ;
//                """;
//
//
//        String query4 = """
//                Update  student set name= 'juli'
//                where id = 7
//                """;
//        PreparedStatement stmt1 = result.conn().prepareStatement(query4);
//
//        String query5 = """
//                Update  student set name= 'jalal'
//                where id = 5
//                """;
//
//
//        PreparedStatement stmt2 = result.conn().prepareStatement(query5);
//        try {
//            result.conn().setAutoCommit(false);
//            stmt1.execute();
//            stmt2.execute();
//            result.conn().commit();
//        } catch (SQLException e) {
//
//            //return to begging state
//
//            result.conn().rollback();
//
//        } finally {
//            //work in both try and catch senario
//            result.conn().setAutoCommit(true);
//        }
//
//        //  Statement stmt = conn.createStatement();
//        PreparedStatement stmt = result.conn().prepareStatement(query3);
//
//        stmt.setString(1, name);
//
//
//        //// this will be changed when we change our operation
//        stmt.execute();
//        int updatedVal = stmt.getUpdateCount();
//        //    ResultSet rs = stmt.executeQuery();
//        // ResultSet rs = stmt.executeQuery();
//
//        //int updatedVal = stmt.executeUpdate();
//        if (updatedVal == 0) {
//            System.out.println("student not exist");
//        } else System.out.println(updatedVal);
//
//
//
//
//
//
//
//
//       /* while (rs.next()) {
//
//
//            //boolean output show weather we have res or not
//
////         System.out.print(rs.getString("name")+",");
////            System.out.println(rs.getInt(2));
//            System.out.printf("""
//                    name: %s, id:%d
//                    """,rs.getString(1),rs.getInt(2) );
//        }*/
//        //rs.close();
//
//        stmt.close();
//        result.conn().close();
//        //using this will automatically call close on objects
//        //they should implemented close();
//        try (
//                Connection connx = DriverManager.getConnection(result.url(), result.user(), result.password());
//                PreparedStatement stmtx = connx.prepareStatement(query3);
//
//        ) {
//            //write all codes here
//
//        }
//
//    }
//
//    private record setDatabaseUp(String url, String user, String password, Connection conn) {
//    }
