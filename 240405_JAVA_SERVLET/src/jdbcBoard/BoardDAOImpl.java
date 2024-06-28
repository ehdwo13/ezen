package jdbcBoard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDAOImpl implements DAO{
	
	private Connection conn;
	private PreparedStatement pst;
	private String query = "";
	
	public BoardDAOImpl() {
		DatabaseConnection dbc = DatabaseConnection.getInstance();
		conn = dbc.getConnection();
	}

	@Override
	public int insert(BoardVO b) {
		System.out.println("insert DAOImpl success");
		query = "insert into board(title,writer,content)"
				+ "values(?,?,?)";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, b.getTitle());
			pst.setString(2, b.getWriter());
			pst.setString(3, b.getContent());
			return pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("insert error");
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public BoardVO selectOne(int bno) {
		System.out.println("selectOne DAOImpl success");
		query = "select * from board where bno = ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, bno);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				return new BoardVO(rs.getInt("bno"),
						rs.getString("title"),
						rs.getString("writer"),
						rs.getString("content"));
			}
			
		} catch (SQLException e) {
			System.out.println("selectOne error");
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public int update(BoardVO b) {
		System.out.println("update DAOImpl success");
		query = "update board set title=?, writer=?, content=?, moddate=now() where bno=?";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, b.getTitle());
			pst.setString(2, b.getWriter());
			pst.setString(3, b.getContent());
			pst.setInt(4, b.getBno());
			return pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("update error");
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int remove(int bno) {
		System.out.println("remove DAOImpl success");
		query = "delete from board where bno = ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, bno);
			return pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("delete error");
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<BoardVO> select() {
		System.out.println("select DAOImpl success");
		query = "select * from board order by bno";
		List<BoardVO> list = new ArrayList<BoardVO>();
		try {
			pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				list.add(new BoardVO(rs.getInt("bno"), rs.getString("title"), rs.getString("writer"), rs.getString("content"),
						rs.getString("regdate"), rs.getString("moddate")));
			}
			return list;
		} catch (SQLException e) {
			System.out.println("list error");
			e.printStackTrace();
		}
		return null;
	}
}
