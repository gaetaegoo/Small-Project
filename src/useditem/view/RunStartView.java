package useditem.view;

import useditem.controller.UsedItemController;

public class RunStartView {

	public static void main(String[] args) {
		UsedItemController controller = UsedItemController.getInstance();
		controller.createMenu();
	}
}