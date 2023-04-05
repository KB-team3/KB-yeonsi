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

public class AcademyEventDAOImpl implements AcademyEventDAO{

	public static AcademyEventDAO instance = new AcademyEventDAOImpl();
	
	private AcademyEventDAOImpl() {}
	
	public static AcademyEventDAO getInstance() {
		return instance;
	}
	
	@Override
	public List<AcademyEventDTO> selectAcademyEventAll() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<AcademyEventDTO> academyEventList = new ArrayList<>();
		String sql = "select * from academy_event";
		
		try {
			con = DBManager.getConnection();
			con.setAutoCommit(false);
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				AcademyEventDTO dto = new AcademyEventDTO();
				int eventId = rs.getInt("event_id");
				String script = rs.getString("script");
				dto.setEventId(eventId);
				dto.setScript(script);
				List<AcademyOptionDTO> optionList = selectAcademyOption(con, eventId);
				dto.setOptionList(optionList);
				academyEventList.add(dto);
			}
			con.commit();
		} catch(SQLException e) {
			e.printStackTrace();
			// throw new 
		} finally {
			DBManager.releaseConnection(con, ps, rs);
		}
		return academyEventList;
	}
	
	private List<AcademyOptionDTO> selectAcademyOption(Connection con, int eventId){
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<AcademyOptionDTO> academyOptionList = new ArrayList<>();
		String sql = "select * from academy_option where event_id = ?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, eventId);
			rs = ps.executeQuery();
			while(rs.next()) {
				AcademyOptionDTO dto = new AcademyOptionDTO();
				int optionId = rs.getInt("option_id");
				String selName = rs.getString("sel_name");
				String charName = rs.getString("character_name");
				int likePoint = rs.getInt("like_point");
				String resultScript = rs.getString("result_script");
				
				dto.setOptionId(optionId);
				dto.setSelName(selName);
				dto.setEventId(eventId);
				dto.setCharacterName(charName);
				dto.setLikePoint(optionId);
				dto.setResultScript(resultScript);
			    
				academyOptionList.add(dto);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			// throw new 
		} finally {
			DBManager.releaseConnection(null, ps, rs);
		}
		return academyOptionList;
	}
	
	@Override
	public int insertAcademyEvent(AcademyEventDTO dto) {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "insert into academy_event values (aca_ev_seq.nextval, ?)";
		
		try {
			con = DBManager.getConnection();
			con.setAutoCommit(false);
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getScript());
			
			con.commit();
		} catch(SQLException e) {
			e.printStackTrace();
			// throw new 
		} finally {
			DBManager.releaseConnection(con, ps);
		}
		
		return result;
	}
	
	private int insertAcademyOption(Connection con, AcademyOptionDTO dto) {
		
		return 0;
	}
	
	@Override
	public int updateAcademyEvent(AcademyEventDTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int deleteAcademyEvent(int eventId) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
