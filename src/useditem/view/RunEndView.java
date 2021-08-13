package useditem.view;

import java.util.ArrayList;

import useditem.model.dto.UsedItemUploadDTO;

public class RunEndView {
	// 모든 중고 거래 출력
	public static void uploadListView(ArrayList allUsedItemUpload) {
		if (allUsedItemUpload != null) {
			int length = allUsedItemUpload.size();

			if (length != 0) {
				for (int index = 0; index < length; index++) {
//					System.out.println("<검색 정보> " + (index + 1) + "-" + allUsedItemUpload.get(index));
					System.out.println("\n<검색 정보> " + (index + 1) + "\n" + allUsedItemUpload.get(index));
				}
			} else {
				System.out.println("요청하신 정보는 표시할 수 없습니다.\n");
			}
		} else {
			System.out.println("요청하신 정보는 표시할 수 없습니다.\n");
		}
	}

	// 특정 중고 거래 출력
	public static void uploadView(UsedItemUploadDTO upload) {
		System.out.println(upload);
	}

	// 모든 DTO 정보 출력
	public static void allView(Object data) {
		if (data != null) {
			System.out.println(data);
		} else {
			System.out.println("");
		}
	}

	// 정보 수정 성공, 실패 시 메세지 출력
	public static void updateView(boolean result, String id) {
		if (result) {
			System.out.println("■ 성공적으로 수정되었습니다! ■\n");
		} else {
			System.out.println("■ 수정 실패, ID를 재확인 해주세요! ■\n");
		}
	}

	// 예외 상황 출력
	public static void showError(String message) {
		System.out.println(message);
	}
}