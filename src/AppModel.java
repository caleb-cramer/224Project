import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//USED CPSC 224 FROM GITHUB
public class AppModel {
    static final String DATABASE_NAME = "databaseDIVDR.db";
    static final String CONNECTION_URL = "jdbc:sqlite:databases/" + DATABASE_NAME;
    static final String TABLE_DIVDR = "tableDIVDR";
    static final String ID = "id";
    static final String USERNAME = "username";
    static final String LAST = "lastScore";
    static final String HIGH = "highScore";

    static List<Learner> nameList = new ArrayList<>();

    Connection connection;

    public AppModel() {
        getConnection();
        createContactsTable();
        getAllNamesList();
    }
    private void getConnection(){
        try {
            connection = DriverManager.getConnection(CONNECTION_URL);
            System.out.println("Successfully connected to the database");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createContactsTable(){
        String sqlCreate = "CREATE TABLE " + TABLE_DIVDR + "(" +
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                USERNAME + " TEXT, " +
                LAST + " REAL DEFAULT 0, " +
                HIGH + " REAL DEFAULT 0)";

        if (connection != null && !tableExists()) {
            try {
                Statement statement = connection.createStatement();
                statement.execute(sqlCreate);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean tableExists() {
        // http://www.java2s.com/Code/Java/Database-SQL-JDBC/Detectifatableexists.htm
        DatabaseMetaData md = null;
        boolean hasNext = false;
        try {
            md = connection.getMetaData();
            ResultSet rs = md.getTables(null, null, TABLE_DIVDR, null);
            hasNext = rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hasNext;
    }

    public void closeConnection() {
        // close the connection (just like a file we've opened)
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void getAllNamesList() {
        String sqlSelect = "SELECT * FROM " + TABLE_DIVDR;
        System.out.println(sqlSelect);
        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sqlSelect);
                while (resultSet.next()) {
                    String name = resultSet.getString(USERNAME);
                    double high = resultSet.getDouble(HIGH);
                    double last = resultSet.getDouble(LAST);
                    nameList.add(new Learner(name, high, last));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void insertLearner(Learner learner) {
        // INSERT INTO tableContacts VALUES(null, 'Spike the Bulldog',
        // '509-509-5095', '')
        String sqlInsert = "INSERT INTO " + TABLE_DIVDR + " VALUES(null, '" +
                learner.getUserName() + "', " +
                learner.getLastScore() + ", " +
                learner.getHighScore() + ")";
        System.out.println(sqlInsert);
        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                statement.execute(sqlInsert);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        nameList.add(learner);
    }

    public static Learner checkUsername(String un){
        for (Learner abc: nameList) {
            if((abc.getUserName()).equals(un)){
                return abc;
            }
        }
        return null;
    }

    public void deleteAll() {
        // DELETE FROM tableContacts
        String sqlDelete = "DELETE FROM " + TABLE_DIVDR;
        System.out.println(sqlDelete);
        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                statement.execute(sqlDelete);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void updateContact() {
        // update record with id to have new info stored in newContact
        // UPDATE tableContacts SET name='SPIKE', phoneNumber='208-208-2082' WHERE id=1
        //UPDATE tableDIVDR SET lastscore = 25.5, WHERE NAME = 'Caleb'
        String sqlUpdate = updateHighScore(CurrentUser.getCu());
        //System.out.println(sqlUpdate);
        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                statement.execute(sqlUpdate);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    private String updateHighScore(Learner currentUser){
        if (currentUser.getLastScore() >= currentUser.getHighScore()){
            currentUser.highScore = currentUser.lastScore;
            return "UPDATE " + TABLE_DIVDR + " SET " +
                    LAST + " = " + currentUser.getLastScore() +", " +
                    HIGH + " = " + currentUser.getHighScore() + " WHERE " +
                    USERNAME + " = '" + currentUser.getUserName() +"'";

        }
        else{
            return "UPDATE " + TABLE_DIVDR + " SET " +
                    LAST + " = " + currentUser.getLastScore() + " WHERE " +
                    USERNAME + " = '" + currentUser.getUserName() +"'";
        }

    }
}
