package com.example.myapplication.utils;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class PhoneTextUtil {
    private static final char SEPARATOR = ' ';
    private static final int FIRST_SEPARATOR_POSITION = 3;
    private static final int SECOND_SEPARATOR_POSITION = 7;

    public static void setPhoneStyleEt(EditText et){
        et.addTextChangedListener(new PhoneEtListener(et));
    }

    public static class PhoneEtListener implements TextWatcher {
        private EditText editText;

        public PhoneEtListener(EditText editText) {
            this.editText = editText;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            Editable phoneNumberEditable = editText.getEditableText();
            if (before == 1) {
                if ((start == FIRST_SEPARATOR_POSITION) || (start == (SECOND_SEPARATOR_POSITION + 1))) {
                    return;
                }
            }
            switch (parsePhoneNumber(phoneNumberEditable.toString())) {
                case 1:
                    int oneInvalidSeparatorIndex = getOneInvalidSeparatorIndex(phoneNumberEditable.toString());
                    phoneNumberEditable.delete(oneInvalidSeparatorIndex, oneInvalidSeparatorIndex + 1);//删除该“-”
                    break;

                case 2:
                    phoneNumberEditable.insert(FIRST_SEPARATOR_POSITION, String.valueOf(SEPARATOR));
                    break;

                case 3:
                    phoneNumberEditable.insert(SECOND_SEPARATOR_POSITION + 1, String.valueOf(SEPARATOR));
                    break;

                case 4:
                    phoneNumberEditable.delete(phoneNumberEditable.length() - 1, phoneNumberEditable.length());
                    break;

                case -1:
                case 0:
                default:
                    break;
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    }

    private static int parsePhoneNumber(String phoneNumber) {
        if (phoneNumber == null) {//如果传入字符串为空，则返回-1
            return -1;
        }

        if (getOneInvalidSeparatorIndex(phoneNumber) != -1) {//除index = 3和8是“-”以外，其他位置有“-”时，按1处理
            return 1;
        }

        if ((phoneNumber.length() > FIRST_SEPARATOR_POSITION)//字符数超3个，同时index=3的字符不是“-”，则按2来处理
                && (phoneNumber.charAt(FIRST_SEPARATOR_POSITION) != SEPARATOR)) {
            return 2;
        }
        if ((phoneNumber.length() > (SECOND_SEPARATOR_POSITION + 1))//字符数超8个，同时index=8的字符不是“-”，则按3来处理
                && (phoneNumber.charAt(SECOND_SEPARATOR_POSITION + 1) != SEPARATOR)) {
            return 3;
        }

//      if ((phoneNumber.length() == (FIRST_SEPARATOR_POSITION + 1))
//              || (phoneNumber.length() == (SECOND_SEPARATOR_POSITION + 1 + 1))) {
//          return 4;
//      }
        if(phoneNumber.length()>13)//超过长度，按4处理
        {
            return 4;
        }

        return 0;
    }

    /**
     * 除index = 3和8是“-”以外，其他位置有“-”时，返回该index
     * @param phoneNumber
     * @return
     */

    private static int getOneInvalidSeparatorIndex(String phoneNumber) {
        if (phoneNumber == null) {//如果传入字符串为null则直接返回-1
            return -1;
        }
        //遍历传入的字符串
        for (int index = 0; index < phoneNumber.length(); index++) {
            //如果遍历到的字符处于3的位置和8的位置，则直接遍历下一个
            if ((index == FIRST_SEPARATOR_POSITION) || (index == (SECOND_SEPARATOR_POSITION + 1))) {
                continue;
            }
            //如果遍历到的的字符是分隔符，则返回此字符位置
            if (phoneNumber.charAt(index) == SEPARATOR) {
                return index;
            }
        }
        //如果没有位置错误的分隔符，则返回-1
        return -1;
    }

}
