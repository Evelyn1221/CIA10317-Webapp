package com.productitem.model;

import java.util.List;

public class ProductItemService {

	private ProductItemDAO_interface dao;

	public ProductItemService() {
		dao = new ProductItemJDBCDAO();
	}

	public ProductItemVO addProductItem(Integer pdtOrderId, Integer pdtId, Integer pdtPrice, 
			String pdtName, Integer orderQty) {

		ProductItemVO productItemVO = new ProductItemVO();

		productItemVO.setPdtOrderId(pdtOrderId);
		productItemVO.setPdtId(pdtId);
		productItemVO.setPdtPrice(pdtPrice);
		productItemVO.setPdtName(pdtName);
		productItemVO.setOrderQty(orderQty);
		dao.insert(productItemVO);

		return productItemVO;
	}

	public ProductItemVO updateProductItem(Integer pdtOrderId, Integer pdtId, Integer pdtPrice, 
			String pdtName, Integer orderQty) {

		ProductItemVO productItemVO = new ProductItemVO();

		productItemVO.setPdtOrderId(pdtOrderId);
		productItemVO.setPdtId(pdtId);
		productItemVO.setPdtPrice(pdtPrice);
		productItemVO.setPdtName(pdtName);
		productItemVO.setOrderQty(orderQty);
		dao.update(productItemVO);

		return productItemVO;
	}

	public ProductItemVO getOneProductItem(Integer pdtOrderId, Integer pdtId) {
		return dao.findByPrimaryKey(pdtOrderId, pdtId);
	}

	public List<ProductItemVO> getAll() {
		return dao.getAll();
	}
}
