package cn.jsonlu.lib.data.param;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Locale;

/**
 * Author:JsonLu
 * DateTime:17/5/10 10:52
 * Email:jsonlu@qq.com
 * Desc:
 **/
public class BaseParam implements Serializable{

    @Override
    public String toString() {
        String[] fields = getFieldsName();
        StringBuilder buffer = new StringBuilder();
        for (String field : fields) {
            Object value = invokeMethod(this, field);
            if (null != value) {
                buffer.append(field + "=" + value + "&");
            }
        }
        if (buffer.lastIndexOf("&") == (buffer.length() - 1)) {
            buffer.setLength(buffer.length() - 1);
        }
        return buffer.toString();
    }

    private String[] getFieldsName() {
        Field[] superFields = getClass().getSuperclass().getDeclaredFields();
        Field[] fields = getClass().getDeclaredFields();
        String[] fieldsName = new String[superFields.length + fields.length];
        for (int i = 0; i < superFields.length; i++) {
            fieldsName[i] = superFields[i].getName();
        }
        for (int i = 0; i < fields.length; i++) {
            fieldsName[superFields.length + i] = fields[i].getName();
        }
        Arrays.sort(fieldsName);
        return fieldsName;
    }

    private Object invokeMethod(Object owner, String fieldName) {
        Class<? extends Object> ownerClass = owner.getClass();
        String methodName = fieldName.substring(0, 1).toUpperCase(Locale.getDefault()) + fieldName.substring(1);
        try {
            Method method = ownerClass.getMethod("get" + methodName);
            Object data = method.invoke(owner);
            return data != null && "".equals(data.toString()) ? data : null;
        } catch (Exception e) {

        }
        return null;
    }
}
