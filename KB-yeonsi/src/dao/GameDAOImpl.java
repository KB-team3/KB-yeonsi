package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.DBManager;
import dto.AcademyOptionDTO;

public class GameDAOImpl implements GameDAO {
	private static GameDAO instance = new GameDAOImpl();
	
	private GameDAOImpl() {}
	public static GameDAO getInstance() {
		return instance;
	}
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
}
