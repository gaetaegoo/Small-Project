package useditem.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Scanner;

import log4j.Log;
import useditem.exception.NotExistException;
import useditem.model.BuyerDAO;
import useditem.model.SellerDAO;
import useditem.model.UsedItemDAO;
import useditem.model.UsedItemService;
import useditem.model.UsedItemUploadDAO;
import useditem.model.dto.UsedItemUploadDTO;
import useditem.view.RunEndView;

public class UsedItemController {

	private static UsedItemController instance = new UsedItemController();
	private UsedItemController() {}
	public static UsedItemController getInstance() {
		return instance;
	}

	// ��� �߰�ŷ� �˻�
	public static void getAllUsedItemUploads() {
		try {
			RunEndView.uploadListView(UsedItemUploadDAO.getAllUsedItemUploads());
		} catch (SQLException e) {
			e.printStackTrace();
			RunEndView.showError("��� �߰� �ŷ� �˻� �� ������ �߻��߽��ϴ�.");
		}
	}

	// ���ο� �߰� �ŷ� ����
	public static boolean addUsedItemUpload(UsedItemUploadDTO usedItemUpload) {
		boolean result = false;
		try {
			result = UsedItemUploadDAO.addUsedItemUpload(usedItemUpload);
			Log.uploadCheck("Success", usedItemUpload);
		} catch (SQLException e) {
			e.printStackTrace();
			RunEndView.showError("��� �߰� �ŷ� ���� �� ������ �߻��߽��ϴ�.");
		}
		return result;
	}

	// ��� �߰� ���� �˻�
	public static void getAllUsedItems() {
		try {
			RunEndView.uploadListView(UsedItemDAO.getAllUsedItems());
		} catch (SQLException e) {
			e.printStackTrace();
			RunEndView.showError("��� �߰� ���� �˻� �� ������ �߻��߽��ϴ�.");
		}
	}
	
	// �߰� ���� ���̵�� ���� �˻�
	public static void getUsedItem(String usedItemId) {
		try {
			RunEndView.allView(UsedItemDAO.getUsedItem(usedItemId));
		} catch (SQLException e) {
			e.printStackTrace();
			RunEndView.showError("���� ID�� �ش� �߰� ���� �˻� ����");
		}
	}

	// ��� �Ǹ��� �˻�
	public static void getAllSellers() {
		try {
			RunEndView.uploadListView(SellerDAO.getAllSellers());
		} catch (SQLException e) {
			e.printStackTrace();
			RunEndView.showError("��� �Ǹ��� �˻� �� ������ �߻��߽��ϴ�.");
		}
	}

	// ��� ������ �˻�
	public static void getAllBuyers() {
		try {
			RunEndView.uploadListView(BuyerDAO.getAllBuyers());
		} catch (SQLException e) {
			e.printStackTrace();
			RunEndView.showError("��� ������ �˻� �� ������ �߻��߽��ϴ�.");
		}
	}

	// �߰� ���� ���̵�� ���� ���� ����
	public static void updateUsedItemPrice(String usedItemId, String usedItemPrice) {
		try {
			boolean r = UsedItemService.updateUsedItemPrice(usedItemId, usedItemPrice);
			RunEndView.updateView(r, usedItemId);
			Log.itemPriceUpdateCheck("Success", usedItemId, usedItemPrice);
		} catch (SQLException e) {
			e.printStackTrace();
			RunEndView.showError("�Է��� ID�� ���� ���� ����, ��õ� �ϼ���!");
		} catch (NotExistException e) {
			e.printStackTrace();
			RunEndView.showError("�Է��� ID Ȯ�� �� ��õ� �ϼ���!");
		}
	}

	// �߰� ���� ���̵�� ���� �ŷ� ���� ����
	public static void updateUsedItemStatus(String usedItemId, String usedItemStatus) {
		try {
			boolean r = UsedItemService.updateDealStatus(usedItemId, usedItemStatus);
			RunEndView.updateView(r, usedItemId);
			Log.itemPriceUpdateCheck("Success", usedItemId, usedItemStatus);
		} catch (SQLException e) {
			e.printStackTrace();
			RunEndView.showError("���� ID�� �ŷ� ���� ���� ����, ��õ� �ϼ���!");
		} catch (NotExistException e) {
			e.printStackTrace();
			RunEndView.showError("�Է��� ID Ȯ�� �� ��õ� �ϼ���!");
		}
	}

	// ���� �޴�
	public void createMenu() {
		Scanner scan = new Scanner(System.in);
		BufferedReader search = new BufferedReader(new InputStreamReader(System.in));

		boolean finish = false;
		while (!finish) {
			System.out.println("\n  [[ W.E.L.C.O.M.E '�� �� �� ��' ]]\n"
								+ "=================================="
								+ "\n  �� �� �� ���ϴ� �׸��� ����:D �� �� ��\n"
								+ "\n 1. ��� �߰� �ŷ� �˻�"
								+ "\n 2. ��� �߰� ���� �˻�"
								+ "\n 3. Ư�� �߰� ���� �˻�"
								+ "\n"
								+ "\n 4. ��� �Ǹ��� �˻�"
								+ "\n 5. ��� ������ �˻�"
								+ "\n"
								+ "\n 6. ���� ���� ���� �� ��˻�"
								+ "\n 7. �ŷ� ���� ���� �� ��˻�"
								+ "\n"
								+ "\n 0. SYSTEM ����"
								+ "\n==================================\n");
			try {
				int number = scan.nextInt();

				if (number == 1) {
					System.out.println("�� ��� �߰�ŷ� ����Ʈ�Դϴ� ��");
					UsedItemController.getAllUsedItemUploads();
				}
				if (number == 2) {
					System.out.println("�� ��� �߰��� ����Ʈ�Դϴ� ��");
					UsedItemController.getAllUsedItems();
				}
				if (number == 3) {
					System.out.println("�� ������ ID�� �Է��ϼ��� ��");
					String itemId = search.readLine();
					UsedItemController.getUsedItem(itemId);
				}
				if (number == 4) {
					System.out.println("�� ��� �Ǹ��� ����Ʈ�Դϴ� ��");
					UsedItemController.getAllSellers();
				}
				if (number == 5) {
					System.out.println("�� ��� ������ ����Ʈ�Դϴ� ��");
					UsedItemController.getAllBuyers();
				}
				if (number == 6) {
					System.out.println("�� (����)�����Ϸ���'���� ID'�Է�! ��");
					String itemId = search.readLine();
					System.out.println("�� �����Ϸ���'���� ����'�Է�! ��");
					String itemPrice = search.readLine();
					UsedItemController.updateUsedItemPrice(itemId, itemPrice);
					System.out.println("�� ������ �����Ǿ����ϴ�! ��");
					UsedItemController.getUsedItem(itemId);
				}
				if (number == 7) {
					System.out.println("�� '�ŷ����¸� ������ '���� ID'�Է�! ��");
					String itemId = search.readLine();
					System.out.println("�� (�Ǹ���/������/�ǸſϷ�)�� �ϳ��� �Է�! ��");
					String dealStatus = search.readLine();
					UsedItemController.updateUsedItemStatus(itemId, dealStatus);
					System.out.println("�� �ŷ� ���°� �����Ǿ����ϴ�! ��");
					UsedItemController.getUsedItem(itemId);
				}
				if (number == 0) {
					finish = true;
					System.out.println("�߰�ŷ� �˻��� �����մϴ�:D");
				}
			} catch (Exception e) {
				System.out.println("ERROR: No such data. Please restart.");
				break;
			}
		}
		scan.close();
		try {
			search.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
