package com.yedam.review;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;

public class Review1DAO extends DAO {
	private static Review1DAO reviewDao = null;
	private Review1DAO() {
		
	}
	
	public static Review1DAO getInstance() {
		if(reviewDao ==null) {
			reviewDao = new Review1DAO();
		}
		return reviewDao;
	}
	
	//리뷰조회
	public List<Review1DTO> getReviewList(){
		List<Review1DTO> list = new ArrayList<>();
		Review1DTO review = null;
		try {
			conn();
			String sql = "select e.evaluation_id, e.order_id, e.evaluation_date, e.evaluation_title, e.evaluation_content, sd.sale_member\r\n"
					+ "from evaluation e, (select sale_id,sale_member from saledetail group by sale_id,sale_member) sd\r\n"
					+ "where e.order_id=sd.sale_id";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				review = new Review1DTO();
				
				review.setEvaluationId(rs.getInt("evaluation_id"));
				review.setOrderId(rs.getString("order_id"));
				review.setEvaluationDate(rs.getDate("evaluation_date"));
				review.setEvaluationTitle(rs.getString("evaluation_title"));
				review.setEvaluationContent(rs.getString("evaluation_content"));
				review.setMemberId(rs.getString("sale_member"));
				
				list.add(review);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return list;
	}
	
	//리뷰작성
	
	//리뷰수정
	public int reviewUpdate(Review1DTO review, int menuNo) {
		int result = 0;
		try {
			conn();
			if(menuNo ==1) {
				String sql = "update evaluation set evaluation_title=? where evaluation_id=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, review.getEvaluationTitle());
				pstmt.setInt(2, review.getEvaluationId());				
			}else if(menuNo ==2) {
				String sql = "update evaluation set evaluation_content=? where evaluation_id=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, review.getEvaluationContent());
				pstmt.setInt(2, review.getEvaluationId());				
			}
			if(result > 0) {
				System.out.println("수정성공");
			}else {
				System.out.println("수정실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}
	//리뷰삭제
	
	
}
