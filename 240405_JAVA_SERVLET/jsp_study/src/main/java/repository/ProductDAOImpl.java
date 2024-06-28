package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.ProductVO;
import orm.DatabaseBuilder;

public class ProductDAOImpl implements ProductDAO {
	private static final Logger log = LoggerFactory.getLogger(ProductDAOImpl.class);
	private SqlSession sql;
	public ProductDAOImpl() {
		new DatabaseBuilder();
		sql = DatabaseBuilder.getFactory().openSession();
	}
	@Override
	public int insert(ProductVO pvo) {
		int isOk = sql.insert("ProductMapper.add", pvo);
		if(isOk > 0) {
			sql.commit();
		}
		return isOk;
	}
	@Override
	public List<ProductVO> selectList() {
		return sql.selectList("ProductMapper.list");
	}
	@Override
	public ProductVO selectOne(int pnum) {
		return sql.selectOne("ProductMapper.detail", pnum);
	}
	

}
