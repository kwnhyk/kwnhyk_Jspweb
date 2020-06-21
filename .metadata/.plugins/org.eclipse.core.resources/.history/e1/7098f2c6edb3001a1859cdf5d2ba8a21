package evaluation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DatabaseUtil;

public class EvaluationDAO {
public int write(EvaluationDTO evaluationDTO) {
		
		
		String SQL = "INSERT INTO EVALUATION VALUES (NULL, ?,?,?,?,?,?,?,?,?,?,?,?,0)";
		
		Connection conn= null;
				
		PreparedStatement pstmt = null;		
		ResultSet rs = null;
		try {
			conn= DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(1).equals(userPassword)) {
					return 1; //성공
				}
				else {
					return 0;//비번 틀림
				}
			}
			return -1 ;//아이디 없음
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try{
				if(conn !=null) conn.close();
				} catch(Exception e) {
					e.printStackTrace();
			}
			try{
				if(pstmt !=null) pstmt.close();
				} catch(Exception e) {
					e.printStackTrace();
			}
			try{
				if(rs !=null) rs.close();
				} catch(Exception e) {
					e.printStackTrace();
			}
		}
		return -2;//데이터베이스 오류
	}
}
