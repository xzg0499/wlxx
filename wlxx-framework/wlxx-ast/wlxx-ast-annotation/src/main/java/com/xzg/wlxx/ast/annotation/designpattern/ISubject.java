package com.xzg.wlxx.ast.annotation.designpattern;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public interface ISubject<T> {
    void add(Object observer);

    void remove(Object observer);

    void clear();

    T asNotifier();

    @SuppressWarnings("unused")
    class Stub<T> implements ISubject<T> {
        @SuppressWarnings("WeakerAccess")
        protected final ArrayList<T> mObservers = new ArrayList<>();
        @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
        private Map<Class<?>, ?> mNotifierCache = new HashMap<>();

        @SuppressWarnings({"unchecked"})
        @Override
        public void add(Object observer) {
            //noinspection RedundantCast
            if (!mObservers.contains((T) observer)) {
                mObservers.add((T) observer);
            }
        }

        @SuppressWarnings({"unchecked"})
        @Override
        public void remove(Object observer) {
            //noinspection RedundantCast
            if (mObservers.contains((T) observer)) {
                mObservers.remove(observer);
            }
        }

        @Override
        public void clear() {
            mObservers.clear();
        }

        @SuppressWarnings({"unchecked"})
        @Override
        public T asNotifier() {
            Class<T> clazz = getTypeParam();

            if (mNotifierCache.get(clazz) != null) {
                return (T) mNotifierCache.get(clazz);
            }
            //noinspection Convert2Lambda
            T notifier = (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    for (T observer : mObservers) {
                        method.invoke(observer, args);
                    }
                    return null;
                }
            });

            ((Map) mNotifierCache).put(clazz, notifier);
            return notifier;
        }

        @SuppressWarnings({"unchecked"})
        private Class<T> getTypeParam() {
            return (Class<T>) getParameterUpperBound(0, ((ParameterizedType) this.getClass().getGenericSuperclass()));
        }

        /**
         * copy from retrofit.Utils
         */
        @SuppressWarnings("SameParameterValue")
        private static Type getParameterUpperBound(int index, ParameterizedType type) {
            Type[] types = type.getActualTypeArguments();
            if (index < 0 || index >= types.length) {
                throw new IllegalArgumentException(
                        "Index " + index + " not in range [0," + types.length + ") for " + type);
            }
            Type paramType = types[index];
            if (paramType instanceof WildcardType) {
                return ((WildcardType) paramType).getUpperBounds()[0];
            }
            return paramType;
        }
    }
}
