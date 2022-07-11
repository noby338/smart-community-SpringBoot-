package com.woniuxy.smart_community.controller;

import com.woniuxy.smart_community.entity.House;
import com.woniuxy.smart_community.entity.HouseInfo;
import com.woniuxy.smart_community.entity.ResponseEntity;
import com.woniuxy.smart_community.service.HouseService;
import com.woniuxy.smart_community.service.impl.HouseServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author :  Fiver_Hu
 * @Date : 2022/7/6 11:28 星期三
 * @Project_Name -> smart-community
 * @Package_Name -> com.woniuxy.smart_community.controller
 * @ClassName -> HouseController
 * @Version 1.0
 **/

@ResponseBody
@RestController
@RequestMapping("/house")
public class HouseController {

    @Autowired
    HouseService houseService  = new HouseServiceImpl();

//    /**
//     * 通过主键修改房间信息数据
//     *
//     * @param  实例对象
//     * @return 影响行数
//     */
//    @PostMapping("/updateHouse")
//     public ResponseEntity updateHouse(@Param("houseInfo") HouseInfo houseInfo){
//         ResponseEntity response = houseService.updateHouse(house);
//         System.out.println(response);
//         return response;
//     }

//    /**
//     * 通过房间信息查询相关数据
//     *
//     * @param house 房间号
//     * @return 实例对象
//     */
//    @GetMapping("/selectAllHouse")
//    public ResponseEntity selectHouseByHouseInfo(
//            @Param("house") House house,
//            @Param("pageNum")  int pageNum,
//            @Param("pageSize")  int pageSize){
//        ResponseEntity response = houseService.selectHouse(@Param("houseInfo"HouseInfo houseInfo, pageNum, pageSize);
//        System.out.println(response);
//        return response;
//    }



}
