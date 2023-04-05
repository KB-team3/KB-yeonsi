package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.DBManager;
import dto.LikeDTO;
import exception.SearchWrongException;

public class MenuDAOImpl implements MenuDAO {

	private static MenuDAO instance = new MenuDAOImpl();

	private MenuDAOImpl() {
	}

	public static MenuDAO getInstance() {
		return instance;
	}

	@Override
	public List<LikeDTO> viewRanking(String charName) throws SearchWrongException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		LikeDTO likeDto = null;
		String sql = null;
		
		List<LikeDTO> list = new ArrayList<>();

		switch (charName) {
		case "wooyeop":
			sql = "select * from likeability order by wooyeop desc";
			break;
		case "sangwoo":
			sql = "select * from likeability order by sangwoo desc";
			break;
		case "sunyeong":
			sql = "select * from likeability order by sunyeong desc";
			break;
		case "minji":
			sql = "select * from likeability order by minji desc";
			break;
		case "chaelim":
			sql = "select * from likeability order by chaelim desc";
			break;
		}

		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				likeDto = new LikeDTO(rs.getString("user_name"), rs.getInt("wooyeop"), rs.getInt("sangwoo"), 
						rs.getInt("sunyeong"), rs.getInt("minji"), rs.getInt("chaelim"));
				
				list.add(likeDto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new SearchWrongException("랭킹 조회에 문제가 발생하였습니다.");

		} finally {

			DBManager.releaseConnection(con, ps, rs);
		}
		return list;
	}
}
