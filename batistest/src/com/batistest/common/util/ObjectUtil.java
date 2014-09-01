package com.batistest.common.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.beanutils.BeanUtils;

public class ObjectUtil {

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static Object objectCopy(Object srcObject, Class<?> targetClass) {
        Object targetObject = null;
        if ((srcObject == null) || (targetClass == null)) {
            return null;
        }
        if (srcObject instanceof Collection) {
            Iterator iter = ((Collection) srcObject).iterator();
            Collection coll = new ArrayList();
            Object item = null;
            Object targetItem = null;
            while (iter.hasNext()) {
                item = iter.next();
                targetItem = _objectCopy(item, targetClass);
                coll.add(targetItem);
            }
            targetObject = coll;
        } else {
            targetObject = _objectCopy(srcObject, targetClass);
        }
        return targetObject;
    }

    private static Object _objectCopy(Object srcObject, Class<?> targetClass) {
        Object targetObject = null;
        try {
            targetObject = targetClass.newInstance();
            BeanUtils.copyProperties(targetObject, srcObject);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return targetObject;
    }
}
