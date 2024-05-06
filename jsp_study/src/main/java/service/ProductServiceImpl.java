package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.ProductVO;
import repository.ProductDAO;
import repository.ProductDAOImpl;

public class ProductServiceImpl implements ProductService {
	private static final Logger log = LoggerFactory.getLogger(MemberServiceImpl.class);
	private ProductDAO pdao;
	
	public ProductServiceImpl() {
		pdao = new ProductDAOImpl();
	}

	@Override
	public int register(ProductVO pvo) {
		return pdao.insert(pvo);
	}

	@Override
	public List<ProductVO> getList() {
		return pdao.selectList();
	}

	@Override
	public ProductVO detail(int pnum) {
		return pdao.selectOne(pnum);
	}
}
