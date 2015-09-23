package io.nortonahu.customhorizonviewpage.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.provider.BaseColumns;
import android.support.v4.content.CursorLoader;

import java.util.ArrayList;
import java.util.List;

import io.nortonahu.customhorizonviewpage.bean.DataItem;
import io.nortonahu.customhorizonviewpage.db.database.Column;
import io.nortonahu.customhorizonviewpage.db.database.SQLiteTable;

/**
 * Author:    Hong Yu
 * Version    V1.0
 * Date:      2015/9/23 17:06.
 * Description:
 * Modification  History:
 * Date         	Author        		Version        	Description
 * -----------------------------------------------------------------------------------
 * Why & What is modified:
 */
public class ItemsDataHelper extends BaseDataHelper implements DBInterface<DataItem>{

    public ItemsDataHelper(Context context) {
        super(context);
    }

    @Override
    protected Uri getContentUri() {
        return DataProvider.ALL_ITEMS_CONTENT_URI;
    }

    @Override
    protected String getTableName() {
        return ItemsDBInfo.TABLE_NAME;
    }

    @Override
    public DataItem query(String id) {
        DataItem item = null;
        Cursor cursor;
        cursor = query(null, ItemsDBInfo.ID + "= ?",
                new String[]{
                        id
                }, null);
        if (cursor.moveToFirst()) {
            item = DataItem.fromCursor(cursor);
        }
        cursor.close();
        return item;
    }

    @Override
    public int clearAll() {
        synchronized (DataProvider.obj) {
            DataProvider.DBHelper mDBHelper = DataProvider.getDBHelper();
            SQLiteDatabase db = mDBHelper.getWritableDatabase();
            return db.delete(ItemsDBInfo.TABLE_NAME, null, null);
        }
    }

    @Override
    public void bulkInsert(List<DataItem> listData) {
        ArrayList<ContentValues> contentValues = new ArrayList<>();
        for (DataItem item : listData) {
            ContentValues values = getContentValues(item);
            contentValues.add(values);
        }
        ContentValues[] valueArray = new ContentValues[contentValues.size()];
        bulkInsert(contentValues.toArray(valueArray));
    }

    @Override
    public ContentValues getContentValues(DataItem data) {
        ContentValues values = new ContentValues();
        values.put(ItemsDBInfo.ID, data.id);
        values.put(ItemsDBInfo.TITLE, data.title);
        return values;
    }

    @Override
    public CursorLoader getCursorLoader() {
        return new CursorLoader(getContext(), getContentUri(), null, null, null, ItemsDBInfo.ID + " ASC");
    }

    public static final class ItemsDBInfo implements BaseColumns {
        private ItemsDBInfo() {
        }

        public static final String TABLE_NAME = "items";

        public static final String ID = "id";

        public static final String TITLE = "title";

        public static final SQLiteTable TABLE = new SQLiteTable(TABLE_NAME)
                .addColumn(ID, Column.DataType.INTEGER)
                .addColumn(TITLE, Column.DataType.TEXT);
    }
}
