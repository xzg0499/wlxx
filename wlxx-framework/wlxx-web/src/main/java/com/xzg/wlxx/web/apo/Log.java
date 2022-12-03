package com.xzg.wlxx.web.apo;

import java.lang.annotation.*;

/**
 * @author xzgan
 * @project wlxx
 * @package com.xzg.wlxx.web.apo
 * @date 2022/12/3 15:26
 */
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
}
