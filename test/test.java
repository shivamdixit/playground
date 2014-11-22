import java.sql.*;

class test
{
    private static final String URL = "jdbc:mysql://localhost/test";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "om1234";

    public static void main(String[] args) {
        try {
            String sql = "SELECT * from weather";
            //Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Registered Successfully!");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int station = rs.getInt("station");
                String name = rs.getString("name");
                String state = rs.getString("state");
                System.out.print(station + " " + name + " " + state);
                System.out.println();
            }


            DatabaseMetaData d = conn.getMetaData();
            System.out.println(d.supportsBatchUpdates());

            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
