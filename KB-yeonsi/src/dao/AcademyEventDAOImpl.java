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
import exception.DMLException;
import exception.SearchWrongException;

public class AcademyEventDAOImpl implements AcademyEventDAO{

	public static AcademyEventDAO instance = new AcademyEventDAOImpl();
	
	private AcademyEventDAOImpl() {}
	
	public static AcademyEventDAO getInstance() {
		return instance;
	}
	
	/**
	 * 아카데미 이벤트 전체 검색
	 */
	@Override
	public List<AcademyEventDTO> selectAcademyEventAll() throws SearchWrongException {
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
			throw new SearchWrongException("아카데미 이벤트 조회 예외");
		} finally {
			DBManager.releaseConnection(con, ps, rs);
		}
		return academyEventList;
	}
	
	/**
	 * 아카데미 이벤트 옵션 조회
	 */
	private List<AcademyOptionDTO> selectAcademyOption (Connection con, int eventId) throws SearchWrongException{
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
			throw new SearchWrongException("아카데미 옵션 조회 예외");
		} finally {
			DBManager.releaseConnection(null, ps, rs);
		}
		return academyOptionList;
	}
	
	/**
	 * 아카데미 이벤트 추가
	 */
	@Override
	public int insertAcademyEvent(AcademyEventDTO dto) throws DMLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "insert into academy_event values (aca_ev_seq.nextval, ?)";
		
		try {
			con = DBManager.getConnection();
			con.setAutoCommit(false);
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getScript());
			result = ps.executeUpdate();
			insertAcademyOption(con, dto);
			con.commit();
		} catch(SQLException e) {
			e.printStackTrace();
			throw new DMLException("이벤트 추가하는 데 예외 발생") ;
		} finally {
			DBManager.releaseConnection(con, ps);
		}
		
		return result;
	}
	
	/**
	 * 아카데미 옵션 추가
	 */
	private int insertAcademyOption(Connection con, AcademyEventDTO dto) throws DMLException {
		PreparedStatement ps = null;
		int result = 0;
		String sql = "insert into academy_option values (aca_op_seq.nextval, aca_ev_seq.currval, ?, ?, ?, ?)";
		
		try {
			List<AcademyOptionDTO> optionList = dto.getOptionList();
			for (AcademyOptionDTO option : optionList) {
				ps = con.prepareStatement(sql);
				ps.setString(1, option.getSelName());
				ps.setString(2, option.getCharacterName());
				ps.setInt(3, option.getLikePoint());
				ps.setString(4, option.getResultScript());
				result = ps.executeUpdate();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DMLException("이벤트의 선택지 추가하는 데 예외 발생") ;
		} finally {
			DBManager.releaseConnection(null, ps);
		}
		
		return result;
	}
	
	/**
	 * 아카데미 이벤트 삭제
	 */
	@Override
	public int deleteAcademyEvent(int eventId) throws DMLException  {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "delete from academy_event where event_id = ?";
		
		try {
			con = DBManager.getConnection();
			con.setAutoCommit(false);
			deleteAcademyOption(con, eventId);
			ps = con.prepareStatement(sql);
			ps.setInt(1, eventId);
			result = ps.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DMLException("이벤트 삭제하는 데 예외 발생") ;
		} finally {
			DBManager.releaseConnection(null, ps);
		}
		
		return result;
	}
	
	/**
	 * 아카데미 옵션 삭제
	 */
	private int deleteAcademyOption(Connection con, int eventId) throws DMLException  {
		PreparedStatement ps = null;
		int result = 0;
		String sql = "delete from academy_option where event_id = ?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, eventId);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DMLException("이벤트의 선택지 삭제하는 데 예외 발생") ;
		} finally {
			DBManager.releaseConnection(null, ps);
		}
		
		return result;
	}
}
