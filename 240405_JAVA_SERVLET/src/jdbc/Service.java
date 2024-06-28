package jdbc;

import java.util.List;

public interface Service {

	int register(ProductVO p);

	List<ProductVO> getList();

	ProductVO getDetail(int pno);

	ProductVO getRemove(int pno);

	ProductVO getModifyName(int pno, String modName);

	ProductVO getModifyPrice(int pno, int modPrice);

	ProductVO getModifyMadeby(int pno, String modMadeby);


}
