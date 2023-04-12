package com.yedam.sale;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;

public class SaleDAO extends DAO{
	private static SaleDAO saleDao = null;
	private SaleDAO() {
		
	}
	public static SaleDAO getInstance() {
		if(saleDao == null) {
			saleDao = new SaleDAO();
		}
		return saleDao;
	}
	
	//주문내역(관리자)
	public List<SaleDTO> getSaleList(){
		List<SaleDTO> list = new ArrayList<>();
		SaleDTO sale = null;
		try {
			conn();
			String sql = "select s.sale_id, sd.sale_member, sd.price, s.sale_date, s.sale_pay, s.sale_cancel, s.sale_confirm\r\n"
					+ "from sale s, (select sale_id, sale_member, sum(saledetail_price) price\r\n"
					+ "                from saledetail\r\n"
					+ "                group by sale_id, sale_member) sd\r\n"
					+ "where s.sale_id = sd.sale_id";
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				sale = new SaleDTO();
				sale.setSaleId(rs.getString("sale_id"));
				sale.setSaleMember(rs.getString("sale_member"));
				sale.setSum(rs.getInt("price"));
				sale.setSaleDate(rs.getDate("sale_date"));
				sale.setSalePay(rs.getString("sale_pay"));
				sale.setSaleCancel(rs.getString("sale_cancel"));
				sale.setSaleConfirm(rs.getString("sale_confirm"));
				
				list.add(sale);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return list;
	}
	public List<SaleDTO> getSaledetailList(String saleId){
		List<SaleDTO> list = new ArrayList<>();
		SaleDTO sale = null;
		try {
			conn();
			String sql = "select menu_name, saledetail_qty\r\n"
					+ "from menu m, saledetail sd\r\n"
					+ "where m.menu_id = sd.saledetail_menu\r\n"
					+ "and sd.sale_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, saleId);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				sale = new SaleDTO();
				sale.setMenuName(rs.getString("menu_name"));
				sale.setSaledetailQty(rs.getInt("saledetail_qty"));
				
				list.add(sale);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return list;
	}
	
	//주문내역(사용자)
	public List<SaleDTO> getSale(String saleMember){
		List<SaleDTO> list = new ArrayList<>();
		SaleDTO sale = null;
		try {
			conn();
			String sql = "select s.sale_id, sd.price, s.sale_date, s.sale_pay, s.sale_cancel, s.sale_confirm\r\n"
					+ "from sale s, (select sale_id, sale_member, sum(saledetail_price) price\r\n"
					+ "                from saledetail\r\n"
					+ "                group by sale_id, sale_member) sd\r\n"
					+ "where s.sale_id = sd.sale_id\r\n"
					+ "and sd.sale_member = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, saleMember);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				sale = new SaleDTO();
				sale.setSaleId(rs.getString("sale_id"));
				sale.setSum(rs.getInt("price"));
				sale.setSaleDate(rs.getDate("sale_date"));
				sale.setSalePay(rs.getString("sale_pay"));
				sale.setSaleCancel(rs.getString("sale_cancel"));
				sale.setSaleConfirm(rs.getString("sale_confirm"));
				
				list.add(sale);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return list;
	}
	public List<SaleDTO> getSaledetail(String saleId){
		List<SaleDTO> list = new ArrayList<>();
		SaleDTO sale = null;
		try {
			conn();
			String sql = "select m.menu_name, sd.saledetail_qty, sd.saledetail_price\r\n"
					+ "from menu m, saledetail sd\r\n"
					+ "where m.menu_id = sd.saledetail_menu\r\n"
					+ "and sd.sale_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, saleId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				sale = new SaleDTO();
				sale.setMenuName(rs.getString("menu_name"));
				sale.setSaledetailQty(rs.getInt("saledetail_qty"));
				sale.setSaledetailPrice(rs.getInt("saledetail_price"));
				
				list.add(sale);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return list;
	}
	
	
	//메뉴선택
	public int menuSelec(SaleDTO sale) {
		int result = 0;
		try {
			conn();
			String sql = "insert into saledetail(SALEDETAIL_ID, SALE_MEMBER, SALEDETAIL_MENU, SALEDETAIL_QTY, SALEDETAIL_PRICE) \r\n"
					+ "values(saledetail_seq.nextval, ?, ?, ?, ?*(select menu_price from menu where menu_id=?))";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, sale.getSaleMember());
			pstmt.setInt(2, sale.getMenuId());
			pstmt.setInt(3, sale.getSaledetailQty());
			pstmt.setInt(4, sale.getSaledetailQty());
			pstmt.setInt(5, sale.getMenuId());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}
	
	//결제하기(선택한메뉴출력)
	public List<SaleDTO> getSaleAddList(String memberId){
		List<SaleDTO> list = new ArrayList<>();
		SaleDTO sale = null;
		try {
			conn();
			String sql = "SELECT m.menu_name, s.saledetail_qty, s.saledetail_price\r\n"
					+ "FROM saledetail s LEFT OUTER JOIN menu m\r\n"
					+ "ON (s.saledetail_menu = m.menu_id)\r\n"
					+ "WHERE s.sale_member = ?\r\n"
					+ "AND sale_id is null";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				sale = new SaleDTO();
				
				sale.setMenuName(rs.getString("menu_name"));
				sale.setSaledetailQty(rs.getInt("saledetail_qty"));
				sale.setSaledetailPrice(rs.getInt("saledetail_price"));
				
				list.add(sale);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return list;
	}
	//주문하기(결제)
	public int saleAdd(SaleDTO sale) {
		int result = 0;
		try {
			conn();
			
			String sql = "insert into sale(sale_id, sale_pay, sale_confirm) \r\n"
					+ "values(?, '결제완료', '주문확인중')";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,sale.getSaleId());
			result = pstmt.executeUpdate();
			
			if(result ==1) {
				String sql3 = "update saledetail \r\n"
						+ "set sale_id = ? \r\n"
						+ "where sale_member = ?\r\n"
						+ "AND sale_id is null";
				pstmt=conn.prepareStatement(sql3);
				pstmt.setString(1, sale.getSaleId());
				pstmt.setString(2, sale.getSaleMember());
				int result2 = pstmt.executeUpdate();
				if(result2 >0) {
					System.out.println("업데이트완료");
				}else {
					System.out.println("업데이트 실패");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}
	
	//주문에서 나오면 결제안된 메뉴 삭제
	public int saleDelete(String memberId) {
		int result = 0;
		try {
			conn();
			String sql = "delete from saledetail where sale_member = ? and sale_id is null";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	//주문받기(관리자)
	public int saleOrder(SaleDTO sale) {
		int result =0;
		try {
			conn();
			String sql = "UPDATE sale set sale_confirm = '주문완료' where sale_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sale.getSaleId());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}
	//주문취소(사용자)
	public int saleCancel(SaleDTO sale) {
		int result =0;
		try {
			conn();
			String sql = "UPDATE sale set sale_cancel = '취소확인중' where sale_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sale.getSaleId());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}
	//취소가능주문내역
//	public List<SaleDTO> getCancelList(String saleMember) {
//		List<SaleDTO> list = new ArrayList<>();
//		SaleDTO sale = null;
//		try {
//			conn();
//			String sql = "select s.sale_id, sd.price, s.sale_date, s.sale_pay, s.sale_cancel, s.sale_confirm\r\n"
//					+ "from sale s, (select sale_id, sale_member, sum(saledetail_price) price\r\n"
//					+ "                from saledetail\r\n"
//					+ "                group by sale_id, sale_member) sd\r\n"
//					+ "where s.sale_id = sd.sale_id\r\n"
//					+ "and sale_pay = '결제완료'\r\n"
//					+ "and sale_confirm = '주문확인중'\r\n"
//					+ "and sd.sale_member = ?";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, saleMember);
//			rs=pstmt.executeQuery();
//			
//			while(rs.next()) {
//				sale = new SaleDTO();
//				sale.setSaleId(rs.getString("sale_id"));
//				sale.setSaleDate(rs.getDate("sale_date"));
//				sale.setSalePay(rs.getString("sale_pay"));
//				sale.setSaleCancel(rs.getString("sale_cancel"));
//				sale.setSaleConfirm(rs.getString("sale_confirm"));
//				
//				list.add(sale);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			disconn();
//		}
//		return list;
//	}
	
	//주문취소(관리자)
	public int saleCancelup(SaleDTO sale) {
		int result =0;
		try {
			conn();
			String sql = "UPDATE sale set sale_cancel = '취소완료', sale_pay = 'N', sale_confirm = 'N' where sale_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sale.getSaleId());
			
			result = pstmt.executeUpdate();
			if(result ==1) {
				String sql2 = "update saledetail set saledetail_price=0 where sale_id=?";
				pstmt = conn.prepareStatement(sql2);
				pstmt.setString(1, sale.getSaleId());
				
				pstmt.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}
	
	//일일매출
	public SaleDTO getDaySale() {
		SaleDTO sale = null;
		try {
			conn();
			String sql = "select sum(saledetail_price) as day\r\n"
					+ "from (select s.sale_id, s.sale_date, sd.saledetail_price\r\n"
					+ "    from sale s, saledetail sd\r\n"
					+ "    where s.sale_id = sd.sale_id)\r\n"
					+ "where to_char(sale_date,'yy/mm/dd') = (SELECT TO_CHAR(SYSDATE, 'YY/MM/DD') FROM DUAL)";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				sale = new SaleDTO();
				
				sale.setSaleday(rs.getInt("day"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return sale;
	}
	//월매출
	public SaleDTO getMonthSale(String month) {
		SaleDTO sale = null;
		try {
			conn();
			String sql = "select sum(saledetail_price) as mon\r\n"
					+ "from (select s.sale_id, s.sale_date, sd.saledetail_price\r\n"
					+ "    from sale s, saledetail sd\r\n"
					+ "    where s.sale_id = sd.sale_id)\r\n"
					+ "where to_char(sale_date,'yy/mm') = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, month);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				sale = new SaleDTO();
				
				sale.setSalemon(rs.getInt("mon"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return sale;
	}
	
}
