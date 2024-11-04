package com.productitem.model;

import java.util.List;

public interface ProductItemDAO_interface {
	public void insert(ProductItemVO productItemVO);
	public void update(ProductItemVO productItemVO);
	public ProductItemVO findByPrimaryKey(Integer pdtOrderId, Integer pdtId);
	public List<ProductItemVO> getAll();
    //萬用複合查詢(傳入參數型態Map)(回傳 List)
//  public List<ProductItemVO> getAll(Map<String, String[]> map);
}
