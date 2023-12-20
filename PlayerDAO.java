package exercise01;

import java.sql.*;
public class PlayerDAO {
	
	private static final String INSERT_PLAYER_SQL = "INSERT INTO PLAYER (PLAYER_ID, FIRST_NAME, LAST_NAME, ADDRESS, POSTAL_CODE, PROVINCE, PHONE_NUMBER) VALUES (PLAYER_SEQUENCE.nextval, ?, ?, ?, ?, ?, ?)";
	private static final String UPDATE_FIRSTNAME_SQL = "UPDATE PLAYER SET FIRST_NAME = ? WHERE PLAYER_ID = ?";
	private static final String UPDATE_LASTNAME_SQL = "UPDATE PLAYER SET LAST_NAME = ? WHERE PLAYER_ID = ?";
	private static final String UPDATE_ADDRESS_SQL = "UPDATE PLAYER SET ADDRESS = ? WHERE PLAYER_ID = ?";
	private static final String UPDATE_POSTCODE_SQL = "UPDATE PLAYER SET POSTAL_CODE = ? WHERE PLAYER_ID = ?";
	private static final String UPDATE_PROVINCE_SQL = "UPDATE PLAYER SET PROVINCE = ? WHERE PLAYER_ID = ?";
	private static final String UPDATE_PHONE_SQL = "UPDATE PLAYER SET PHONE_NUMBER = ? WHERE PLAYER_ID = ?";
	
	public PlayerDAO(){};
	
    public void createPlayer(Connection connection, String firstName, String lastName, String address, String postCode, String province, String phone) {
    	// Insert data into PLAYER table
	    try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PLAYER_SQL)) {
	    	preparedStatement.setString(1, firstName);
	        preparedStatement.setString(2, lastName);
	        preparedStatement.setString(3, address);
	        preparedStatement.setString(4, postCode);
	        preparedStatement.setString(5, province);
	        preparedStatement.setString(6, phone);

	        preparedStatement.executeUpdate();

	        
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	   
	}
    
    // getting PLAYER_ID generated
    public int getPlayerId(Connection connection) throws SQLException {
    	int playerId = 0;
    	String selectPlayerSql = "SELECT MAX(PLAYER_ID) AS MAX_PLAYER_ID FROM PLAYER";
    	try (PreparedStatement selectPlayerStatement = connection.prepareStatement(selectPlayerSql)) {
	        //selectPlayerStatement.setString(1, gameTitle);
	        ResultSet resultSet = selectPlayerStatement.executeQuery();
	        if (resultSet.next()) {
	            playerId = resultSet.getInt("MAX_PLAYER_ID");
	        }
	    }
	    return playerId;
    }
    
    public static void updateFirstName(Connection connection, String firstName, int playerId) {
    	try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_FIRSTNAME_SQL)) {
        	preparedStatement.setString(1, firstName);
            preparedStatement.setInt(2, playerId);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void updateLastName(Connection connection, String lastName, int playerId) {
    	try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_LASTNAME_SQL)) {
        	preparedStatement.setString(1, lastName);
            preparedStatement.setInt(2, playerId);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void updateAddress(Connection connection, String address, int playerId) {
    	try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ADDRESS_SQL)) {
        	preparedStatement.setString(1, address);
            preparedStatement.setInt(2, playerId);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void updatePostCode(Connection connection, String postCode, int playerId) {
    	try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_POSTCODE_SQL)) {
        	preparedStatement.setString(1, postCode);
            preparedStatement.setInt(2, playerId);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void updateProvince(Connection connection, String province, int playerId) {
    	try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PROVINCE_SQL)) {
        	preparedStatement.setString(1, province);
            preparedStatement.setInt(2, playerId);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void updatePhone(Connection connection, String phone, int playerId) {
    	try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PHONE_SQL)) {
        	preparedStatement.setString(1, phone);
            preparedStatement.setInt(2, playerId);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }   
}