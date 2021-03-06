package day0108;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import kr.co.sist.connection.GetConnection;

/**
 *	ResultSetMetaData : 실행되는 조회 쿼리문을 사용하여 컬럼 정보를 얻을 때 사용하는 interface
 * @author owner
 */
public class UseResultSetMetaData {

	public UseResultSetMetaData() throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		
		try {
			//1. 드라이버 로딩 
			//2. Connection 얻기
			GetConnection gc = GetConnection.getInstance();
			String url="jdbc:oracle:thin:@localhost:1521:orcl";
			String id="scott";
			String pass="tiger";
			con=gc.getConn(url, id, pass);
			//3. 쿼리문 생성 객체 얻기
			String selectEmp = "select * from emp";
			pstmt=con.prepareStatement( selectEmp );
			//4. 
			
			//5.
			rs = pstmt.executeQuery();

			rsmd = rs.getMetaData();
			//컬럼의 정보 얻기
			
			int cnt = rsmd.getColumnCount(); // 컬럼의 수 얻기
			System.out.println("컬럼의 수 : " + cnt);
			
//			String columnName = rsmd.getColumnName(1); // 해당 컬럼의 이름 얻기1
			String columnName = rsmd.getColumnLabel(1); // 해당 컬럼의 이름 얻기2(getColumnName(index)와 같은 결과)
			System.out.println("처음 컬럼의 컬럼명 : " + columnName);
			
			String columnType = rsmd.getColumnTypeName(1);
			System.out.println("처음 컬럼의 데이터형 : " + columnType);
			
			int columnPrecision = rsmd.getPrecision(1);
			System.out.println("처음 컬럼의 데이터형 크기 : " + columnPrecision);
			
			System.out.println("----------------------------------------------------------");
			
			StringBuilder output = new StringBuilder();
			
			for(int i=1; i < cnt+1; i++) {
				output
				.append(rsmd.getColumnLabel(i)).append("\t")
				.append(rsmd.getColumnTypeName(i)).append("(")
				.append(rsmd.getPrecision(i)).append(")\n");
			}//end for
			
			System.out.println( output );
			
		} finally {
			//6.
			if( rs != null ) { rs.close(); }//end if
			if( pstmt != null ) { pstmt.close(); }//end if
			if( con != null ) { con.close(); }//end if
		}//end finally
	}//UseResultSetMetaData
	
	public static void main(String[] args) {
		try {
			new UseResultSetMetaData();
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
	}//main
	
}//class
