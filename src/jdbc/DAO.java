package jdbc;

import java.util.List;

public interface DAO {

	int insert(ProductVO p);

	List<ProductVO> selectList();

	ProductVO selectOne(int pno);

	ProductVO remove(int pno);

	ProductVO updateName(int pno, String modName);

	ProductVO updatePrice(int pno, int modPrice);

	ProductVO updateMadeby(int pno, String modMadeby);

}
