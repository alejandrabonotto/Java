package exercise01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class PlayerAndGameDAO {
	
	private static final String INSERT_PLAYER_AND_GAME_SQL = "INSERT INTO PLAYERANDGAME (PLAYER_GAME_ID, GAME_ID, PLAYER_ID, PLAYING_DATE, SCORE) VALUES (PLAYERANDGAME_SEQUENCE.nextval, ?, ?, TO_DATE(?, 'YYYY-MM-DD'), ?)";
	private static final String SELECT_ALL_PLAYERSANDGAMES_SQL = "SELECT PLAYER_ID, FIRST_NAME, LAST_NAME, ADDRESS, POSTAL_CODE, PROVINCE, PHONE_NUMBER, GAME_TITLE, PLAYING_DATE, SCORE FROM PLAYER JOIN PLAYERANDGAME USING (PLAYER_ID) JOIN GAME USING (GAME_ID) ORDER BY FIRST_NAME, LAST_NAME";
	private static final String SELECT_PLAYERSANDGAMES_BY_ID_SQL = "SELECT PLAYER_ID, FIRST_NAME, LAST_NAME, ADDRESS, POSTAL_CODE, PROVINCE, PHONE_NUMBER, GAME_TITLE, PLAYING_DATE, SCORE FROM PLAYER JOIN PLAYERANDGAME USING (PLAYER_ID) JOIN GAME USING (GAME_ID) WHERE PLAYER_ID = ? ORDER BY FIRST_NAME, LAST_NAME";
	
	public PlayerAndGameDAO() {}
	
	public void createPlayerAndGame(Connection connection, int gameId, int playerId, String datePlayed, String score) {
		try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PLAYER_AND_GAME_SQL)) {
            preparedStatement.setInt(1, gameId);
            preparedStatement.setInt(2, playerId);
            preparedStatement.setString(3, datePlayed);
            preparedStatement.setString(4, score);

            preparedStatement.executeUpdate();
    
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
	
	public static List<String[]> getAllPlayersAndGames(Connection connection) {
        List<String[]> allPlayersAndGames = new ArrayList<>();

        try (PreparedStatement selectAllPlayersAndGamesStatement = connection.prepareStatement(SELECT_ALL_PLAYERSANDGAMES_SQL)) {
            ResultSet resultSet = selectAllPlayersAndGamesStatement.executeQuery();

            while (resultSet.next()) {
                int playerId = resultSet.getInt("PLAYER_ID");
                String firstName = resultSet.getString("FIRST_NAME");
                String lastName = resultSet.getString("LAST_NAME");
                String address = resultSet.getString("ADDRESS");
                String postalCode = resultSet.getString("POSTAL_CODE");
                String province = resultSet.getString("PROVINCE");
                String phoneNumber = resultSet.getString("PHONE_NUMBER");
                String gameTitle = resultSet.getString("GAME_TITLE");
                Date datePlayed = resultSet.getDate("PLAYING_DATE");
                int score = resultSet.getInt("SCORE");
               
                String name = firstName + " " + lastName;

                String[] playerAndGameData = {String.valueOf(playerId), name, address, postalCode, province, phoneNumber, gameTitle, String.valueOf(datePlayed), String.valueOf(score)};
                allPlayersAndGames.add(playerAndGameData);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return allPlayersAndGames;
    }

	public static List<String[]> getPlayersAndGamesById(Connection connection, int playerId) {
        List<String[]> PlayersAndGamesById = new ArrayList<>();
        
        try (PreparedStatement selectPlayersAndGamesByIdStatement = connection.prepareStatement(SELECT_PLAYERSANDGAMES_BY_ID_SQL)) {
        	selectPlayersAndGamesByIdStatement.setInt(1, playerId);
        	ResultSet resultSet = selectPlayersAndGamesByIdStatement.executeQuery();

            while (resultSet.next()) {
                playerId = resultSet.getInt("PLAYER_ID");
                String firstName = resultSet.getString("FIRST_NAME");
                String lastName = resultSet.getString("LAST_NAME");
                String address = resultSet.getString("ADDRESS");
                String postalCode = resultSet.getString("POSTAL_CODE");
                String province = resultSet.getString("PROVINCE");
                String phoneNumber = resultSet.getString("PHONE_NUMBER");
                String gameTitle = resultSet.getString("GAME_TITLE");
                Date datePlayed = resultSet.getDate("PLAYING_DATE");
                int score = resultSet.getInt("SCORE");
               
                String name = firstName + " " + lastName;

                String[] playerAndGameData = {String.valueOf(playerId), name, address, postalCode, province, phoneNumber, gameTitle, String.valueOf(datePlayed), String.valueOf(score)};
                PlayersAndGamesById.add(playerAndGameData);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return PlayersAndGamesById;
    }
}
