package com.xzg.wlxx.library.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author XiaoZG
 */
@RestController
@Tag(name = "category")
@RequestMapping("category")
@RequiredArgsConstructor
public class CategoryController {
}
