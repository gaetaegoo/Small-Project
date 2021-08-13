package log4j;

import org.apache.log4j.Logger;

import useditem.model.dto.UsedItemUploadDTO;

public class Log {
	static Logger logger = Logger.getLogger("log4j.Log");

	// 판매&구매 글 등록 로그 기록
	public static void uploadCheck(String message, UsedItemUploadDTO usedItemUpload) {
		if (message.equals("Success")) {
			logger.info("새로운 글 생성!, Log 기록 완료!\n=>" + usedItemUpload);
		}
	}

//	// 판매자 정보 변경 로그 기록
//	public static void sellerUpdateCheck(String message, SellerDTO seller) {
//		if(message.equals("Success")){
//			logger.info("ㅡㅡㅡ '판매자' 정보가 수정되었습니다. 확인해 주세요. ㅡㅡㅡ   \n\t\t\t---> 수정된 판매자 정보: " + "'" + seller + "'");		
//		}
//	}
//
//	// 구매자 정보 변경 로그 기록
//	public static void buyerUpdateCheck(String message, BuyerDTO buyer) {
//		if(message.equals("Success")){ 
//			logger.info("ㅡㅡㅡ '구매자' 정보가 수정되었습니다. 확인해 주세요. ㅡㅡㅡ   \n\t\t\t---> 수정된 구매자 정보: " + "'" + buyer + "'");		
//		}
//	}

	// 물건 가격 정보 변경 로그 기록
	public static void itemPriceUpdateCheck(String message, String usedItemId, String usedItemPrice) {
		if (message.equals("Success")) {
			logger.info("\n" + "업데이트 된 글 생성!, Log 기록 완료!\n=>" + "'" + usedItemId + "' 가격이 '" + usedItemPrice
					+ "'으로 수정됨!" + "\n");
		}
	}

	// 물건 거래 상태 정보 변경 로그 기록
	public static void itemStatusUpdateCheck(String message, String usedItemId, String usedItemStatus) {
		if (message.equals("Success")) {
			logger.info("\n" + "업데이트 된 글 생성!, Log 기록 완료!\n" + "'" + usedItemId + "' 거래 상태가 '" + usedItemStatus
					+ "'으로 수정됨!" + "\n");
		}
	}
	
}