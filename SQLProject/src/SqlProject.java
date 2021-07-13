import java.sql.*;

public class SqlProject {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost/PROJECT?user=root&password=";
        try{
            Connection conn = DriverManager.getConnection(url);
            conn.setAutoCommit(false);
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            Statement stmt = conn.createStatement();

           //  Creating a database called Project

            stmt.executeUpdate("create database PROJECT");


            // Creating Tables

            stmt.executeUpdate("CREATE TABLE Product(prodId char(4), pName varchar(5), price float, primary key(prodId))");
            stmt.executeUpdate("CREATE TABLE Depot(depId char(2), addr VARCHAR(10), volume INTEGER , primary key(depId))");
            stmt.executeUpdate("CREATE TABLE Stock(prodId char(4), depId char(2), quantity INTEGER)");

            // Adding primary keys and foreign keys to stock table

            stmt.executeUpdate("ALTER TABLE Stock ADD CONSTRAINT Stock___fk FOREIGN KEY (depId) REFERENCES Depot (depId)");
            stmt.executeUpdate("ALTER TABLE Stock ADD CONSTRAINT Stock___fk2 FOREIGN KEY (prodId) REFERENCES Product (prodId)");
            stmt.executeUpdate("ALTER TABLE Stock ADD CONSTRAINT Stock_pk PRIMARY KEY (prodId, depId)");


           // Inserting items into tables


           stmt.executeUpdate("INSERT INTO Product VALUES('p1', 'tape', 2.5)");
           stmt.executeUpdate("INSERT INTO Product VALUES('p2', 'tv', 250)");
           stmt.executeUpdate("INSERT INTO Product VALUES('p3', 'vcr', 80)");


           stmt.executeUpdate("INSERT INTO Depot VALUES('d1', 'New York', 9000)");
           stmt.executeUpdate("INSERT INTO Depot VALUES('d2', 'Syracuse', 6000)");
           stmt.executeUpdate("INSERT INTO Depot VALUES('d4', 'New York', 2000)");

           stmt.executeUpdate("INSERT INTO Stock VALUES('p1', 'd1', 1000)");
           stmt.executeUpdate("INSERT INTO Stock VALUES('p1', 'd2', -100)");
           stmt.executeUpdate("INSERT INTO Stock VALUES('p1', 'd4', 1200)");
           stmt.executeUpdate("INSERT INTO Stock VALUES('p3', 'd1', 3000)");
           stmt.executeUpdate("INSERT INTO Stock VALUES('p3', 'd4', 2000)");
           stmt.executeUpdate("INSERT INTO Stock VALUES('p2', 'd4', 1500)");
           stmt.executeUpdate("INSERT INTO Stock VALUES('p2', 'd1', -400)");
           stmt.executeUpdate("INSERT INTO Stock VALUES('p2', 'd2', 2000)");

           // Adding product (p100,cd,5) in Product & (p100,d2,50) into stock

           stmt.executeUpdate("INSERT INTO Product VALUES('p100', 'cd', 5)");
           stmt.executeUpdate("INSERT INTO Stock VALUES('p100', 'd2', 50)");

           ResultSet depotSet = stmt.executeQuery("select * from Depot");

            System.out.println("Table Depot: ");
            System.out.println(" ");
            while(depotSet.next()){
                System.out.println(depotSet.getString("depId") + " | "
                        + depotSet.getString("addr") + " | " + depotSet.getInt("volume"));
            }

            System.out.println(" ");
            System.out.println(" ");

            ResultSet productSet = stmt.executeQuery("select * from Product");
            System.out.println("Table Product: ");
            System.out.println(" ");
            while(productSet.next()){
                System.out.println(productSet.getString("prodId") + " | "
                        + productSet.getString("pName") + " | " + productSet.getFloat("price"));
            }

            ResultSet stockSet = stmt.executeQuery("select * from Stock");

            System.out.println(" ");
            System.out.println(" ");

            System.out.println("Table Stock: ");
            System.out.println(" ");
            while(stockSet.next()){
                System.out.println(stockSet.getString("prodId") + " | "
                        + stockSet.getString("depId") + " | " + stockSet.getInt("quantity"));
            }
            depotSet.close();
            productSet.close();
            stockSet.close();
            conn.commit();
            conn.close();
            stmt.close();


        }catch (Exception e){
            e.printStackTrace(System.out);

        }
    }
}
