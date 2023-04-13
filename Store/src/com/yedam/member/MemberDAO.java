package com.yedam.member;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;

public class MemberDAO extends DAO{
	private static MemberDAO memberDao = new MemberDAO();
	private MemberDAO() {
		
	}
	
	public static MemberDAO getInstance() {
		return memberDao;
	}
	
	//로그인
	public MemberDTO login(String id) {
		MemberDTO member = null;
		try {
			conn();
			String sql = "SELECT * FROM member WHERE member_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member = new MemberDTO();
				member.setMemberId(rs.getString("member_id"));
				member.setMemberPw(rs.getString("member_pw"));
				member.setMemberGrade(rs.getString("member_grade"));
				member.setMemberName(rs.getString("member_name"));
				member.setMemberPhone(rs.getString("member_phone"));
				member.setMemberAddr(rs.getString("member_addr"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return member;
	}
	
	
	
	//회원정보조회(관리자)
	public List<MemberDTO> getMemberList(){
		List<MemberDTO> list = new ArrayList<>();
		MemberDTO member = null;
		try {
			conn();
			String sql = "SELECT * FROM member";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				member = new MemberDTO();
				member.setMemberId(rs.getString("member_id"));
				member.setMemberPw(rs.getString("member_pw"));
				member.setMemberGrade(rs.getString("member_grade"));
				member.setMemberName(rs.getString("member_name"));
				member.setMemberPhone(rs.getString("member_phone"));
				member.setMemberAddr(rs.getString("member_addr"));
				
				list.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;
	}
	
	//회원수정
	//pw, 등급, 이름, 전화번호, 주소
	public int memberUpdate(MemberDTO member, String memberId, int menuNo) {
		int result = 0;
		try {
			conn();
			if(menuNo == 1) { //pw변경
				String sql = "UPDATE member SET member_pw=?  where member_id = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, member.getMemberPw());			
				pstmt.setString(2, memberId);
			}else if(menuNo == 2) { //이름 변경
				String sql = "UPDATE member SET member_name=?  where member_id = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, member.getMemberName());			
				pstmt.setString(2, memberId);
			}else if(menuNo == 3) { //전화번호 변경
				String sql = "UPDATE member SET member_phone=?  where member_id = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, member.getMemberPhone());			
				pstmt.setString(2, memberId);
			}else if(menuNo == 4) { //주소 변경
				String sql = "UPDATE member SET member_addr=?  where member_id = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, member.getMemberAddr());			
				pstmt.setString(2, memberId);
			}else if(menuNo == 5) { //등급 변경
				String sql = "UPDATE member SET member_grade=?  where member_id = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, member.getMemberGrade());			
				pstmt.setString(2, memberId);
			}
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	//회원탈퇴
	public int memberDelete(String memberId) {
		int result = 0;
		try {
			conn();
			
			String sql = "DELETE FROM member WHERE member_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}
	
	//회원가입
	public int memberAdd(MemberDTO member) {
		int result =0;
		try {
			conn();
			String sql = "insert into member(member_id, member_pw, member_name, member_phone, member_addr) values(?,?,?,?,?)";
			
			pstmt = conn.prepareCall(sql);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			pstmt.setString(3, member.getMemberName());
			pstmt.setString(4, member.getMemberPhone());
			pstmt.setString(5, member.getMemberAddr());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		
		return result;
	}
	//아이디중복체크
	public MemberDTO getMemberId(String memberId) {
		MemberDTO member = null;
		try {
			conn();
			String sql = "select count(member_id)\r\n"
					+ "from member\r\n"
					+ "where member_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				member = new MemberDTO();
				
				member.setCount(rs.getInt("count(member_id)"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return member;
	}
}
