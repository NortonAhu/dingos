package io.nortonahu.customhorizonviewpage.bean;

import android.database.Cursor;

import io.nortonahu.customhorizonviewpage.db.ItemsDataHelper;

/**
 * Author:    Hong Yu
 * Version    V1.0
 * Date:      2015/9/23 18:32.
 * Description:
 * Modification  History:
 * Date         	Author        		Version        	Description
 * -----------------------------------------------------------------------------------
 * Why & What is modified:
 */
public class DataItem {
    public int id;
    public String title;

    public DataItem() {
    }

    public DataItem(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public static DataItem fromCursor(Cursor cursor) {
        DataItem item = new DataItem();
        item.id = cursor.getInt(cursor.getColumnIndex(ItemsDataHelper.ItemsDBInfo.ID));
        item.title =cursor.getString(cursor.getColumnIndex(ItemsDataHelper.ItemsDBInfo.TITLE));
        return item;
    }
}
