package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ProductDAOImpl implements DAO {
	
	//DB연결
	private Connection conn;
	//sql 구문을 실행시키는 기능을하는 객체
	private PreparedStatement pst;
	//쿼리구문 저장 스트링
	private String query = "";
	
	public ProductDAOImpl() {
		//DBConnection class 생성(싱클톤)
		DatabaseConnection dbc = DatabaseConnection.getInstance();
		conn = dbc.getConnection();
	}

	//sql 구문 처리
	@Override
	public int insert(ProductVO p) {
		System.out.println("insert DAOImpl success");
		query = "insert into product(pname, price, madeby) values(?,?,?)";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, p.getPname());
			pst.setInt(2, p.getPrice());
			pst.setString(3, p.getMadeby());
			//insert, update, delete => executeUpdate() return int(처리개수로 리턴)
			return pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("insert Error!!");
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<ProductVO> selectList() {
		System.out.println("list DAOImpl success");
		query = "select * from product order by pno desc";
		List<ProductVO> list = new ArrayList<ProductVO>();
		try {
			pst = conn.prepareStatement(query);
			//list => executeQuery(); => return ResultSet
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				list.add(new ProductVO(rs.getInt("pno"), rs.getString("pname"), rs.getInt("price")));
			}
			return list;
		} catch (SQLException e) {
			System.out.println("list error");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ProductVO selectOne(int pno) {
		System.out.println("selectOne DAOImpl success");
		query = "select * from product where pno = ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, pno);
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				return new ProductVO(rs.getInt("pno"),
						rs.getString("pname"),
						rs.getInt("price"),
						rs.getString("regdate"),
						rs.getString("madeby"));
			}
		} catch (SQLException e) {
			System.out.println("detail error");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ProductVO remove(int pno) {
		System.out.println("selectOne DAOImpl success");
		query = "delete from product where pno = ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, pno);
			int rs = pst.executeUpdate();
			if(rs == 1) {
				System.out.println("삭제성공");
			}else {
				System.out.println("삭제실패");
			}
		} catch (SQLException e) {
			System.out.println("remove error");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ProductVO updateName(int pno, String modName) {
		System.out.println("selectOne DAOImpl success");
		query = "update product set pname = ? where pno = ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, modName);
			pst.setInt(2, pno);
			int rs = pst.executeUpdate();
			if(rs == 1) {
				System.out.println("수정성공");
			}else {
				System.out.println("수정실패");
			}
		} catch (SQLException e) {
			System.out.println("modifyName error");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ProductVO updatePrice(int pno, int modPrice) {
		System.out.println("selectOne DAOImpl success");
		query = "update product set price = ? where pno = ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, modPrice);
			pst.setInt(2, pno);
			int rs = pst.executeUpdate();
			if(rs == 1) {
				System.out.println("수정성공");
			}else {
				System.out.println("수정실패");
			}
		} catch (SQLException e) {
			System.out.println("modifyPrice error");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ProductVO updateMadeby(int pno, String modMadeby) {
		System.out.println("selectOne DAOImpl success");
		query = "update product set madeby = ? where pno = ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, modMadeby);
			pst.setInt(2, pno);
			int rs = pst.executeUpdate();
			if(rs == 1) {
				System.out.println("수정성공");
			}else {
				System.out.println("수정실패");
			}
		} catch (SQLException e) {
			System.out.println("modify error");
			e.printStackTrace();
		}
		return null;
	}

}
