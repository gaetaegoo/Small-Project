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

	// 모든 중고거래 검색
	public static void getAllUsedItemUploads() {
		try {
			RunEndView.uploadListView(UsedItemUploadDAO.getAllUsedItemUploads());
		} catch (SQLException e) {
			e.printStackTrace();
			RunEndView.showError("모든 중고 거래 검색 시 에러가 발생했습니다.");
		}
	}

	// 새로운 중고 거래 저장
	public static boolean addUsedItemUpload(UsedItemUploadDTO usedItemUpload) {
		boolean result = false;
		try {
			result = UsedItemUploadDAO.addUsedItemUpload(usedItemUpload);
			Log.uploadCheck("Success", usedItemUpload);
		} catch (SQLException e) {
			e.printStackTrace();
			RunEndView.showError("모든 중고 거래 저장 시 에러가 발생했습니다.");
		}
		return result;
	}

	// 모든 중고 물건 검색
	public static void getAllUsedItems() {
		try {
			RunEndView.uploadListView(UsedItemDAO.getAllUsedItems());
		} catch (SQLException e) {
			e.printStackTrace();
			RunEndView.showError("모든 중고 물건 검색 시 에러가 발생했습니다.");
		}
	}
	
	// 중고 물건 아이디로 물건 검색
	public static void getUsedItem(String usedItemId) {
		try {
			RunEndView.allView(UsedItemDAO.getUsedItem(usedItemId));
		} catch (SQLException e) {
			e.printStackTrace();
			RunEndView.showError("현재 ID로 해당 중고 물건 검색 오류");
		}
	}

	// 모든 판매자 검색
	public static void getAllSellers() {
		try {
			RunEndView.uploadListView(SellerDAO.getAllSellers());
		} catch (SQLException e) {
			e.printStackTrace();
			RunEndView.showError("모든 판매자 검색 시 에러가 발생했습니다.");
		}
	}

	// 모든 구매자 검색
	public static void getAllBuyers() {
		try {
			RunEndView.uploadListView(BuyerDAO.getAllBuyers());
		} catch (SQLException e) {
			e.printStackTrace();
			RunEndView.showError("모든 구매자 검색 시 에러가 발생했습니다.");
		}
	}

	// 중고 물건 아이디로 물건 가격 수정
	public static void updateUsedItemPrice(String usedItemId, String usedItemPrice) {
		try {
			boolean r = UsedItemService.updateUsedItemPrice(usedItemId, usedItemPrice);
			RunEndView.updateView(r, usedItemId);
			Log.itemPriceUpdateCheck("Success", usedItemId, usedItemPrice);
		} catch (SQLException e) {
			e.printStackTrace();
			RunEndView.showError("입력한 ID로 가격 변경 오류, 재시도 하세요!");
		} catch (NotExistException e) {
			e.printStackTrace();
			RunEndView.showError("입력한 ID 확인 후 재시도 하세요!");
		}
	}

	// 중고 물건 아이디로 물건 거래 상태 수정
	public static void updateUsedItemStatus(String usedItemId, String usedItemStatus) {
		try {
			boolean r = UsedItemService.updateDealStatus(usedItemId, usedItemStatus);
			RunEndView.updateView(r, usedItemId);
			Log.itemPriceUpdateCheck("Success", usedItemId, usedItemStatus);
		} catch (SQLException e) {
			e.printStackTrace();
			RunEndView.showError("현재 ID로 거래 상태 변경 오류, 재시도 하세요!");
		} catch (NotExistException e) {
			e.printStackTrace();
			RunEndView.showError("입력한 ID 확인 후 재시도 하세요!");
		}
	}

	// 실행 메뉴
	public void createMenu() {
		Scanner scan = new Scanner(System.in);
		BufferedReader search = new BufferedReader(new InputStreamReader(System.in));

		boolean finish = false;
		while (!finish) {
			System.out.println("\n  [[ W.E.L.C.O.M.E '진 상 마 켓' ]]\n"
								+ "=================================="
								+ "\n  ■ ■ ■ 원하는 항목을 선택:D ■ ■ ■\n"
								+ "\n 1. 모든 중고 거래 검색"
								+ "\n 2. 모든 중고 물건 검색"
								+ "\n 3. 특정 중고 물건 검색"
								+ "\n"
								+ "\n 4. 모든 판매자 검색"
								+ "\n 5. 모든 구매자 검색"
								+ "\n"
								+ "\n 6. 물건 가격 수정 및 재검색"
								+ "\n 7. 거래 상태 수정 및 재검색"
								+ "\n"
								+ "\n 0. SYSTEM 종료"
								+ "\n==================================\n");
			try {
				int number = scan.nextInt();

				if (number == 1) {
					System.out.println("■ 모든 중고거래 리스트입니다 ■");
					UsedItemController.getAllUsedItemUploads();
				}
				if (number == 2) {
					System.out.println("■ 모든 중고물건 리스트입니다 ■");
					UsedItemController.getAllUsedItems();
				}
				if (number == 3) {
					System.out.println("■ 물건의 ID를 입력하세요 ■");
					String itemId = search.readLine();
					UsedItemController.getUsedItem(itemId);
				}
				if (number == 4) {
					System.out.println("■ 모든 판매자 리스트입니다 ■");
					UsedItemController.getAllSellers();
				}
				if (number == 5) {
					System.out.println("■ 모든 구매자 리스트입니다 ■");
					UsedItemController.getAllBuyers();
				}
				if (number == 6) {
					System.out.println("■ (가격)수정하려는'물건 ID'입력! ■");
					String itemId = search.readLine();
					System.out.println("■ 수정하려는'물건 가격'입력! ■");
					String itemPrice = search.readLine();
					UsedItemController.updateUsedItemPrice(itemId, itemPrice);
					System.out.println("■ 가격이 수정되었습니다! ■");
					UsedItemController.getUsedItem(itemId);
				}
				if (number == 7) {
					System.out.println("■ '거래상태를 변경할 '물건 ID'입력! ■");
					String itemId = search.readLine();
					System.out.println("■ (판매중/예약중/판매완료)중 하나를 입력! ■");
					String dealStatus = search.readLine();
					UsedItemController.updateUsedItemStatus(itemId, dealStatus);
					System.out.println("■ 거래 상태가 수정되었습니다! ■");
					UsedItemController.getUsedItem(itemId);
				}
				if (number == 0) {
					finish = true;
					System.out.println("중고거래 검색을 종료합니다:D");
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
