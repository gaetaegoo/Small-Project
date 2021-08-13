package useditem.view;

import java.util.ArrayList;

import useditem.model.dto.UsedItemUploadDTO;

public class RunEndView {
	// ��� �߰� �ŷ� ���
	public static void uploadListView(ArrayList allUsedItemUpload) {
		if (allUsedItemUpload != null) {
			int length = allUsedItemUpload.size();

			if (length != 0) {
				for (int index = 0; index < length; index++) {
//					System.out.println("<�˻� ����> " + (index + 1) + "-" + allUsedItemUpload.get(index));
					System.out.println("\n<�˻� ����> " + (index + 1) + "\n" + allUsedItemUpload.get(index));
				}
			} else {
				System.out.println("��û�Ͻ� ������ ǥ���� �� �����ϴ�.\n");
			}
		} else {
			System.out.println("��û�Ͻ� ������ ǥ���� �� �����ϴ�.\n");
		}
	}

	// Ư�� �߰� �ŷ� ���
	public static void uploadView(UsedItemUploadDTO upload) {
		System.out.println(upload);
	}

	// ��� DTO ���� ���
	public static void allView(Object data) {
		if (data != null) {
			System.out.println(data);
		} else {
			System.out.println("");
		}
	}

	// ���� ���� ����, ���� �� �޼��� ���
	public static void updateView(boolean result, String id) {
		if (result) {
			System.out.println("�� ���������� �����Ǿ����ϴ�! ��\n");
		} else {
			System.out.println("�� ���� ����, ID�� ��Ȯ�� ���ּ���! ��\n");
		}
	}

	// ���� ��Ȳ ���
	public static void showError(String message) {
		System.out.println(message);
	}
}