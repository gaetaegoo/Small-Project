package useditem.model;

import java.sql.SQLException;
import java.util.ArrayList;

import useditem.exception.NotExistException;
import useditem.model.dto.BuyerDTO;
import useditem.model.dto.SellerDTO;
import useditem.model.dto.UsedItemDTO;
import useditem.model.dto.UsedItemUploadDTO;

public class UsedItemService {

	private static UsedItemService instance = new UsedItemService();
	private UsedItemService() {}
	public static UsedItemService getInstance() {
		return instance;
	}

	// �߰� ���� - CRUD
	public static void notExistUsedItem(String usedItemId) throws SQLException, NotExistException {
		UsedItemDTO usedItem = UsedItemDAO.getUsedItem(usedItemId);
		if (usedItem == null) {
			throw new NotExistException("�˻��Ͻ� ���� ID�� �����ϴ�.");
		}
	}

	// ��� �ŷ� ���� ��ȯ
	public static ArrayList<UsedItemDTO> getAllUsedItems() throws SQLException {
		return UsedItemDAO.getAllUsedItems();
	}

	// ���� ID�� �˻�
	public static UsedItemDTO getUsedItem(String usedItemId) throws SQLException, NotExistException {
		UsedItemDTO usedItem = UsedItemDAO.getUsedItem(usedItemId);
		if (usedItem == null) {
			throw new NotExistException("�˻��Ͻ� ���� ������ �����ϴ�.");
		}
		return usedItem;
	}

	// ���ο� ���� ����
	public static boolean addUsedItem(UsedItemDTO usedItem) throws SQLException {
		return UsedItemDAO.addUsedItem(usedItem);
	}

	// ���� ���� ���� ����
	public static boolean updateUsedItemPrice(String usedItemId, String usedItemPrice)
			throws SQLException, NotExistException {
		notExistUsedItem(usedItemId);
		return UsedItemDAO.updateUsedItemPrice(usedItemId, usedItemPrice);
	}

	// ���� ���� �ŷ� ���� ����
	public static boolean updateDealStatus(String usedItemId, String dealStatus)
			throws SQLException, NotExistException {
		notExistUsedItem(usedItemId);
		return UsedItemDAO.updateDealStatus(usedItemId, dealStatus);
	}

	// ���� ����
	public boolean deleteUsedItem(String usedItemId) throws SQLException, NotExistException {
		notExistUsedItem(usedItemId);
		return UsedItemDAO.deleteUsedItem(usedItemId);
	}

	// �Ǹ��� - CRUD
	public static void notExistSeller(String sellerId) throws SQLException, NotExistException {
		SellerDTO seller = SellerDAO.getSeller(sellerId);
		if (seller == null) {
			throw new NotExistException("�˻��ϴ� �Ǹ��ڰ� �������� �ʽ��ϴ�.");
		}
	}

	// �Ǹ��� �߰�
	public static boolean addSeller(SellerDTO seller) throws SQLException {
		return SellerDAO.addSeller(seller);
	}

	// ���� �Ǹ��� ��� �ŷ� ���� ����
	public static boolean updateSeller(String sellerId, String dealType) throws SQLException, NotExistException {
		notExistUsedItem(sellerId);
		return SellerDAO.updateSeller(sellerId, dealType);
	}

	// �Ǹ��� ����
	public static boolean deleteSeller(String sellerId) throws SQLException, NotExistException {
		notExistSeller(sellerId);
		return SellerDAO.deleteSeller(sellerId);
	}

	// �Ǹ��� ID�� �˻�
	public static SellerDTO getSeller(String sellerId) throws SQLException, NotExistException {
		SellerDTO seller = SellerDAO.getSeller(sellerId);
		if (seller == null) {
			throw new NotExistException("�˻��ϴ� �Ǹ��ڰ� �������� �ʽ��ϴ�.");
		}
		return seller;
	}

	public static ArrayList<SellerDTO> getAllSellers() throws SQLException {
		return SellerDAO.getAllSellers();
	}

	// ������ - CRUD
	public static void notExistBuyer(String buyerId) throws SQLException, NotExistException {
		BuyerDTO buyer = BuyerDAO.getBuyer(buyerId);
		if (buyer == null) {
			throw new NotExistException("�˻��ϴ� �����ڰ� �������� �ʽ��ϴ�.");
		}
	}

	// ������ �߰�
	public static boolean addBuyer(BuyerDTO buyer) throws SQLException {
		return BuyerDAO.addBuyer(buyer);
	}

	// ���� ������ ��� �ŷ� ���� ����
	public static boolean updateBuyer(String buyerId, String dealType) throws SQLException, NotExistException {
		notExistBuyer(buyerId);
		return BuyerDAO.updateBuyer(buyerId, dealType);
	}

	// ������ ����
	public static boolean deleteBuyer(String buyerId) throws SQLException, NotExistException {
		notExistBuyer(buyerId);
		return BuyerDAO.deleteBuyer(buyerId);
	}

	// ������ ID�� �˻�
	public static BuyerDTO getBuyer(String buyerId) throws SQLException, NotExistException {
		BuyerDTO buyer = BuyerDAO.getBuyer(buyerId);
		if (buyer == null) {
			throw new NotExistException("�˻��ϴ� �����ڰ� �������� �ʽ��ϴ�.");
		}
		return buyer;
	}

	public static ArrayList<BuyerDTO> getAllBuyers() throws SQLException {
		return BuyerDAO.getAllBuyers();
	}

	// UsedItemUserDAO - CRUD
	public static void notExistUsedItemUser(int usedItemUserId) throws SQLException, NotExistException {
		UsedItemUploadDTO usedItemUser = UsedItemUploadDAO.getUsedItemUpload(usedItemUserId);
		if (usedItemUser == null) {
			throw new NotExistException("�˻��ϴ� �߰� �ŷ��� �����ϴ�.");
		}
	}

	public static boolean addUsedItemUser(UsedItemUploadDTO usedItemUser) throws SQLException {
		return UsedItemUploadDAO.addUsedItemUpload(usedItemUser);
	}

	public static boolean updateUsedItemUserSeller(int usedItemUserId, String sellerId)
			throws SQLException, NotExistException {
		notExistUsedItemUser(usedItemUserId);
		return UsedItemUploadDAO.updateUsedItemUploadSeller(usedItemUserId, sellerId);
	}

	public static boolean updateUsedItemUserBuyer(int usedItemUserId, String buyerId)
			throws SQLException, NotExistException {
		notExistUsedItemUser(usedItemUserId);
		return UsedItemUploadDAO.updateUsedItemUploadBuyer(usedItemUserId, buyerId);
	}

	public static boolean deleteUsedItemUser(int usedItemUserId) throws SQLException, NotExistException {
		notExistUsedItemUser(usedItemUserId);
		return UsedItemUploadDAO.deleteUsedItemUpload(usedItemUserId);
	}

	// �߰� ���� ���ε� ID�� �˻�
	public static UsedItemUploadDTO getUsedItemUser(int usedItemUserId) throws SQLException, NotExistException {
		UsedItemUploadDTO usedItemUser = UsedItemUploadDAO.getUsedItemUpload(usedItemUserId);
		if (usedItemUser == null) {
			throw new NotExistException("�˻��ϴ� �߰� ���ǿ� �ش��ϴ� ���� �����ϴ�.");
		}
		return usedItemUser;
	}

	public static ArrayList<UsedItemUploadDTO> getAllUsedItemUsers() throws SQLException {
		return UsedItemUploadDAO.getAllUsedItemUploads();
	}

}
