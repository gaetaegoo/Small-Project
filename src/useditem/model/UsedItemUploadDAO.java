package useditem.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import useditem.model.dto.UsedItemUploadDTO;
import useditem.model.util.DBUtil;

public class UsedItemUploadDAO {
	
	private static Properties sql = DBUtil.getSql();

	// 중고 물건 거래 글 추가
	public static boolean addUsedItemUpload(UsedItemUploadDTO usedItemUpload) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("addUsedItemUpload"));
			pstmt.setString(1, usedItemUpload.getUsedItemUploadName());
			pstmt.setString(2, usedItemUpload.getUsedItemId());
			pstmt.setString(3, usedItemUpload.getSellerId());
			pstmt.setString(4, usedItemUpload.getBuyerId());

			int result = pstmt.executeUpdate();

			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// 중고 물건 거래 글 판매자 수정
	public static boolean updateUsedItemUploadSeller(int usedItemUploadId, String sellerId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("updateUsedItemUploadSeller"));
			pstmt.setString(1, sellerId);
			pstmt.setInt(2, usedItemUploadId);

			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// 중고 물건 거래 글 구매자 수정
	public static boolean updateUsedItemUploadBuyer(int usedItemUploadId, String buyerId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBUtil.getConnection();

			pstmt = con.prepareStatement(sql.getProperty("updateUsedItemUploadBuyer"));
			pstmt.setString(1, buyerId);
			pstmt.setInt(2, usedItemUploadId);

			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// 중고 물건 거래 완료 후 글 삭제
	public static boolean deleteUsedItemUpload(int usedItemUploadId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("deleteUsedItemUpload"));
			pstmt.setInt(1, usedItemUploadId);
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// 중고 물건 거래 글 ID로 특정 거래 검색
	public static UsedItemUploadDTO getUsedItemUpload(int usedItemUploadId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		UsedItemUploadDTO usedItemUser = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("getUsedItemUpload"));
			pstmt.setInt(1, usedItemUploadId);
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				usedItemUser = new UsedItemUploadDTO(rset.getInt(1), 
													 rset.getString(2), 
													 rset.getString(3),
													 rset.getString(4), 
													 rset.getString(5));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return usedItemUser;
	}

	// 모든 중고 물건 거래 글 검색
	public static ArrayList<UsedItemUploadDTO> getAllUsedItemUploads() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<UsedItemUploadDTO> list = null;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("getAllUsedItemUploads"));
			rset = pstmt.executeQuery();
			list = new ArrayList<UsedItemUploadDTO>();
			
			while (rset.next()) {
				list.add(new UsedItemUploadDTO(rset.getInt(1), 
											   rset.getString(2), 
											   rset.getString(3),
											   rset.getString(4), 
											   rset.getString(5)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
	
}
