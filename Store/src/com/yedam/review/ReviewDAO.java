package com.yedam.review;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;

public class ReviewDAO extends DAO{
	private static ReviewDAO reviewDao = null;
	private ReviewDAO() {
		
	}
	
	public static ReviewDAO getInstance() {
		if(reviewDao ==null) {
			reviewDao = new ReviewDAO();
		}
		return reviewDao;
	}
	
	//리뷰조회
	public List<ReviewDTO> getReviewList(){
		List<ReviewDTO> list = new ArrayList<>();
		ReviewDTO review = null;
		try {
			conn();
			String sql = "select *\r\n"
					+ "from evaluation e LEFT JOIN answer a\r\n"
					+ "ON e.evaluation_id = a.evaluation_id ORDER BY(e.evaluation_date)";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				review = new ReviewDTO();
				
				review.setEvaluationId(rs.getInt("evaluation_id"));
				review.setOrderId(rs.getString("order_id"));
				review.setEvaluationDate(rs.getDate("evaluation_date"));
				review.setEvaluationMember(rs.getString("evaluation_member"));
				review.setEvaluationContent(rs.getString("evaluation_content"));
				
				review.setAnswerId(rs.getString("answer_id"));
				review.setAnswerDate(rs.getDate("answer_date"));
				review.setAnswerMember(rs.getString("answer_member"));
				review.setAnswerContent(rs.getString("answer_content"));
				
				
				list.add(review);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return list;
	}
	//리뷰 작성 중복 조회
	public ReviewDTO getCount(String order) {
		ReviewDTO review = null;
		try {
			conn();
			String sql = "select count(order_id)\r\n"
					+ "	from evaluation\r\n"
					+ "	where order_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, order);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				review = new ReviewDTO();
				review.setCount(rs.getInt("count(order_id)"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return review;
	}
	//리뷰작성
	public int reviewAdd(ReviewDTO review) {
		int result =0;
		try {
			conn();
			String sql = "insert into evaluation(evaluation_id, order_id, evaluation_member, evaluation_content) values(evaluation_seq.nextval, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, review.getOrderId());
			pstmt.setString(2, review.getEvaluationMember());
			pstmt.setString(3, review.getEvaluationContent());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}
	//답글작성
	public int answerAdd(ReviewDTO review) {
		int result =0;
		try {
			conn();
			String sql = "insert into answer(ANSWER_ID,EVALUATION_ID,ANSWER_MEMBER,ANSWER_CONTENT)  values(answer_seq.nextval, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, review.getEvaluationId());
			pstmt.setString(2, review.getAnswerMember());
			pstmt.setString(3, review.getAnswerContent());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}
	
	
	//리뷰수정
	public int reviewUpdate(ReviewDTO review) {
		int result = 0;
		try {
			conn();
			String sql = "update evaluation set evaluation_content=? where evaluation_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, review.getEvaluationContent());
			pstmt.setInt(2, review.getEvaluationId());
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}
	
	//답글수정
	public int answerUpdate(ReviewDTO review) {
		int result = 0;
		try {
			conn();
			String sql = "update answer set answer_content=? where answer_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, review.getAnswerContent());
			pstmt.setString(2, review.getAnswerId());
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}
	
	//답글 삭제
	public int answerDelete(int evalutionId) {
		int result =0;
		try {
			conn();
			String sql = "delete from answer where evaluation_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, evalutionId);
			result = pstmt.executeUpdate();
			if(result >0) {
				System.out.println("삭제성공");
			}else {
				System.out.println("실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}
	
	//리뷰삭제
	public int reviewDelete(int evalutionId) {
		int result2 =0;
		try {
			conn();
			String sql2 = "delete from evaluation where evaluation_id=?";
			pstmt = conn.prepareStatement(sql2);
			pstmt.setInt(1, evalutionId);
			result2 = pstmt.executeUpdate();
			if(result2 >0) {
				System.out.println("삭제성공");
			}else {
				System.out.println("실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result2;
	}
}
