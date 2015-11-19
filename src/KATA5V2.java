import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class KATA5V2 {

    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        //String nameFile = "C:\\Users\\usuario\\Documents\\NetBeansProjects\\KATA5V2\\emailsfilev1.txt";    
        //ArrayList<String> mailArray = MailListReader.read(nameFile);
        ArrayList<String> mails = new MailReader("KATA.DB").execute();
        Histogram<String> histogram = MailHistogramBuilder.build(mails);
        new HistogramDisplay(histogram).exectute();
    }
}
