package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.DBManager;
import dto.AcademyEventDTO;
import dto.AcademyOptionDTO;
import dto.LikeDTO;
import dto.UserDTO;
import exception.DMLException;
import exception.SearchWrongException;
import view.MainApp;


public class GameDAOImpl implements GameDAO{

	private static GameDAO instance = new GameDAOImpl();
	
	private GameDAOImpl() {}
	public static GameDAO getInstance() {
		return instance;
	}
	
	@Override
	public List<AcademyOptionDTO> optionSelectByEventId(int eventId) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from academy_option where event_Id = ?";
		List<AcademyOptionDTO> list = new ArrayList<>();
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, eventId);
			rs = ps.executeQuery();
			while(rs.next()) {
				AcademyOptionDTO dto = new AcademyOptionDTO(
						rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6)
				);
				list.add(dto);
			}
		} catch(SQLException e) {
			
		} finally {
			DBManager.releaseConnection(con, ps, rs);
		}
		return list;
	}
	
	
	@Override
	public int foodUpdate(String userName, String selectCharacter, int foodCode) throws DMLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "update likeability set " + selectCharacter + " = " + 
				selectCharacter + " + (select " + selectCharacter + " from food where food_code = ?) "
						+ "where user_name = ?";

		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, foodCode);
			ps.setString(2, userName);
			result = ps.executeUpdate();
			
		}catch(SQLException e) {
			throw new DMLException("선택이 잘못되었습니다.");
		}finally {
			DBManager.releaseConnection(con, ps);
		}
		return result;
	}
	

	public int giftUpdate(String userName, String selectCharacter, int giftNum) throws DMLException {
	        Connection con = null;
	        PreparedStatement ps = null;
	        int result = 0;
	        String sql = "update likeability set " + selectCharacter + " = " + selectCharacter + " + (select " + selectCharacter + " from gift where gift_code = ?) where user_name = ?";

	        try {
	            con = DBManager.getConnection();
	            ps = con.prepareStatement(sql);
	            ps.setInt(1,  giftNum);
	            ps.setString(2,  userName);
	            result = ps.executeUpdate();

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            DBManager.releaseConnection(con, ps);
	        }
	        return result;
	    }
	
	@Override
    public int userInsert(String userName) throws DMLException {
        Connection con = null;
        PreparedStatement ps = null;
        int result = 0;
        String sql = "insert into users (user_name) values (?)";
        try {
            con = DBManager.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1,  MainApp.userName);
            result = ps.executeUpdate();

    } catch (Exception e) {
        throw new DMLException("입력이 잘못되었습니다.");
    } finally {
        DBManager.releaseConnection(con, ps);
    }
    return result;    
}
	
	@Override
    public int likeAbilityInsert(String userName) throws DMLException {
        Connection con = null;
        PreparedStatement ps = null;
        int result = 0;
        String sql = "insert into likeability (user_name) values (?)";
        try {
            con = DBManager.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, MainApp.userName);
            result = ps.executeUpdate();

    } catch (Exception e) {
        throw new DMLException("입력이 잘못되었습니다.");
    } finally {
        DBManager.releaseConnection(con, ps);
    }
    return result;
}
	@Override
    public UserDTO userGet(String userName) throws SearchWrongException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * "
            + "from users u, likeability l "
            + "where u.user_name = l.user_name and u.user_name = ?";
	    UserDTO user =  new UserDTO();
	    try {
	        con = DBManager.getConnection();
	        ps = con.prepareStatement(sql);
	        ps.setString(1,  userName);
	        rs = ps.executeQuery();
	        
	        if(rs.next()) {
	            user = new UserDTO(rs.getString(1), rs.getInt(2));
	            LikeDTO like = new LikeDTO(rs.getString(3), rs.getInt(4), rs.getInt(5),
	                    rs.getInt(6), rs.getInt(7), rs.getInt(8));
	            user.setLikeability(like);
	        }
	
	    } catch (Exception e) {
	        throw new SearchWrongException("유저 선택이 잘못되었습니다.");
	    } finally {
	        DBManager.releaseConnection(con, ps, rs);
	    }
	    return user;
}
	
	@Override
    public int academyUpdate(AcademyOptionDTO dto) throws DMLException {
        Connection con = null;
        PreparedStatement ps = null;
        int result = 0;
        String sql = "update likeability set " + dto.getCharacterName() + " = " + 
                dto.getCharacterName() + "+" + dto.getLikePoint() +" where user_name = ?";
        try {
            con = DBManager.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, MainApp.userName);
            result = ps.executeUpdate();

        }catch(SQLException e) {
            throw new DMLException("선택이 잘못되었습니다.");
        }finally {
            DBManager.releaseConnection(con, ps);
        }
        return result;
    }
	
	/**
	 * 작성자: 이우엽
	 * 
	 */
	@Override
    public AcademyEventDTO academyEventSelectByRandom(int eventId) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int result = 0;
        AcademyEventDTO dto = null;
        String sql = "select * from academy_event where event_Id = ?";
        try {
            con = DBManager.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, eventId);
            rs = ps.executeQuery();
            if(rs.next()) {
                dto = new AcademyEventDTO(rs.getInt(1), rs.getString(2));
            }
        } catch(SQLException e) {
                throw new SearchWrongException("오류");
        } finally {
            DBManager.releaseConnection(con, ps, rs);
        }
        return dto;
    }
	
}
