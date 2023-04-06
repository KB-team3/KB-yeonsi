package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.DBManager;
import dto.LikeDTO;
import exception.SearchWrongException;

public class EndingDAOImpl implements EndingDAO {

	private static EndingDAO instance = new EndingDAOImpl();

	private EndingDAOImpl() {

	}

	public static EndingDAO getInstance() {

		return instance;
	}
	@Override
	public LikeDTO checkEnding(String userName) throws SearchWrongException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		LikeDTO likeDto = null;

		String sql = "Select * from likeability where user_name = ?";

		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, userName);

			rs = ps.executeQuery();

			while (rs.next()) {
				likeDto = new LikeDTO();
				likeDto.setUserName(rs.getString("user_name"));
				likeDto.setWooyeop(rs.getInt("wooyeop"));
				likeDto.setSangwoo(rs.getInt("sangwoo"));
				likeDto.setSunyeong(rs.getInt("sunyeong"));
				likeDto.setMinji(rs.getInt("minji"));
				likeDto.setChaelim(rs.getInt("chaelim"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SearchWrongException("엔딩 조회에 문제가 발생하였습니다.");

		} finally {
			DBManager.releaseConnection(con, ps, rs);

		}
		return likeDto;
	}

	

}
