package io.nortonahu.customhorizonviewpage.db.database;

/**
 * Author:    Hong Yu
 * Version    V1.0
 * Date:      2015/9/23 17:25.
 * Description: 数据库表每一列
 * Modification  History:
 * Date         	Author        		Version        	Description
 * -----------------------------------------------------------------------------------
 * Why & What is modified:
 */
public class Column {

    /**
     * 限制符
     */
    public static enum Constraint {
        UNIQUE("UNIQUE"),
        NOT("NOT"),
        NULL("NULL"),
        CHECK("CHECK"),
        FOREIGN_KEY("FOREIGN_KEY"),
        PRIMARY_KEY("PRIMARY_KEY");

        private String value;

        private Constraint(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    /**
     * Null,Integer,Real(浮点数)，Text,BLOB(二进制对象)
     *   NULL: 表示一个NULL值
     *
     * INTEGER: 用来存储一个整数,根据大小可以使用1,2,3,4,6,8位来存储.
     *
     * REAL: IEEE 浮点数
     *
     * TEXT: 按照字符串来存储
     *
     * BLOB: 按照二进制值存储,不做任何改变
     * 这些类型是值本身的属性,而不是列的属性
     * http://blog.knowsky.com/248692.htm
     */
    public static enum DataType {
        NULL, INTEGER, REAL, TEXT, BLOB
    }

    private String mColumnName;

    private Constraint mConstraint;

    private DataType mDataType;

    public Column(String mColumnName, Constraint mConstraint, DataType mDataType) {
        this.mColumnName = mColumnName;
        this.mConstraint = mConstraint;
        this.mDataType = mDataType;
    }

    public Constraint getConstraint() {
        return mConstraint;
    }

    public String getColumnName() {
        return mColumnName;
    }

    public DataType getDataType() {
        return mDataType;
    }
}
