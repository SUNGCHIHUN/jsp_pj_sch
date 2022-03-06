package pj.mvc.jsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import pj.mvc.jsp.dto.DeliveryDTO;
import pj.mvc.jsp.dto.OrderDTO;

public class OrderDAOImpl implements OrderDAO {
	// 커넥션 풀
	DataSource dataSource = null;
	
	// DB 사용을 위한 변수
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	// 싱글톤
	private static OrderDAO instance = new OrderDAOImpl();
	
	private OrderDAOImpl() {
		try {
			// context.xml에 설정해 둔 데이터베이스 커넥션 가져오기
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/jsp_pj_105");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public static OrderDAO getInstance() {
		if (instance == null) {
			instance = new OrderDAOImpl();
		}
		return instance;
	}


	// 전체 주문조회
	@Override
	public List<OrderDTO> selectOrderList(int start, int end) {
		System.out.println("selectOrderList() - dao");
		
		// 상품 조회 결과 큰 바구니
		List<OrderDTO> olist = new ArrayList<>();
		
		try {
			conn = dataSource.getConnection();
			
			String sql = "SELECT *"
					+ "  FROM ("
					+ "        SELECT A.*, ROWNUM AS rn"
					+ "          FROM ("
					+ "                SELECT order_no, order_day, customer_id, product_no, product_img_name, product_name, order_amount, delivery_message, billing_number, product_price, (product_price * order_amount) total, order_state"
					+ "                  FROM orders_view"
					+ "                 ORDER BY order_no DESC"
					+ "                ) A"
					+ "        )"
					+ " WHERE rn BETWEEN ? AND ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				do {
					OrderDTO dto = new OrderDTO();
					dto.setOrder_no(rs.getString("order_no"));
					dto.setOrder_day(rs.getDate("order_day"));
					dto.setCustomer_id(rs.getString("customer_id"));
					dto.setProduct_no(rs.getString("product_no"));
					dto.setProduct_img_name(rs.getString("product_img_name"));
					dto.setProduct_name(rs.getString("product_name"));
					dto.setOrder_amount(rs.getInt("order_amount"));
					dto.setDelivery_message(rs.getString("delivery_message"));
					dto.setBilling_number(rs.getString("billing_number"));
					dto.setProduct_price(rs.getInt("product_price"));
					dto.setTotal_price(rs.getInt("total"));
					dto.setOrder_state(rs.getString("order_state"));
					
					olist.add(dto);
					
				} while(rs.next());
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(olist);
		
		return olist;
	}
	
	// 특정고객 주문조회
	@Override
	public List<OrderDTO> selectOrderList(int start, int end, String customer_id) {
		System.out.println("selectOrderList() - dao");
		
		// 상품 조회 결과 큰 바구니
		List<OrderDTO> olist = new ArrayList<>();
		
		try {
			conn = dataSource.getConnection();
			
			String sql = "SELECT *"
					+ "  FROM ("
					+ "        SELECT A.*, ROWNUM AS rn"
					+ "          FROM ("
					+ "                SELECT order_no, order_day, customer_id, product_no, product_img_name, product_name, order_amount, delivery_message, billing_number, product_price, (product_price * order_amount) total, order_state"
					+ "                  FROM orders_view"
					+ "                 WHERE customer_id=?"
					+ "                 ORDER BY order_no DESC"
					+ "                ) A"
					+ "        )"
					+ " WHERE rn BETWEEN ? AND ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, customer_id);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				do {
					OrderDTO dto = new OrderDTO();
					dto.setOrder_no(rs.getString("order_no"));
					dto.setOrder_day(rs.getDate("order_day"));
					dto.setCustomer_id(rs.getString("customer_id"));
					dto.setProduct_no(rs.getString("product_no"));
					dto.setProduct_img_name(rs.getString("product_img_name"));
					dto.setProduct_name(rs.getString("product_name"));
					dto.setOrder_amount(rs.getInt("order_amount"));
					dto.setDelivery_message(rs.getString("delivery_message"));
					dto.setBilling_number(rs.getString("billing_number"));
					dto.setProduct_price(rs.getInt("product_price"));
					dto.setTotal_price(rs.getInt("total"));
					dto.setOrder_state(rs.getString("order_state"));
					
					olist.add(dto);
					
				} while(rs.next());
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(olist);
		
		return olist;
	}

	// 배송 조회
	@Override
	public List<OrderDTO> selectOrderDlist(int start, int end, String order_state) {
		System.out.println("selectOrderList() - dao");
		
		// 상품 조회 결과 큰 바구니
		List<OrderDTO> olist = new ArrayList<>();
		
		try {
			conn = dataSource.getConnection();
			
			String sql = "SELECT *"
					+ "  FROM ("
					+ "        SELECT A.*, ROWNUM AS rn"
					+ "          FROM ("
					+ "                SELECT order_no, order_day, customer_id, product_no, product_img_name, product_name, order_amount, delivery_message, billing_number, product_price, (product_price * order_amount) total, order_state"
					+ "                  FROM orders_view"
					+ "                 WHERE order_state=?"
					+ "                 ORDER BY order_no DESC"
					+ "                ) A"
					+ "        )"
					+ " WHERE rn BETWEEN ? AND ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, order_state);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				do {
					OrderDTO dto = new OrderDTO();
					dto.setOrder_no(rs.getString("order_no"));
					dto.setOrder_day(rs.getDate("order_day"));
					dto.setCustomer_id(rs.getString("customer_id"));
					dto.setProduct_no(rs.getString("product_no"));
					dto.setProduct_img_name(rs.getString("product_img_name"));
					dto.setProduct_name(rs.getString("product_name"));
					dto.setOrder_amount(rs.getInt("order_amount"));
					dto.setDelivery_message(rs.getString("delivery_message"));
					dto.setBilling_number(rs.getString("billing_number"));
					dto.setProduct_price(rs.getInt("product_price"));
					dto.setTotal_price(rs.getInt("total"));
					dto.setOrder_state(rs.getString("order_state"));
					
					olist.add(dto);
					
				} while(rs.next());
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(olist);
		
		return olist;
	}
	
	@Override
	public int insertOrder(List<OrderDTO> olist) {
		System.out.println("insertOrder() - dao");
		
		int insertResult = 0;
		
		try {
			conn = dataSource.getConnection();
			
			String sql = "INSERT INTO orders(order_no, customer_id, product_no, order_amount, zipcode, delivery_message, payment)" + 
					     " VALUES(orders_seq.nextval, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			System.out.println("olist : " + olist);
			
			// 주문한 상품 개수만큼 주문리스트에 등록
			for (OrderDTO dto : olist) {
				
				pstmt.setString(1, dto.getCustomer_id());
				pstmt.setString(2, dto.getProduct_no());
				pstmt.setInt(3, dto.getOrder_amount());
				pstmt.setString(4, dto.getZipcode());
				pstmt.setString(5, dto.getDelivery_message());
				pstmt.setString(6, dto.getPayment());

				// DB에 장바구니 등록 및 결과행 개수 반환
				insertResult += pstmt.executeUpdate();
			}
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("insertResult : " + insertResult);
		
		return insertResult;
	}

	@Override
	public int updateState(String order_no, String state) {
		System.out.println("updateState() - dao");
		
		int updateResult = 0;
		
		try {
			conn = dataSource.getConnection();
			
			String sql = "UPDATE orders SET order_state=? WHERE order_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, state);
			pstmt.setString(2, order_no);
			
			updateResult = pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return updateResult;
	}

	@Override // 배송 상세조회
	public List<DeliveryDTO> selectDeliveryDetail(String billing_number) {
		
		List<DeliveryDTO> dlist = new ArrayList<>();
		
		try {
			conn = dataSource.getConnection();
			
			String sql = "SELECT * FROM delivery"
					+    " WHERE billing_number=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, billing_number);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				do {
					DeliveryDTO dto = new DeliveryDTO();
					dto.setDelivery_no(rs.getString("delivery_no"));
					dto.setBilling_number(rs.getString("billing_number"));
					dto.setOrder_no(rs.getString("order_no"));
					dto.setDeliver_name(rs.getString("deliver_name"));
					dto.setDeliver_tel(rs.getString("deliver_tel"));
					dto.setZipcode(rs.getString("zipcode"));
					dto.setCurrent_location(rs.getString("current_location"));
					dto.setDelivery_day(rs.getDate("delivery_day"));
					dto.setDelivery_state(rs.getString("delivery_state"));
					
					dlist.add(dto);
					
				} while(rs.next());
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(dlist);
		
		
		return dlist;
	}

	// 전체 주문 개수 조회
	@Override
	public int selectOrderTotal() {
		System.out.println("selectOrderTotal() - dao");
		
		int total = 0;
		
		try {
			conn = dataSource.getConnection();
			
			String sql = "SELECT COUNT(*) total FROM orders";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			if (rs.next()) total = rs.getInt("total");
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return total;
	}
	
	@Override
	public int selectOrderTotal(String customer_id) {
		System.out.println("selectOrderTotal() - dao");
		
		int total = 0;
		
		try {
			conn = dataSource.getConnection();
			
			String sql = "SELECT COUNT(*) total FROM orders WHERE customer_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, customer_id);
			
			rs = pstmt.executeQuery();
			if (rs.next()) total = rs.getInt("total");
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return total;
	}

	
}