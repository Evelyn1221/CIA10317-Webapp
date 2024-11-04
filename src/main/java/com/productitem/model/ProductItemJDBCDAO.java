package com.productitem.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//此類別實作DAO interface，並將資料庫操作細節封裝起來
public class ProductItemJDBCDAO implements ProductItemDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/hihidatabase?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "z9081221";

	private static final String INSERT_STMT = "INSERT INTO ProductOrderItem (pdtOrderId,pdtId,pdtPrice,pdtName,orderQty) VALUES (?, ?, ?, ?, ?)";
	private static final String UPDATE = "UPDATE ProductOrderItem set pdtPrice=?, pdtName=?, orderQty=? where pdtOrderId = ? and pdtId=?";
	private static final String GET_ONE_STMT = "SELECT * FROM ProductOrderItem where pdtOrderId = ? and pdtId=?";
	private static final String GET_ALL_STMT = "SELECT * FROM ProductOrderItem order by pdtOrderId,pdtId";

	@Override
	public void insert(ProductItemVO productItemVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, productItemVO.getPdtOrderId());
			pstmt.setInt(2, productItemVO.getPdtId());
			pstmt.setInt(3, productItemVO.getPdtPrice());
			pstmt.setString(4, productItemVO.getPdtName());
			pstmt.setInt(5, productItemVO.getOrderQty());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public void update(ProductItemVO productItemVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, productItemVO.getPdtPrice());
			pstmt.setString(2, productItemVO.getPdtName());
			pstmt.setInt(3, productItemVO.getOrderQty());
			pstmt.setInt(4, productItemVO.getPdtOrderId());
			pstmt.setInt(5, productItemVO.getPdtId());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public ProductItemVO findByPrimaryKey(Integer pdtOrderId, Integer pdtId) {
		ProductItemVO productItemVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, pdtOrderId);
			pstmt.setInt(2, pdtId);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				productItemVO = new ProductItemVO();
				productItemVO.setPdtOrderId(rs.getInt("pdtOrderId"));
				productItemVO.setPdtId(rs.getInt("pdtId"));
				productItemVO.setPdtPrice(rs.getInt("pdtPrice"));
				productItemVO.setPdtName(rs.getString("pdtName"));
				productItemVO.setOrderQty(rs.getInt("orderQty"));

			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return productItemVO;
	}

	@Override
	public List<ProductItemVO> getAll() {
		List<ProductItemVO> list = new ArrayList<ProductItemVO>();
		ProductItemVO productItemVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				productItemVO = new ProductItemVO();
				productItemVO.setPdtOrderId(rs.getInt("pdtOrderId"));
				productItemVO.setPdtId(rs.getInt("pdtId"));
				productItemVO.setPdtPrice(rs.getInt("pdtPrice"));
				productItemVO.setPdtName(rs.getString("pdtName"));
				productItemVO.setOrderQty(rs.getInt("orderQty"));
				list.add(productItemVO); // Store the row in the list
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}

	public static void main(String[] arg) {

		ProductItemJDBCDAO dao = new ProductItemJDBCDAO();

		// 新增
//		ProductItemVO productItemVO1 = new ProductItemVO();
//		productItemVO1.setPdtOrderId(1);
//		productItemVO1.setPdtId(1003);
//		productItemVO1.setPdtPrice(1000);
//		productItemVO1.setPdtName("水果禮盒");
//		productItemVO1.setOrderQty(10);
//		dao.insert(productItemVO1);

		// 修改
//		ProductItemVO ProductItemVO2 = new ProductItemVO();
//		ProductItemVO2.setPdtOrderId(1);
//		ProductItemVO2.setPdtId(1001);
//		ProductItemVO2.setPdtPrice(1200);
//		ProductItemVO2.setPdtName("香水");
//		ProductItemVO2.setOrderQty(3);
//		dao.update(ProductItemVO2);

		// 查詢
		ProductItemVO productItemVO3 = dao.findByPrimaryKey(2, 1001);
		System.out.print(productItemVO3.getPdtOrderId() + ",");
		System.out.print(productItemVO3.getPdtId() + ",");
		System.out.print(productItemVO3.getPdtPrice() + ",");
		System.out.print(productItemVO3.getPdtName() + ",");
		System.out.println(productItemVO3.getOrderQty() + ",");
		System.out.println("---------------------");

		// 查詢All
		List<ProductItemVO> list = dao.getAll();
		for (ProductItemVO productItem : list) {
			System.out.print(productItem.getPdtOrderId() + ",");
			System.out.print(productItem.getPdtId() + ",");
			System.out.print(productItem.getPdtPrice() + ",");
			System.out.print(productItem.getPdtName() + ",");
			System.out.print(productItem.getOrderQty() + ",");
			System.out.println();

		}

	}

}
