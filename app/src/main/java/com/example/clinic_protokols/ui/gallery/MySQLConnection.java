package com.example.clinic_protokols.ui.gallery;
import android.util.Log;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MySQLConnection {
    private static final String TAG = "MySQLConnection";
    private static final String URL = "jdbc:mysql://http://127.0.0.1/medOborudovanie";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public List<NewsItem> fetchNews() {
        List<NewsItem> newsList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM news");

            while (resultSet.next()) {
                String title = resultSet.getString("title");
                newsList.add(new NewsItem(title));
                Log.d(TAG, "Fetched news item: " + title);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return newsList;
    }
}
