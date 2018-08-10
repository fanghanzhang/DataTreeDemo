package com.ironghui.datatree.utils;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;

import com.ironghui.datatree.DataBean.Contact;

import org.litepal.util.LogUtil;

import java.util.ArrayList;

/**
 * Created by ZhangFangHan on 2018/5/14.
 */

public class ContactUtils {
    Cursor c;

    public ArrayList<Contact> getContact(Activity context) {
        ArrayList<Contact> listMembers = new ArrayList<Contact>();
        Cursor cursor = null;
        try {

            Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
            // 这里是获取联系人表的电话里的信息  包括：名字，名字拼音，联系人id,电话号码；
            // 然后在根据"sort-key"排序
            cursor = context.getContentResolver().query(
                    uri,
                    new String[] { "display_name", "sort_key", "contact_id",
                            "data1" }, null, null, "sort_key");

            if (cursor.moveToFirst()) {
                do {
                    Contact contact = new Contact();
                    String contact_phone = cursor
                            .getString(cursor
                                    .getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                    String name = cursor.getString(0);
                    String sortKey = getSortKey(cursor.getString(1));
                    int contact_id = cursor
                            .getInt(cursor
                                    .getColumnIndex(ContactsContract.CommonDataKinds.Phone.CONTACT_ID));
                    contact.contact_name = name;
                    contact.sortKey = sortKey;
                    contact.contact_phone = contact_phone;
                    contact.setContact_id(contact_id);
                    if (name != null)
                        listMembers.add(contact);
                } while (cursor.moveToNext());
                c = cursor;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            context = null;
        }
        return listMembers;
    }
    private static String getSortKey(String sortKeyString) {
        String key = sortKeyString.substring(0, 1).toUpperCase();
        if (key.matches("[A-Z]")) {
            return key;
        }
        return "#";
    }
}
