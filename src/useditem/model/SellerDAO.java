package useditem.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import useditem.model.dto.SellerDTO;
import useditem.model.util.DBUtil;

public class SellerDAO {
	
	private static Properties sql = DBUtil.getSql();

	// 판매자 추가
	public static boolean addSeller(SellerDTO seller) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("addSeller"));
			pstmt.setString(1, seller.getId());
			pstmt.setString(2, seller.getName());
			pstmt.setString(3, seller.getPhone());
			pstmt.setString(4, seller.getLoc());
			pstmt.setString(5, seller.getGrade());
			pstmt.setString(6, seller.getItem());
			pstmt.setString(7, seller.getDealType());
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// 판매자 수정 - 판매자 ID로 거래 유형 수정
	public static boolean updateSeller(String sellerId, String dealType) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("updateSeller"));
			pstmt.setString(1, dealType);
			pstmt.setString(2, sellerId);
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// 판매자 삭제 - 판매자 ID로 판매자 삭제
	public static boolean deleteSeller(String sellerId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("deleteSeller"));
			pstmt.setString(1, sellerId);
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// 특정 판매자 검색 - 판매자 ID로 해당 판매자 정보 검색
	public static SellerDTO getSeller(String sellerId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		SellerDTO seller = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("getSeller"));
			pstmt.setString(1, sellerId);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				seller = new SellerDTO(rset.getString(1), 
									   rset.getString(2), 
									   rset.getString(3), 
									   rset.getString(4),
									   rset.getString(5), 
									   rset.getString(6), 
									   rset.getString(7));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return seller;
	}

	// 모든 판매자 검색
	public static ArrayList<SellerDTO> getAllSellers() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<SellerDTO> list = null;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("getAllSellers"));
			rset = pstmt.executeQuery();

			list = new ArrayList<SellerDTO>();
			while (rset.next()) {
				list.add(new SellerDTO(rset.getString(1), 
						   			   rset.getString(2), 
						   			   rset.getString(3), 
						   			   rset.getString(4), 
						   			   rset.getString(5), 
						   			   rset.getString(6), 
						   			   rset.getString(7)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
	
}