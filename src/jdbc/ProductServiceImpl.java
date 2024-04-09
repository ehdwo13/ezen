package jdbc;

import java.util.List;

public class ProductServiceImpl implements Service {
	
	private DAO dao; //인터페이스
	public ProductServiceImpl() {
		dao = new ProductDAOImpl(); //구현체
	}
	@Override
	public int register(ProductVO p) {
		// 실제 구현 영역
		System.out.println("register serviceImpl success");
		//각 DAO에게 저장 요청
		//dao 요청시 sql구문과 비슷하게 메서드명을 작성
		return dao.insert(p);
	}
	@Override
	public List<ProductVO> getList() {
		System.out.println("list serviceImpl success");
		return dao.selectList();
	}
	@Override
	public ProductVO getDetail(int pno) {
		System.out.println("detail serviceImpl success");
		return dao.selectOne(pno);
	}
	@Override
	public ProductVO getRemove(int pno) {
		System.out.println("remove serviceImpl success");
		return dao.remove(pno);
	}
	@Override
	public ProductVO getModifyName(int pno, String modName) {
		System.out.println("modify serviceImpl success");
		return dao.updateName(pno, modName);
	}
	@Override
	public ProductVO getModifyPrice(int pno, int modPrice) {
		System.out.println("modify serviceImpl success");
		return dao.updatePrice(pno, modPrice);
	}
	@Override
	public ProductVO getModifyMadeby(int pno, String modMadeby) {
		System.out.println("modify serviceImpl success");
		return dao.updateMadeby(pno, modMadeby);
	}
	
}
