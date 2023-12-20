package exercise01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GameDAO {

    public GameDAO() {}
    
    public int getGameId(Connection connection, String gameTitle) throws SQLException {
	    int gameId = 0;
	    String selectGameSql = "SELECT GAME_ID FROM GAME WHERE GAME_TITLE = ?";
	    try (PreparedStatement selectGameStatement = connection.prepareStatement(selectGameSql)) {
	        selectGameStatement.setString(1, gameTitle);
	        ResultSet resultSet = selectGameStatement.executeQuery();
	        if (resultSet.next()) {
	            gameId = resultSet.getInt("GAME_ID");
	        }
	    }
	    return gameId;
	}
	
	//method created to insert a new game into the table GAME
	public int insertGame(Connection connection, String gameTitle) throws SQLException {
	    int gameId = 0;
	    String insertGameSql = "INSERT INTO GAME (GAME_ID, GAME_TITLE) VALUES (GAME_SEQUENCE.nextval, ?)";
	    try (PreparedStatement insertGameStatement = connection.prepareStatement(insertGameSql, new String[]{"GAME_ID"})) {
	        insertGameStatement.setString(1, gameTitle);
	        insertGameStatement.executeUpdate();

	        // getting GAME_ID generated
	        ResultSet gameGeneratedKeys = insertGameStatement.getGeneratedKeys();
	        if (gameGeneratedKeys.next()) {
	            gameId = gameGeneratedKeys.getInt(1);
	        }
	    }
	    return gameId;
	}
}
