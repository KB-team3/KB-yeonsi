package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.DBManager;
import dto.TalkEventDTO;
import dto.TalkOptionDTO;
import dto.TalkEventDTO;
import exception.DMLException;
import exception.SearchWrongException;

public class TalkEventDAOImpl implements TalkEventDAO {

public static TalkEventDAO instance = new TalkEventDAOImpl();
	
	private TalkEventDAOImpl() {}
	
	public static TalkEventDAO getInstance() {
		return instance;
	}
	
	/**
	 * 대화 이벤트 전체 조회
	 */
	@Override
	public List<TalkEventDTO> selectTalkEventAll() throws SearchWrongException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<TalkEventDTO> talkEventList = new ArrayList<>();
		String sql = "select * from talk_event";
		
		try {
			con = DBManager.getConnection();
			con.setAutoCommit(false);
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				TalkEventDTO dto = new TalkEventDTO();
				int eventId = rs.getInt("event_id");
				String script = rs.getString("script");
				dto.setEventId(eventId);
				dto.setScript(script);
				List<TalkOptionDTO> optionList = selectTalkOption(con, eventId);
				dto.setOptionList(optionList);
				talkEventList.add(dto);
			}
			con.commit();
		} catch(SQLException e) {
			e.printStackTrace();
			 throw new SearchWrongException("조회 예외");
		} finally {
			DBManager.releaseConnection(con, ps, rs);
		}
		return talkEventList;
	}
	
	/**
	 * 대화 이벤트 옵션 조회
	 */
	private List<TalkOptionDTO> selectTalkOption (Connection con, int eventId) throws SearchWrongException{
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<TalkOptionDTO> talkOptionList = new ArrayList<>();
		String sql = "select * from talk_option where event_id = ?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, eventId);
			rs = ps.executeQuery();
			while(rs.next()) {
				TalkOptionDTO dto = new TalkOptionDTO();
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
			    
				talkOptionList.add(dto);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			// throw new 
		} finally {
			DBManager.releaseConnection(null, ps, rs);
		}
		return talkOptionList;
	}
	
	/**
	 * 대화 이벤트 추가
	 */
	@Override
	public int insertTalkEvent(TalkEventDTO dto) throws DMLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "insert into talk_event values (talk_ev_seq.nextval, ?)";
		
		try {
			con = DBManager.getConnection();
			con.setAutoCommit(false);
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getScript());
			result = ps.executeUpdate();
			insertTalkOption(con, dto);
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
	 * 대화 옵션 추가
	 */
	private int insertTalkOption(Connection con, TalkEventDTO dto) throws DMLException {
		PreparedStatement ps = null;
		int result = 0;
		String sql = "insert into talk_option values (talk_op_seq.nextval, talk_ev_seq.currval, ?, ?, ?, ?)";
		
		try {
			List<TalkOptionDTO> optionList = dto.getOptionList();
			for (TalkOptionDTO option : optionList) {
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
	 * 대화 이벤트 삭제
	 */
	@Override
	public int deleteTalkEvent(int eventId) throws DMLException  {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "delete from talk_event where event_id = ?";
		
		try {
			con = DBManager.getConnection();
			con.setAutoCommit(false);
			deleteTalkOption(con, eventId);
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
	 * 대화 옵션 삭제
	 */
	private int deleteTalkOption(Connection con, int eventId) throws DMLException  {
		PreparedStatement ps = null;
		int result = 0;
		String sql = "delete from talk_option where event_id = ?";
		
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
