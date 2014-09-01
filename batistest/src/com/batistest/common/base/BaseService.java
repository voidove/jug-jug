package com.batistest.common.base;

import com.batistest.common.util.ObjectUtil;

public abstract class BaseService {

    protected Object copyObject(Object srcObject, Class<?> clz) {
        return ObjectUtil.objectCopy(srcObject, clz);
    }
}
