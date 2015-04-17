package com.panerabread.auit.pages;

public interface MenuCategory extends PageWithMenuFrame {
	MenuCategory orderItem(String name);
	MenuCategory orderYP2Combo(String pick1Category, String pick1, String pick2Category, String pick2);
	MenuCategory orderCombo(String pick1, String pick2);
}
