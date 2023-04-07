package com.yedam.account;

import com.yedam.common.DAO;
import com.yedam.customer.CustomerService;

public class AccountDAO extends DAO{
	
	private static AccountDAO accountDao = null;
	
	private AccountDAO() {
		
	}
	
	public static AccountDAO getInstance() {
		if(accountDao == null) {
			accountDao = new AccountDAO();
		}
		return accountDao;
	}
	
//	계좌개설 - insert
	public int accountAdd(Account account) {
		int result =0;
		try {
			conn();
			//시퀀스
			String sql = "insert into account values (?,?,?,sysdate)";
			
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, account.getAccountId());
			pstmt.setInt(2, account.getCustomerId());
			pstmt.setInt(3, account.getBalance());
			
			result = pstmt.executeUpdate();
			
			//sql 하나 더
//			if(result == 1) {
//				String sql2 = "update customer set account_id =? where customer_id=?";
//				pstmt = conn.prepareStatement(sql2);
//				pstmt.setInt(1, account.getAccountId());
//				pstmt.setInt(2, account.getCustomerId());
//				
//				int result2 = pstmt.executeUpdate();
//				if(result2 == 1) {
//					System.out.println("고객 계좌 등록 완료");
//				}else {
//					System.out.println("고객 계좌 등록 실패");
//				}
//			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		
		return result;
	}
//	계좌해지 - update, delete
//	계좌를 당장 삭제 X -> 3개월 뒤에 삭제 또는 해지한 히스토리 관리
//	update -> column 활성화/사용유무 -> Y, N, L
	public int accountDelete(int accountId) {
		int result = 0;
		try {
			conn();
			
			String sql = "delete from account where account_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, accountId);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}
	
	//계좌 조회 -JOIN활용
	public Account getAccount() {
		Account account = null;
		try {
			conn();
			
			String sql = "SELECT c.customer_id, c.customer_name, a.account_id, a.balance, a.credate\r\n"
					+ "FROM customer c JOIN account a\r\n"
					+ "ON(c.customer_id = a.customer_id)\r\n"
					+ "WHERE c.customer_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, CustomerService.customerInfo.getCustomerId());
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				account = new Account();
				account.setAccountId(rs.getInt("customer_id"));
				account.setCustomerName(rs.getString("customer_name"));
				account.setAccountId(rs.getInt("account_id"));
				account.setBalance(rs.getInt("balance"));
				account.setCredate(rs.getDate("credate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return account;
	}
	
	//입출금
	public int updateMooney(Account account, int cmd) {
		int result =0;
		int balance = 0;
		try {
			conn();
			//현재 잔고를 가져오는 sql
			String sql = "select balance from account where account_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, account.getAccountId());
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				balance = rs.getInt("balance");
			}
			
			//1: 입금
			//2: 출금
			if(cmd == 1) {
				//balance = 현재 잔고
				//현재 잔고 + 입금 금액 = 통장 잔고
				//account.getbalance() + balance => 통장잔고
//				account.setBalance(balance+ account.getBalance());
				
				String sql2 = "update account set balance = balance +? where account_id=?";
				pstmt = conn.prepareStatement(sql2);
				pstmt.setInt(1, account.getBalance());
				pstmt.setInt(2, account.getAccountId());
				
				result = pstmt.executeUpdate();
			}else if(cmd == 2) {
				//잔고 >=출금액
				if(balance - account.getBalance() >=0) {
					String sql2 = "update account set balance = balance - ? where account_id=?";
					pstmt = conn.prepareStatement(sql2);
					pstmt.setInt(1, account.getBalance());
					pstmt.setInt(2, account.getAccountId());
					result = pstmt.executeUpdate();
				}else {
					System.out.println("잔고보다 출금액이 많습니다.");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}
}
