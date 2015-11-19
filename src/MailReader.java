
import java.sql.*;
import java.util.ArrayList;

public class MailReader {
    ArrayList<String> mails = new ArrayList<>();
    String bd = "";

    public MailReader(String bd) {
        this.bd = bd;
    }
    
    public ArrayList<String> execute() throws ClassNotFoundException, SQLException{
        Class.forName("org.sqlite.JDBC");
        Connection connection = DriverManager.getConnection("jdbc:sqlite:" + bd);
        Statement state = connection.createStatement();
        String query = "SELECT * FROM MAILS";
        ResultSet rs = state.executeQuery(query);
        
        while (rs.next()){
            mails.add(rs.getString("MAIL"));
        }
        rs.close();
        state.close();
        connection.close();
        return mails;
    }
}
