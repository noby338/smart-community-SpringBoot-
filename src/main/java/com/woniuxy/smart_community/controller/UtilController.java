package com.woniuxy.smart_community.controller;

import com.github.pagehelper.PageInfo;
import com.woniuxy.smart_community.entity.ResponseResult;
import com.woniuxy.smart_community.entity.UtilPrice;
import com.woniuxy.smart_community.service.UtilPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description 单价controller
 * @Author noby
 * @Date 2022/7/7 10:30
 */
@CrossOrigin
@RestController
@RequestMapping("/utilPrice")
public class UtilController {
    @Autowired
    UtilPriceService utilPriceService;

    @GetMapping("/selectAll")
    public ResponseResult<List<UtilPrice>> selectAll() {
        List<UtilPrice> utilPrices = utilPriceService.selectAll();
        return new ResponseResult<>(200,"y",utilPrices);
    }
}
