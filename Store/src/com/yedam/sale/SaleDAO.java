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
			String sql = "SELECT * FROM sale";
			stmt = conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				sale = new SaleDTO();
				sale.setSaleId(rs.getInt("sale_id"));
				sale.setSaleMember(rs.getString("sale_member"));
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
	
	//주문내역(사용자)
	public List<SaleDTO> getSale(String saleMember){
		List<SaleDTO> list = new ArrayList<>();
		SaleDTO sale = null;
		try {
			conn();
			String sql = "SELECT * FROM sale WHERE sale_member=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, saleMember);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				sale = new SaleDTO();
				sale.setSaleId(rs.getInt("sale_id"));
				sale.setSaleMember(rs.getString("sale_member"));
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
	
	//메뉴선택
	public int menuSelec(SaleDTO sale) {
		int result = 0;
		try {
			conn();
			String sql = "insert into saledetail(SALEDETAIL_ID,MENU_ID,SALEDETAIL_QTY,SALEDETAIL_PRICE) values(saledetail_seq.nextval, ?, ?,?*(select menu_price from menu where menu_id=?))";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, sale.getMenuId());
			pstmt.setInt(2, sale.getSaledetailQty());
			pstmt.setInt(3, sale.getSaledetailQty());
			pstmt.setInt(4, sale.getMenuId());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}
	
	//주문하기(사용자)
	public int saleAdd(SaleDTO sale) {
		int result = 0;
		try {
			conn();
			
			String sql = "insert into sale(sale_id, sale_member, sale_pay, sale_confirm) values(?, ?, '결제완료', '주문확인중')";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, sale.getSaleId());
			pstmt.setString(2, sale.getSaleMember());
			result = pstmt.executeUpdate();
			
			if(result ==1) {
				String sql2 = "update saledetail set sale_id = ? where sale_id is null";
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, sale.getSaleId());
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
	public int saleDelete(SaleDTO sale) {
		int result = 0;
		try {
			conn();
			String sql = "delete from saledetail where sale_id is null";
			pstmt=conn.prepareStatement(sql);
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
			pstmt.setInt(1, sale.getSaleId());
			
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
			pstmt.setInt(1, sale.getSaleId());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}
	//주문취소(관리자)
	public int saleCancelup(SaleDTO sale) {
		int result =0;
		try {
			conn();
			String sql = "UPDATE sale set sale_cancel = '취소완료', sale_pay = '-', sale_confirm = '-' where sale_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sale.getSaleId());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}
	
	
	
}
